package test.exercice.exception;

public class BadPathException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BadPathException(String message) {
		super(message);
	}
}
