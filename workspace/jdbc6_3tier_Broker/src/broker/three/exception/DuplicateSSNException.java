package broker.three.exception;

public class DuplicateSSNException extends Exception {
	public DuplicateSSNException (String msg) {
		super(msg);
	}
	
	public DuplicateSSNException () {
		this("DuplicateSSNException !");
	}
	
}
