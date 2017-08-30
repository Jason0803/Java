package thread.step4.test;

class Calculator { 
	private int memory;

	public int getMemory() {
		return memory;
	}

	public synchronized void setMemory(int memory) {
		this.memory = memory;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) { }
		
		System.out.println(Thread.currentThread().getName() + "Value : " + this.memory);
	}
	

}

class User1 extends Thread {
	Calculator calculator;
	
	public void serCalculator(Calculator calculator) {
		setName("Calculator_1");
	}
	
	public void run() {
		calculator.setMemory(100);
	}
}

class User2 extends Thread {
	Calculator calculator;
	
	public void serCalculator(Calculator calculator) {
		setName("Calculator_2");
	}
	
	public void run() {
		calculator.setMemory(50);
	}
}


public class SharingDataTest_1 {	

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		User1 user1 = new User1();
		user1.serCalculator(cal);
		user1.start();
		System.out.println(cal.getMemory());
		User2 user2 = new User2();
		user2.serCalculator(cal);
		user2.start();
		System.out.println(cal.getMemory());
		
	}

}
