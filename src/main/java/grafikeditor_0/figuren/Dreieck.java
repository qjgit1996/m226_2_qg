package grafikeditor_0.figuren;

import java.awt.*;

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

    public Dreieck(int xA, int yA, int xB, int yB, int xC, int yC, boolean ausgefuellt, Color farbe) {
        super(xA, yA, farbe);
        linkeSeite = new Linie(xA, yA, xB, yB);
        rechteSeite = new Linie(xA, yA, xC, yC);
        unterSeite = new Linie(xB, yB, xC, yC);
        this.ausgefuellt = ausgefuellt;

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
        //this.move(400,400);
        if (this.getFarbe() != null) {
            g.setColor(this.getFarbe());
        }
        else {
            g.setColor(Color.BLACK);
        }
        this.linkeSeite.zeichnen(g);
        this.rechteSeite.zeichnen(g);
        this.unterSeite.zeichnen(g);
    }
}
