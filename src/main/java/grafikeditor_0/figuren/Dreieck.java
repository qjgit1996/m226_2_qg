package grafikeditor_0.figuren;

import grafikeditor_0.EditorControl;

import java.awt.*;
import java.io.*;
import java.util.Objects;

public class Dreieck extends Figur {
    private Linie linkeSeite;
    private Linie rechteSeite;
    private Linie unterSeite;
    private boolean ausgefuellt;

    public Dreieck(int xA, int yA, int xB, int yB) {
        super(xA, yA);
        int xC = xB + Math.abs(xA - xB) * 2;
        int yC = yB;
        linkeSeite = new Linie(xA, yA, xB, yB);
        rechteSeite = new Linie(xA, yA, xC, yC);
        unterSeite = new Linie(xB, yB, xC, yC);

    }

    public Dreieck(int xA, int yA, int xB, int yB, Color farbe, boolean ausgefuellt) {
        super(xA, yA, farbe);
        int xC = xB + Math.abs(xA - xB) * 2;
        int yC = yB;
        linkeSeite = new Linie(xA, yA, xB, yB, this.farbe);
        rechteSeite = new Linie(xA, yA, xC, yC, this.farbe);
        unterSeite = new Linie(xB, yB, xC, yC, this.farbe);
        this.ausgefuellt = ausgefuellt;

    }

    public Dreieck() {
        super();
    }

    public Linie getLinkeSeite() {
        return linkeSeite;
    }

    public Linie getRechteSeite() {
        return rechteSeite;
    }

    public Linie getUnterSeite() {
        return unterSeite;
    }

    public boolean getAusgefuellt() {
        return ausgefuellt;
    }

    public void move(int deltaX, int deltaY) {
        this.linkeSeite.move(deltaX, deltaY);
        this.rechteSeite.move(deltaX, deltaY);
        this.unterSeite.move(deltaX, deltaY);
        this.moveOrigin(deltaX, deltaY);
    }

    public void zeichnen(Graphics g) {
        if (this.getFarbe() != null) {
            g.setColor(this.getFarbe());
            if (this.ausgefuellt) {
                int[] xPoints = {this.linkeSeite.getX(), this.linkeSeite.getBreite(), this.rechteSeite.getBreite()};
                int[] yPoints = {this.linkeSeite.getY(), this.linkeSeite.getHoehe(), this.rechteSeite.getHoehe()};
                g.fillPolygon(xPoints, yPoints, 3);
            }
            else {
                this.linkeSeite.zeichnen(g);
                this.rechteSeite.zeichnen(g);
                this.unterSeite.zeichnen(g);
            }
        }
        else {
            g.setColor(Color.BLACK);
            if (this.ausgefuellt) {
                int[] xPoints = {this.linkeSeite.getX(), this.linkeSeite.getBreite(), this.rechteSeite.getBreite()};
                int[] yPoints = {this.linkeSeite.getY(), this.linkeSeite.getHoehe(), this.rechteSeite.getHoehe()};
                g.fillPolygon(xPoints, yPoints, 3);
            }
            else {
                this.linkeSeite.zeichnen(g);
                this.rechteSeite.zeichnen(g);
                this.unterSeite.zeichnen(g);
            }
        }



    }

    @Override
    public void saveFigure(BufferedWriter writer) throws IOException {
        Dreieck d = this;
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
        boolean aufgefuellt = false;
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
            if (i == 4) {
                farbe = new Color(Integer.parseInt(arrayString[1]), Integer.parseInt(arrayString[2]), Integer.parseInt(arrayString[3]));
            }
            if (i == 5) {
                aufgefuellt = Boolean.parseBoolean(arrayString[1]);
            }
            i++;
        }
        editorControl.getZeichnung().hinzufuegen(new Dreieck(x, y, breite, hoehe, farbe, aufgefuellt));
    }
}
