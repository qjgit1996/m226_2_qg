package grafikeditor_0.figuren;

public abstract class Figur {
	protected int x;
	protected int y;

	public Figur (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
