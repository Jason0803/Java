package book.exception;

public class RecordNotFoundException extends Exception {
	public RecordNotFoundException() {
		this("Error !");
	}
	public RecordNotFoundException(String msg) {
		super(msg);
	}
}
