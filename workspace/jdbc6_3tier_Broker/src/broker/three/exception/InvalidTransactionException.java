package broker.three.exception;

public class InvalidTransactionException extends Exception {
	public InvalidTransactionException (String msg) {
		super(msg);
	}
	
	public InvalidTransactionException () {
		this("InvalidTransactionException !");
	}
	
}
