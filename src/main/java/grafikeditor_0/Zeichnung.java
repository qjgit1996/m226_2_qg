package grafikeditor_0;

import grafikeditor_0.figuren.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Zeichnung extends Display{
    /**
     * Die Liste der dargestellten Figur-Objekte
     */
    private ArrayList<Figur> figuren;

    public Zeichnung(ArrayList<Figur> figs) {
        figuren = figs;
    }

    public void hinzufuegen(Figur fig) {
        figuren.add(fig);
        repaint();
    }

    public void entfernen(Figur fig) {
        figuren.remove(fig);
        repaint();
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

    public void createAndAddDrawingPanel() {
        // Das JPanel-Objekt ist ein Objekt einer anonymen Unterklasse von JPanel
        // Siehe Java-Grundkurs Abschnitt 3.9
        add(new JPanel() {
            // Die paintComponent()-Methode wird automatisch aufgerufen, wenn irgendwer die repaint()-
            // Methode beim Dsiplay aufruft.
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                zeichneFiguren(g);
            }
        });
    }

    public void save(Figur figur) {
        int anzahlDateien = Objects.requireNonNull(new File("/Users/quintengroenveld/Documents/m226_2_qg/figuren").list()).length - 1;
        File f = new File("/Users/quintengroenveld/Documents/m226_2_qg/figuren/figur" + (anzahlDateien-1) + ".txt");
        f.delete();
        BufferedWriter writer = null;
        try {
            String dateiName = "/Users/quintengroenveld/Documents/m226_2_qg/figuren/figur" + anzahlDateien + ".txt";
            File logFile = new File(dateiName);
            writer = new BufferedWriter(new FileWriter(logFile));
            if (figur instanceof Rechteck) {
                Rechteck r = (Rechteck) figur;
                writer.write("Figurtyp: Rechteck");
                writer.newLine();
                writer.write("Origin: " + r.getX() + " " + r.getY());
                writer.newLine();
                writer.write("Height/Width: " + r.getBreite() + " " + r.getHoehe());
                if (r.getFarbe() != null) {
                    writer.newLine();
                    writer.write("RGB: " + r.getFarbe().getRed() + " " + r.getFarbe().getGreen() + " " + r.getFarbe().getBlue());
                }
                writer.newLine();
                writer.write("Ausgefuellt: " + r.getAusgefuellt());
            }
            if (figur instanceof Linie) {
                Linie l = (Linie) figur;
                writer.write("Figurtyp: Linie");
                writer.newLine();
                writer.write("Origin: " + l.getX() + " " + l.getY());
                writer.newLine();
                writer.write("Height/Width: " + l.getBreite() + " " + l.getHoehe());
                if (l.getFarbe() != null) {
                    writer.newLine();
                    writer.write("RGB: " + l.getFarbe().getRed() + " " + l.getFarbe().getGreen() + " " + l.getFarbe().getBlue());
                }
            }
            if (figur instanceof Kreis) {
                Kreis k = (Kreis) figur;
                writer.write("Figurtyp: Kreis");
                writer.newLine();
                writer.write("Origin: " + k.getX() + " " + k.getY());
                writer.newLine();
                writer.write("Radius: " + k.getRadius());
                if (k.getFarbe() != null) {
                    writer.newLine();
                    writer.write("RGB: " + k.getFarbe().getRed() + " " + k.getFarbe().getGreen() + " " + k.getFarbe().getBlue());
                }
                writer.newLine();
                writer.write("Ausgefuellt: " + k.getAusgefuellt());
            }
            if (figur instanceof Dreieck) {
                Dreieck d = (Dreieck) figur;
                writer.write("Figurtyp: Dreieck");
                writer.newLine();
                writer.write("Origin: " + d.getX() + " " + d.getY());
                writer.newLine();
                writer.write("B: " + d.getLinkeSeite().getBreite() + " " + d.getLinkeSeite().getHoehe());
                writer.newLine();
                writer.write("C: " + d.getRechteSeite().getBreite() + " " + d.getRechteSeite().getHoehe());
                if (d.getFarbe() != null) {
                    writer.newLine();
                    writer.write("RGB: " + d.getFarbe().getRed() + " " + d.getFarbe().getGreen() + " " + d.getFarbe().getBlue());
                }
                writer.newLine();
                writer.write("Ausgefuellt: " + d.getAusgefuellt());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
    }

    public void load(String pfad) throws IOException {
        File file = new File(pfad);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String string;
        int i = 0;
        String figurTyp = null;
        int x = 0;
        int y = 0;
        int breite = 0;
        int hoehe = 0;
        int radius = 0;
        int x3 = 0;
        int y3 = 0;
        boolean aufgefuellt = false;
        Color farbe = Color.BLACK;

        while ((string = br.readLine()) != null) {
            String[] arrayString = string.split(" ");
            if (i == 0) {
                figurTyp = arrayString[1];
            }
            if (i == 1) {
                x = Integer.parseInt(arrayString[1]);
                y = Integer.parseInt(arrayString[2]);
            }
            if (i == 2) {
                if (arrayString.length == 3) {
                    breite = Integer.parseInt(arrayString[1]);
                    hoehe = Integer.parseInt(arrayString[2]);
                } else {
                    radius = Integer.parseInt(arrayString[1]);
                }
            }
            if (i == 3) {
                if (arrayString.length > 2 && !figurTyp.equals("Dreieck")) {
                    farbe = new Color(Integer.parseInt(arrayString[1]), Integer.parseInt(arrayString[2]), Integer.parseInt(arrayString[3]));
                }
                if (figurTyp.equals("Dreieck")) {
                    x3 = Integer.parseInt(arrayString[1]);
                    y3 = Integer.parseInt(arrayString[2]);
                }
                else {
                    aufgefuellt = Boolean.parseBoolean(arrayString[1]);
                }
            }
            if (i == 4) {
                if (arrayString.length > 2 && figurTyp.equals("Dreieck")) {
                    farbe = new Color(Integer.parseInt(arrayString[1]), Integer.parseInt(arrayString[2]), Integer.parseInt(arrayString[3]));
                }
                else {
                    aufgefuellt = Boolean.parseBoolean(arrayString[1]);
                }
            }
            if (i == 5) {
                aufgefuellt = Boolean.parseBoolean(arrayString[1]);
            }
            i++;
        }
        if (i == 3) {
            if (figurTyp.equals("Linie")) {
                this.hinzufuegen(new Linie(x, y, breite, hoehe));
            }
            if (figurTyp.equals("Kreis")) {
                this.hinzufuegen(new Kreis(x, y, radius));
            }
            if (figurTyp.equals("Rechteck")) {
                this.hinzufuegen(new Linie(x, y, breite, hoehe));
            }
        }
        if (i == 4) {
            if (figurTyp.equals("Linie")) {
                this.hinzufuegen(new Linie(x, y, breite, hoehe, farbe));
            }
            if (figurTyp.equals("Kreis")) {
                this.hinzufuegen(new Kreis(x, y, radius, farbe, aufgefuellt));
            }
            if (figurTyp.equals("Rechteck")) {
                this.hinzufuegen(new Rechteck(x, y, breite, hoehe, farbe, aufgefuellt));
            }
        }
        if (i == 5) {
            if (figurTyp.equals("Dreieck")) {
                this.hinzufuegen(new Dreieck(x, y, breite, hoehe, x3, y3, aufgefuellt, farbe));
            }
            if (figurTyp.equals("Kreis")) {
                this.hinzufuegen(new Kreis(x, y, radius, farbe, aufgefuellt));
            }
            if (figurTyp.equals("Rechteck")) {
                this.hinzufuegen(new Rechteck(x, y, breite, hoehe, farbe, aufgefuellt));
            }
        }
    }
}