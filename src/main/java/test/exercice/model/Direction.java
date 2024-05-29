package test.exercice.model;

public enum Direction {
	E, O, N, S;

	public static Direction valueOf(char c) {
		return Direction.valueOf(String.valueOf(c).toUpperCase());
	}

}
