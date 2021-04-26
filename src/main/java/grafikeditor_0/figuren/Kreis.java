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


}
