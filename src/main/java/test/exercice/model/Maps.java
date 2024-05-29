package test.exercice.model;

import test.exercice.exception.BadPathException;

public class Maps {
	private String[][] points;

	public Maps(String[][] points) {
		this.points = points;
	}

	public String[][] getPoints() {
		return points;
	}

	public void setPoints(String[][] points) {
		this.points = points;
	}

	public void checkPossibility(int x, int y) {
		if (!points[x][y].isBlank() && !points[y][x].isBlank()) {
			throw new BadPathException("# bois impénétrables");
		}
	}
}
