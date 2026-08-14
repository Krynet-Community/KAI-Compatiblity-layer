package community.krynet.compat;

public final class Compat {

    private static boolean initialized;

    private Compat() {}

    public static synchronized boolean initialize() {
        if (initialized) {
            return true;
        }

        initialized = true;
        return true;
    }

    public static synchronized void shutdown() {
        if (!initialized) {
            return;
        }

        initialized = false;
    }

    public static boolean initialized() {
        return initialized;
    }

    public static Platform platform() {
        return Platform.current();
    }

    public static String version() {
        return "1.0.0";
    }

    public static String name() {
        return "Krynet Compat";
    }

    public static void requireInitialized() {
        if (!initialized) {
            throw new IllegalStateException(
                "Krynet Compat has not been initialized"
            );
        }
    }
}
