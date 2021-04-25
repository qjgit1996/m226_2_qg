package grafikeditor_0;

import grafikeditor_0.figuren.Rechteck;

public class Grafikeditor {
    private static final Display display = new Display();

    public static void main(String[] args) {
        display.hinzufuegen(new Rechteck(300,300,100,100));
    }
}
