package thread.step5;

public class AccountThread implements Runnable{
	Account  acc = new Account();
	
	@Override
	public void run() {				
		while(acc.balance>0){
			//100,200, 300만원 중의 하나의 값이 출금되도록 로직을 작성...
			int money = (int)(Math.random()*3 +1)*100;
			//은행에서 출금하는 기능....withdraw()를 호출..			
			try{
				acc.withdraw(money);
				System.out.println("당신의 통장의 잔액은 "+ acc.balance+" 만원입니다.");
			}catch(InterruptedException e){
				e.printStackTrace();
			}//catch	
		
	}//while

	}//run
}//class
class Account{
	int balance = 1000; //만원단위
	
	public void withdraw(int money)throws InterruptedException{
		if(balance >= money){
			//이럴 경우에만 출금이 이뤄져야 한다...그런데...시간이 좀 지연됬다..치자..
			Thread.sleep(2000);
			
			balance -= money;	
		}
	}
	
	
}















