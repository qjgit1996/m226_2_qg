package grafikeditor_0.figuren;

import java.awt.*;

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

}
