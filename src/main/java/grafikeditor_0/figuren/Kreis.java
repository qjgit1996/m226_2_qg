package grafikeditor_0.figuren;

import grafikeditor_0.EditorControl;

import java.awt.*;
import java.io.*;
import java.util.Objects;

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

    public Kreis() {

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

    @Override
    public void zeichnen(Graphics g) {
        if (this.getFarbe()!=null){
            g.setColor(this.getFarbe());
            if (this.ausgefuellt) {
                g.fillOval(this.x - this.radius, this.y - this.radius, 2 * this.radius, 2 * this.radius);
            }
            else {
                g.drawOval(this.x - this.radius, this.y - this.radius, 2 * this.radius, 2 * this.radius);
            }
        }
        else {
            g.setColor(Color.BLACK);
            if (this.ausgefuellt) {
                g.fillOval(this.x - this.radius, this.y - this.radius, 2 * this.radius, 2 * this.radius);
            }
            else {
                g.drawOval(this.x - this.radius, this.y - this.radius, 2 * this.radius, 2 * this.radius);
            }
        }

    }

    @Override
    public void saveFigure(BufferedWriter writer) throws IOException {
        Kreis k = this;
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

    @Override
    public void load(File file, EditorControl editorControl) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String string;
        int i = 0;
        int x = 0;
        int y = 0;
        int radius = 0;
        boolean aufgefuellt = false;
        Color farbe = Color.BLACK;

        while ((string = br.readLine()) != null) {
            String[] arrayString = string.split(" ");
            if (i == 1) {
                x = Integer.parseInt(arrayString[1]);
                y = Integer.parseInt(arrayString[2]);
            }
            if (i == 2) {
                radius = Integer.parseInt(arrayString[1]);
            }
            if (i == 3) {
                if (arrayString.length > 2) {
                    farbe = new Color(Integer.parseInt(arrayString[1]), Integer.parseInt(arrayString[2]), Integer.parseInt(arrayString[3]));
                }
                else {
                    aufgefuellt = Boolean.parseBoolean(arrayString[1]);
                }
            }
            if (i == 4) {
                aufgefuellt = Boolean.parseBoolean(arrayString[1]);
            }
            i++;
        }
        if (i == 3) {
            editorControl.getZeichnung().hinzufuegen(new Kreis(x, y, radius));
        }
        if (i == 4) {
            editorControl.getZeichnung().hinzufuegen(new Kreis(x, y, radius, farbe, aufgefuellt));
        }
    }

}
