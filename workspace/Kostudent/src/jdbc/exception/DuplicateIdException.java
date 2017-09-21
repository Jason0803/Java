package jdbc.exception;

public class DuplicateIdException extends Exception {
	public DuplicateIdException(String msg) {
		super(msg);
	}
	public DuplicateIdException() {
		this("Input Error !");
	}
}
