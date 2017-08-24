package user.exception;

class AmountInputException extends Exception {
	AmountInputException(String msg) {
		super(msg);
	}
	AmountInputException() {
		this("Input Error !");
	}
}

class AmountOutputException extends Exception {
	AmountOutputException(String msg) {
		super(msg);
	}
	AmountOutputException() {
		this("Output Error !");
	}
}


class Account {
	int balance;
	
	Account(int balance) {
		this.balance = balance;
	}
	
	Account() {
		this(1000);
	}
	
	public void deposit(int amount) throws AmountInputException {
		if(amount < 1000) throw new AmountInputException("Balance should be more than 1000 !");
		else this.balance += amount;
	}
}

public class BankAccountExceptionTest {

	public static void main(String[] args) {
		Account acc = new Account();
		try {
			acc.deposit(300);
		} catch (AmountInputException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
	}

}
