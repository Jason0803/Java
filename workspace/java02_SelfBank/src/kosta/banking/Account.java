package kosta.banking;

public class Account {
	double balance;

	public Account(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount){
		// balance += amount;               
	}
	
	public void withdraw(double amount){
		balance -= amount;
	}
	
	public double getBalance(){
		return balance;
	}
	
}
