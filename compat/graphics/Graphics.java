package community.krynet.compat;

public final class Graphics {

    public enum Layer {
        SOFTWARE,
        HARDWARE,
        AUTO
    }

    private static Layer layer = Layer.AUTO;

    private Graphics() {}

    public static void setLayer(Layer value) {
        if (value == null) {
            throw new IllegalArgumentException(
                "Graphics layer cannot be null"
            );
        }

        layer = value;
    }

    public static Layer layer() {
        return layer;
    }

    public static boolean hardwareAccelerated() {
        return layer == Layer.HARDWARE ||
               layer == Layer.AUTO;
    }
}
