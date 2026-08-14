package community.krynet.compat;

import java.net.URI;
import java.util.concurrent.atomic.AtomicBoolean;

public class Window {

    public static final int TITLEBAR = 1;
    public static final int RESIZABLE = 1 << 1;
    public static final int CONTROLS = 1 << 2;
    public static final int MAIN = 1 << 3;
    public static final int MINIMIZABLE = 1 << 4;
    public static final int MAXIMIZABLE = 1 << 5;
    public static final int CLOSEABLE = 1 << 6;
    public static final int CENTERED = 1 << 7;

    private final int flags;
    private final AtomicBoolean open = new AtomicBoolean();

    private String url;
    private String title = "Krynet";
    private int width = 1024;
    private int height = 768;

    public Window(int flags) {
        Compat.requireInitialized();

        this.flags = flags;
    }

    public int flags() {
        return flags;
    }

    public boolean loadUrl(String url) {
        if (url == null || url.isBlank()) {
            return false;
        }

        try {
            URI.create(url);
        } catch (IllegalArgumentException exception) {
            return false;
        }

        this.url = url;
        return true;
    }

    public String url() {
        return url;
    }

    public void setTitle(String title) {
        if (title == null) {
            return;
        }

        this.title = title;
    }

    public String title() {
        return title;
    }

    public void setSize(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException(
                "Window dimensions must be positive"
            );
        }

        this.width = width;
        this.height = height;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public void expand() {
        open.set(true);
    }

    public void close() {
        open.set(false);
    }

    public boolean isOpen() {
        return open.get();
    }

    public int runApp() {
        open.set(true);

        while (open.get()) {
            Events.pump();
        }

        return 0;
    }
}
