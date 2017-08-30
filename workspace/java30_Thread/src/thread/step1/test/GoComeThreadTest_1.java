package thread.step1.test;

// extends Thread 
// implements Runnable

class GoThread extends Thread {
	int i = 0;
	public void run() {
		// logic to be implemented !!
		while(true) {
			System.out.println("Go ::" + i++);
			if(i == 20) break;
		}
	}
}

class ComeThread extends Thread {
	int i = 0;
	public void run() {
		// logic to be implemented !!
		while(true) {
			System.out.println("Come ::" + i++);
			if(i == 20) break;
		}
	}
}

public class GoComeThreadTest_1 {

	public static void main(String[] args) {
		GoThread go = new GoThread();
		ComeThread come = new ComeThread();
		
		go.setPriority(1);
		
		go.start();
		come.start();

	}

}
