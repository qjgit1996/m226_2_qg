package grafikeditor_0;

import grafikeditor_0.figuren.*;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Grafikeditor {
    private static final Display display = new Display();

    public static void main(String[] args) throws IOException {
        Color farbe = new Color(120,112,34);
        ArrayList<Figur> figs = new ArrayList<Figur>();
        figs.add(new Linie(700, 400, 500, 500, farbe));
        figs.add(new Rechteck(300, 150, 200, 600, farbe, false));
        figs.add(new Kreis(100, 300, 20));
        //figs.add(new Dreieck(2,5,57,47,123,112));
        Zeichnung zeichnung = new Zeichnung(figs);


        display.setZeichnung(zeichnung);
        //display.zeichnung.save(new Dreieck(2,5,57,47,123,112));
        display.zeichnung.load("/Users/quintengroenveld/Documents/m226_2_qg/figuren/figur1.txt");
    }
}
