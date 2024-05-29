package test.exercice.model;

import test.exercice.exception.BadPathException;

public class Maps {
	private String[][] points;
	private boolean rowFirst = true;

	public Maps(String[][] points) {
		this.points = points;
	}

	public String[][] getPoints() {
		return points;
	}

	public void setPoints(String[][] points) {
		this.points = points;
	}

	public boolean isRowFirst() {
		return rowFirst;
	}

	public void setRowFirst(boolean rowFirst) {
		this.rowFirst = rowFirst;
	}

	public void checkPossibility(int x, int y) throws BadPathException {
		if (!points[x][y].isBlank() && !points[y][x].isBlank()) {
			throw new BadPathException("# bois impénétrables");
		}
	}
}
