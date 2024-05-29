package test.exercice.model;

public class Position {
	private int x;
	private int y;
	private String path;

	public Position(int x, int y, String deplacement) {
		this.x = x;
		this.y = y;
		this.setPath(deplacement);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public char[] getPath() {
		return path.toCharArray();
	}

	@Override
	public String toString() {
		return String.format("(%x,%x)", x,y);
	}

	public void setPath(String path) {
		this.path = path;
	}

}
