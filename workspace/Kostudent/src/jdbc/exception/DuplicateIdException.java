package jdbc.exception;

public class DuplicateIdException extends Exception {
	// #00001 Commit
	public DuplicateIdException(String msg) {
		super(msg);
	}
	public DuplicateIdException() {
		this("Input Error !");
	}
}
