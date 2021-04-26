package grafikeditor_0.figuren;

import java.awt.*;

public class Linie extends Figur {
    private int endeX;
    private int endeY;

    public Linie(int x, int y, int endeX, int endeY) {
        super(x, y);
        this.setBreite(endeX);
        this.setHoehe(endeY);
    }

    public Linie(int x, int y, int endeX, int endeY, Color farbe) {
        super(x, y, farbe);
        this.setBreite(endeX);
        this.setHoehe(endeY);
    }

    public int getBreite() {
        return endeX;
    }

    public void setBreite(int endeX) {
        this.endeX = endeX;
    }

    public int getHoehe() {
        return endeY;
    }

    public void setHoehe(int endeY) {
        this.endeY = endeY;
    }


}
