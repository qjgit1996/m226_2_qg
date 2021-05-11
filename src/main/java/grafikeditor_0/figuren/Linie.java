package grafikeditor_0.figuren;

import grafikeditor_0.EditorControl;

import java.awt.*;
import java.io.*;
import java.util.Objects;

public class Linie extends Figur {
    private int breite;
    private int hoehe;

    public Linie(int x, int y, int breite, int hoehe) {
        super(x, y);
        this.setBreite(breite);
        this.setHoehe(hoehe);
    }

    public Linie(int x, int y, int breite, int hoehe, Color farbe) {
        super(x, y, farbe);
        this.setBreite(breite);
        this.setHoehe(hoehe);
    }

    public Linie() {

    }

    public int getBreite() {
        return breite;
    }

    public void setBreite(int breite) {
        this.breite = breite;
    }

    public int getHoehe() {
        return hoehe;
    }

    public void setHoehe(int hoehe) {
        this.hoehe = hoehe;
    }

    public void move(int deltaX, int deltaY) {
        this.breite = this.breite + deltaX;
        this.hoehe = this.hoehe + deltaY;
        this.moveOrigin(deltaX, deltaY);
    }

    public void zeichnen(Graphics g) {
        if (this.getFarbe()!=null){
            g.setColor(this.getFarbe());
        }
        else {
            g.setColor(Color.BLACK);
        }
        g.drawLine(this.x, this.y, this.breite, this.hoehe);
    }

    @Override
    public void save() throws IOException {
        int anzahlDateien = Objects.requireNonNull(new File("/Users/quintengroenveld/Documents/m226_2_qg/figuren").list()).length - 1;
        File f = new File("/Users/quintengroenveld/Documents/m226_2_qg/figuren/figur" + (anzahlDateien-1) + ".txt");
        BufferedWriter writer = null;
        String dateiName = "/Users/quintengroenveld/Documents/m226_2_qg/figuren/figur" + anzahlDateien + ".txt";
        File logFile = new File(dateiName);
        writer = new BufferedWriter(new FileWriter(logFile));
        Linie l = this;
        writer.write("Figurtyp: Linie");
        writer.newLine();
        writer.write("Origin: " + l.getX() + " " + l.getY());
        writer.newLine();
        writer.write("Height/Width: " + l.getBreite() + " " + l.getHoehe());
        if (l.getFarbe() != null) {
            writer.newLine();
            writer.write("RGB: " + l.getFarbe().getRed() + " " + l.getFarbe().getGreen() + " " + l.getFarbe().getBlue());
        }
        writer.close();
    }

    @Override
    public void load(File file, EditorControl editorControl) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String string;
        int i = 0;
        int x = 0;
        int y = 0;
        int breite = 0;
        int hoehe = 0;
        Color farbe = Color.BLACK;

        while ((string = br.readLine()) != null) {
            String[] arrayString = string.split(" ");
            if (i == 1) {
                x = Integer.parseInt(arrayString[1]);
                y = Integer.parseInt(arrayString[2]);
            }
            if (i == 2) {
                breite = Integer.parseInt(arrayString[1]);
                hoehe = Integer.parseInt(arrayString[2]);
            }
            if (i == 3) {
                farbe = new Color(Integer.parseInt(arrayString[1]), Integer.parseInt(arrayString[2]), Integer.parseInt(arrayString[3]));
            }
            i++;
        }
        if (i == 3) {
            editorControl.getZeichnung().hinzufuegen(new Linie(x, y, breite, hoehe));
        }
        if (i == 4) {
            editorControl.getZeichnung().hinzufuegen(new Linie(x, y, breite, hoehe, farbe));
        }
    }
}
