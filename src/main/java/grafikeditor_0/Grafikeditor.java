package grafikeditor_0;

import grafikeditor_0.figuren.*;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public final class Grafikeditor {

    public static void main(String[] args) {
        new Grafikeditor();
    }

    private Grafikeditor() {
        @SuppressWarnings("unused")
        EditorFrame frame = new EditorFrame(800, 600);
        frame.focusSetzen();
    }
}

