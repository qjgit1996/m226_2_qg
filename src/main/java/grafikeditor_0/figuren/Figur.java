package grafikeditor_0.figuren;

import grafikeditor_0.EditorControl;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

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

	public Figur() { }

	public abstract void zeichnen(Graphics g);

	public final void save() throws IOException {
		int anzahlDateien = Objects.requireNonNull(new File("/Users/quintengroenveld/Documents/m226_2_qg/figuren").list()).length - 1;
		File f = new File("/Users/quintengroenveld/Documents/m226_2_qg/figuren/figur" + (anzahlDateien-1) + ".txt");
		BufferedWriter writer = null;
		String dateiName = "/Users/quintengroenveld/Documents/m226_2_qg/figuren/figur" + anzahlDateien + ".txt";
		File logFile = new File(dateiName);
		writer = new BufferedWriter(new FileWriter(logFile));

		saveFigure(writer);

		writer.close();
	}

	public abstract void saveFigure (BufferedWriter writer) throws IOException;

	public abstract void load(File file, EditorControl editorControl) throws IOException;
	
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
