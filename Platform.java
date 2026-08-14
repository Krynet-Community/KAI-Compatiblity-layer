package community.krynet.compat;

import java.util.Locale;

public enum Platform {
    WINDOWS,
    LINUX,
    MACOS,
    ANDROID,
    IOS,
    UNKNOWN;

    public static Platform current() {
        String os = System.getProperty("os.name", "")
                .toLowerCase(Locale.ROOT);

        if (os.contains("win")) {
            return WINDOWS;
        }

        if (os.contains("mac") || os.contains("darwin")) {
            return MACOS;
        }

        if (os.contains("linux")) {
            return LINUX;
        }

        if (os.contains("android")) {
            return ANDROID;
        }

        if (os.contains("ios")) {
            return IOS;
        }

        return UNKNOWN;
    }

    public boolean desktop() {
        return this == WINDOWS ||
               this == LINUX ||
               this == MACOS;
    }

    public boolean mobile() {
        return this == ANDROID ||
               this == IOS;
    }
}
