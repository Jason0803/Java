package book.exception;

public class DuplicateIsbnException extends Exception {
	public DuplicateIsbnException() {
		this("Error !");
	}
	public DuplicateIsbnException(String msg) {
		super(msg);
	}
}
