package grafikeditor_0.figuren;

import java.awt.*;

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
}
