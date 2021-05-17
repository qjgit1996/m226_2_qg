package grafikeditor_0.figuren;

import grafikeditor_0.EditorControl;

import java.awt.*;
import java.io.*;
import java.util.Objects;

public class Rechteck extends Figur {
	private int breite;
	private int hoehe;
	private boolean ausgefuellt = true;
	
	public Rechteck(int x, int y, int breite, int hoehe) {
		super(x, y);
		this.setBreite(breite);
		this.setHoehe(hoehe);
	}

	public Rechteck(int x, int y, int breite, int hoehe, Color farbe, boolean ausgefuellt) {
		super(x, y, farbe);
		this.setBreite(breite);
		this.setHoehe(hoehe);
		this.ausgefuellt = ausgefuellt;
	}

	public Rechteck() {

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

	public boolean getAusgefuellt() {
		if (!this.ausgefuellt) {
			return false;
		}
		else {
			return true;
		}
	}

	public void setAusgefuellt(boolean ausgefuellt) {
		this.ausgefuellt = ausgefuellt;
	}

	public void move(int deltaX, int deltaY) {
		this.breite = this.breite + deltaX;
		this.hoehe = this.hoehe + deltaY;
		this.moveOrigin(deltaX, deltaY);
	}

	public void zeichnen(Graphics g) {
		if (this.getFarbe() != null){
			g.setColor(this.getFarbe());
			if (this.ausgefuellt) {
				g.fillRect(this.x, this.y, this.breite, this.hoehe);
			}
			else {
				g.drawRect(this.x, this.y, this.breite, this.hoehe);
			}
		}
		else {
			g.setColor(Color.BLACK);
			if (this.ausgefuellt) {
				g.fillRect(this.x, this.y, this.breite, this.hoehe);
			}
			else {
				g.drawRect(this.x, this.y, this.breite, this.hoehe);
			}
		}
	}

	@Override
	public void saveFigure(BufferedWriter writer) throws IOException {
		Rechteck r = this;
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
			editorControl.getZeichnung().hinzufuegen(new Linie(x, y, breite, hoehe));
		}
		if (i == 4) {
			editorControl.getZeichnung().hinzufuegen(new Rechteck(x, y, breite, hoehe, farbe, aufgefuellt));
		}
	}

}
