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

    public Dreieck(int xA, int yA, int xB, int yB, Color farbe, boolean ausgefuellt) {
        super(xA, yA, farbe);
        int xC = xB + Math.abs(xA - xB) * 2;
        int yC = yB;
        linkeSeite = new Linie(xA, yA, xB, yB, this.farbe);
        rechteSeite = new Linie(xA, yA, xC, yC, this.farbe);
        unterSeite = new Linie(xB, yB, xC, yC, this.farbe);
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
}
