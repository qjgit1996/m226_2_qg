package grafikeditor_0.figuren;

import java.awt.*;

public abstract class Figur {
	protected int x;
	protected int y;
	protected Color farbe;

	public Figur (int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Figur (int x, int y, Color farbe) {
		this.x = x;
		this.y = y;
		this.farbe = farbe;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Color getFarbe() { return farbe; }

}
