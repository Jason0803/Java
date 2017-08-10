package kosta.banking;

public class Customer {
	String firstName;
	String lastName;
	int ssn;
	Account account;
	
	public Customer(String firstName, String lastName, int ssn) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
	}
	
	public void setAccount(Account acc) {
		account = acc;
	}
	
	public Account getAccount(){
		return this.account;
	}
}
