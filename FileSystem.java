package community.krynet.compat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class FileSystem {

    private FileSystem() {}

    public static Path dataDirectory() {
        String home = System.getProperty(
            "user.home",
            "."
        );

        return Path.of(
            home,
            ".krynet"
        );
    }

    public static Path resolve(
        String path
    ) {
        return dataDirectory().resolve(path);
    }

    public static void createDirectories(
        Path path
    ) throws IOException {
        Files.createDirectories(path);
    }

    public static void write(
        Path path,
        byte[] data
    ) throws IOException {
        Files.write(path, data);
    }

    public static byte[] read(
        Path path
    ) throws IOException {
        return Files.readAllBytes(path);
    }

    public static boolean exists(
        Path path
    ) {
        return Files.exists(path);
    }

    public static void delete(
        Path path
    ) throws IOException {
        Files.deleteIfExists(path);
    }
}
