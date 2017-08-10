package kosta.banking;

public class Account {
	double balance;

	public Account(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount){
		if( amount < 1000){
			System.out.println("You should deposit more than 1000 !");
		} else balance += amount;               
	}
	
	public void withdraw(double amount){
		if( amount > balance ){
			System.out.println("You cannot withdraw more than balance !");
		} else balance -= amount;
	}
	
	public double getBalance(){
		return balance;
	}
	
}
