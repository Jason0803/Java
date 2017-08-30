package thread.step5;

public class AccountThread implements Runnable{
	Account  acc = new Account();
	
	@Override
	public void run() {				
		while(acc.balance>0){
			
			int money = (int)(Math.random()*3 +1)*100;
			
			try{
				acc.withdraw(money);
				System.out.println(acc.balance);
			}catch(InterruptedException e){
				e.printStackTrace();
			}//catch	
			
			try {
				acc.deposit(money);
				System.out.println(acc.balance);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		
	}//while

	}//run
}//class
class Account{
	int balance = 1000; 
	
	public synchronized void withdraw(int money)throws InterruptedException{
		if(balance >= money) {
			Thread.sleep(2000);
			
			balance -= money;	
		} else { 
			wait();
		}
	}
	
	public synchronized void deposit(int money) throws InterruptedException {
		balance += money;
		notify();
	}
	
	
}















