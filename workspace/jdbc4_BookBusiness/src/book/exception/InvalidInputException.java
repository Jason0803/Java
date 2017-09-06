package book.exception;

public class InvalidInputException extends Exception {
	public InvalidInputException() {
		this("Error !");
	}
	public InvalidInputException(String msg) {
		super(msg);
	}
}
