package grafikeditor_0.figuren;

import java.awt.*;

public abstract class Figur {
	protected int x;
	protected int y;
	protected Color farbe = null;

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

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getFarbe() {
		if (this.farbe != null) {
			return farbe;
		}
		else {
			return null;
		}
	}

	public void moveOrigin(int deltaX, int deltaY) {
		this.setX(this.x+deltaX);
		this.setY(this.y+deltaY);
	}

}
