package grafikeditor_0.figuren;

import java.awt.*;

public class Kreis extends Figur{
    private int radius;
    private boolean ausgefuellt;

    public Kreis(int x, int y, int radius) {
        super(x, y);
        this.setRadius(radius);
    }

    public Kreis(int x, int y, int radius, Color farbe, boolean ausgefuellt) {
        super(x, y, farbe);
        this.setRadius(radius);
        this.setAusgefuellt(ausgefuellt);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean getAusgefuellt() {
        return ausgefuellt;
    }

    public void setAusgefuellt(boolean ausgefuellt) {
        this.ausgefuellt = ausgefuellt;
    }

    public void move(int deltaX, int deltaY) {
        this.moveOrigin(deltaX, deltaY);
    }

    public void zeichnen(Graphics g) {
        if (this.getFarbe()!=null){
            g.setColor(this.getFarbe());
        }
        else {
            g.setColor(Color.BLACK);
        }
        g.drawOval(this.x - this.radius, this.y - this.radius, 2 * this.radius, 2 * this.radius);
    }

}
