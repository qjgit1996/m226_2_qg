package grafikeditor_0;

import grafikeditor_0.figuren.*;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

final class EditorControl {
    ArrayList<Figur> figs = new ArrayList<Figur>();
    private Zeichnung zeichnung = new Zeichnung(figs);
    private char figurTyp;
    private Point ersterPunkt;

    public void allesNeuZeichnen(Graphics g) {
        zeichnung.zeichneFiguren(g);
    }

    public void setFigurTyp(char figurTyp) {
        this.figurTyp = figurTyp;
    }

    public void setErsterPunkt(Point ersterPunkt) {
        this.ersterPunkt = ersterPunkt;
    }

    public void erzeugeFigurMitZweitemPunkt(Point zweiterPunkt) {
        if (figurTyp == 'k') {
            int rad = (int)Math.sqrt((double)Math.pow(Math.abs(ersterPunkt.x - zweiterPunkt.x),2) + (double)Math.pow(Math.abs(ersterPunkt.y - zweiterPunkt.y), 2));
            zeichnung.hinzufuegen(new Kreis(ersterPunkt.x, ersterPunkt.y, rad));
        }
        if (figurTyp == 'r') {
            Figur fig = new Rechteck(ersterPunkt.x, ersterPunkt.y, zweiterPunkt.x, zweiterPunkt.y);
            zeichnung.hinzufuegen(fig);
        }
        if (figurTyp == 'd') {
            zeichnung.hinzufuegen(new Dreieck(ersterPunkt.x, ersterPunkt.y, zweiterPunkt.x, zweiterPunkt.y));
        }
        if (figurTyp == 'l') {
            zeichnung.hinzufuegen(new Linie(ersterPunkt.x, ersterPunkt.y, zweiterPunkt.x, zweiterPunkt.y));
        }
    }
}
