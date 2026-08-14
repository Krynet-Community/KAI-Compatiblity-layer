package community.krynet.compat;

import community.krynet.compat.platform.PlatformBackend;

public final class Clipboard {

    private Clipboard() {}

    public static boolean supported() {
        Compat.requireInitialized();

        return PlatformBackend.current()
            .clipboard()
            .supported();
    }

    public static void setText(String text) {
        Compat.requireInitialized();

        if (text == null) {
            text = "";
        }

        PlatformBackend.current()
            .clipboard()
            .setText(text);
    }

    public static String getText() {
        Compat.requireInitialized();

        return PlatformBackend.current()
            .clipboard()
            .getText();
    }

    public interface Backend {

        boolean supported();

        void setText(String text);

        String getText();
    }
}
