package community.krynet.compat;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Krynet {

    private static final Map<Integer, Integer> OPTIONS =
        new ConcurrentHashMap<>();

    private Krynet() {}

    public static final int SET_GFX_LAYER = 1;
    public static final int SET_SCRIPT_RUNTIME_FEATURES = 2;
    public static final int SET_NETWORK_MODE = 3;
    public static final int SET_WINDOW_MODE = 4;

    public static final int GFX_SOFTWARE = 1;
    public static final int GFX_HARDWARE = 2;
    public static final int GFX_AUTO = 3;

    public static final int ALLOW_SOCKET_IO = 1;
    public static final int ALLOW_HTTP_IO = 1 << 1;
    public static final int ALLOW_WEBSOCKET_IO = 1 << 2;

    public static final int NETWORK_DEFAULT = 0;
    public static final int NETWORK_SECURE = 1;

    public static final int WINDOW_DEFAULT = 0;
    public static final int WINDOW_FULLSCREEN = 1;

    public static boolean setOption(int option, int value) {
        Compat.requireInitialized();

        if (!isValidOption(option, value)) {
            return false;
        }

        OPTIONS.put(option, value);
        return true;
    }

    public static int getOption(int option) {
        Compat.requireInitialized();

        return OPTIONS.getOrDefault(option, 0);
    }

    public static boolean hasOption(int option) {
        return OPTIONS.containsKey(option);
    }

    private static boolean isValidOption(
        int option,
        int value
    ) {
        return switch (option) {
            case SET_GFX_LAYER ->
                value == GFX_SOFTWARE ||
                value == GFX_HARDWARE ||
                value == GFX_AUTO;

            case SET_SCRIPT_RUNTIME_FEATURES ->
                value >= 0;

            case SET_NETWORK_MODE ->
                value == NETWORK_DEFAULT ||
                value == NETWORK_SECURE;

            case SET_WINDOW_MODE ->
                value == WINDOW_DEFAULT ||
                value == WINDOW_FULLSCREEN;

            default -> false;
        };
    }
}
