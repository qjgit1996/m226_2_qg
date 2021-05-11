package grafikeditor_0;

import grafikeditor_0.figuren.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Zeichnung {
    /**
     * Die Liste der dargestellten Figur-Objekte
     */
    private ArrayList<Figur> figuren;

    public Zeichnung(ArrayList<Figur> figs) {
        figuren = figs;
    }

    public void hinzufuegen(Figur fig) {
        figuren.add(fig);
    }

    public void entfernen(Figur fig) {
        figuren.remove(fig);
    }

    /**
     * Zeichnet alle Figuren.
     *
     * @param g Referenz auf das Graphics-Objekt zum zeichnen.
     */
    public void zeichneFiguren(Graphics g) {
        for (Figur f : figuren) {
            f.zeichnen(g);
        }
    }

    public ArrayList<Figur> getFiguren() {
        return this.figuren;
    }

    public void arrayLeeren() {
        this.figuren.clear();
    }

    public void save(Figur figur) throws IOException {
        figur.save();
    }

    public void load(File file, EditorControl editorControl) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String string;
        String figurTyp = null;
        string = br.readLine();
        String[] arrayString = string.split(" ");
        figurTyp = arrayString[1];
        if (figurTyp.equals("Dreieck")) {
            new Dreieck().load(file, editorControl);
        }
        if (figurTyp.equals("Rechteck")) {
            new Rechteck().load(file, editorControl);
        }
        if (figurTyp.equals("Kreis")) {
            new Kreis().load(file, editorControl);
        }
        else {
            new Linie().load(file, editorControl);
        }

    }
}