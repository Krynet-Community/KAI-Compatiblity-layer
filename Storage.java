package community.krynet.compat;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Storage {

    private static final Map<String, String> VALUES =
        new ConcurrentHashMap<>();

    private Storage() {}

    public static void set(
        String key,
        String value
    ) {
        Compat.requireInitialized();

        if (key == null || value == null) {
            throw new IllegalArgumentException(
                "Storage key and value cannot be null"
            );
        }

        VALUES.put(key, value);
    }

    public static String get(String key) {
        Compat.requireInitialized();

        return VALUES.get(key);
    }

    public static String get(
        String key,
        String fallback
    ) {
        String value = get(key);

        return value == null ? fallback : value;
    }

    public static boolean contains(String key) {
        Compat.requireInitialized();

        return VALUES.containsKey(key);
    }

    public static void remove(String key) {
        Compat.requireInitialized();

        VALUES.remove(key);
    }

    public static void clear() {
        Compat.requireInitialized();

        VALUES.clear();
    }
}
