package grafikeditor_0;

import grafikeditor_0.figuren.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public final class EditorControl {
    ArrayList<Figur> figs = new ArrayList<Figur>();
    private Zeichnung zeichnung = new Zeichnung(figs);
    private char figurTyp;
    private Point ersterPunkt;
    private Color farbe;
    private boolean ausgefuellt = true;

    public Zeichnung getZeichnung() {
        return this.zeichnung;
    }

    public void allesNeuZeichnen(Graphics g) {
        zeichnung.zeichneFiguren(g);
    }

    public void setFigurTyp(char figurTyp) {
        this.figurTyp = figurTyp;
    }

    public void setErsterPunkt(Point ersterPunkt) {
        this.ersterPunkt = ersterPunkt;
    }

    public void setFarbe(Color col) {
        this.farbe = col;
    }

    public void setAusgefuellt(boolean ausgefuellt) {
        this.ausgefuellt = ausgefuellt;
    }

    public void load(File file) throws IOException {
        this.zeichnung.load(file, this);
    }

    public void arrayLeeren() {
        this.zeichnung.arrayLeeren();
    }

    public void save() throws IOException {
        for (int i = 0; i < this.zeichnung.getFiguren().size(); i++) {
            this.zeichnung.save(this.zeichnung.getFiguren().get(i));
        }
    }

    public void erzeugeFigurMitZweitemPunkt(Point zweiterPunkt) {
        if (figurTyp == 'k') {
            int rad = (int)Math.sqrt((double)Math.pow(Math.abs(ersterPunkt.x - zweiterPunkt.x),2) + (double)Math.pow(Math.abs(ersterPunkt.y - zweiterPunkt.y), 2));
            zeichnung.hinzufuegen(new Kreis(ersterPunkt.x, ersterPunkt.y, rad, this.farbe, this.ausgefuellt));
        }
        if (figurTyp == 'r') {
            Figur fig = new Rechteck(ersterPunkt.x, ersterPunkt.y, zweiterPunkt.x, zweiterPunkt.y, this.farbe, this.ausgefuellt);
            zeichnung.hinzufuegen(fig);
        }
        if (figurTyp == 'd') {
            zeichnung.hinzufuegen(new Dreieck(ersterPunkt.x, ersterPunkt.y, zweiterPunkt.x, zweiterPunkt.y, this.farbe, this.ausgefuellt));
        }
        if (figurTyp == 'l') {
            zeichnung.hinzufuegen(new Linie(ersterPunkt.x, ersterPunkt.y, zweiterPunkt.x, zweiterPunkt.y, this.farbe));
        }
    }
}
