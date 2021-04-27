package grafikeditor_0;

import grafikeditor_0.figuren.Kreis;
import grafikeditor_0.figuren.Linie;
import grafikeditor_0.figuren.Rechteck;

import java.awt.*;

public class Grafikeditor {
    private static final Display display = new Display();

    public static void main(String[] args) {
        Color farbe = new Color(120,112,34);
        display.hinzufuegen(new Rechteck(300,300,100,100));
        display.hinzufuegen(new Linie(700, 400, 500, 500, farbe));
        display.hinzufuegen(new Kreis(100, 100, 20));
    }
}
