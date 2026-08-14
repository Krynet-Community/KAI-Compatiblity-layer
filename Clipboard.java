package community.krynet.compat;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;

public final class Clipboard {

    private Clipboard() {}

    public static void setText(String text) {
        Compat.requireInitialized();

        if (text == null) {
            text = "";
        }

        java.awt.datatransfer.Clipboard clipboard =
            Toolkit.getDefaultToolkit()
                .getSystemClipboard();

        clipboard.setContents(
            new StringSelection(text),
            null
        );
    }

    public static String getText() {
        Compat.requireInitialized();

        try {
            java.awt.datatransfer.Clipboard clipboard =
                Toolkit.getDefaultToolkit()
                    .getSystemClipboard();

            if (!clipboard.isDataFlavorAvailable(
                DataFlavor.stringFlavor
            )) {
                return null;
            }

            return (String) clipboard.getData(
                DataFlavor.stringFlavor
            );

        } catch (Exception exception) {
            return null;
        }
    }
}
