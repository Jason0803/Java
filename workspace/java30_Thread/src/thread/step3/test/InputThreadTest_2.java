package thread.step3.test;

import javax.swing.JOptionPane;

class CountingThread implements Runnable {

	@Override
	public void run() {
		for(int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) { }
		}
	}
	
}

public class InputThreadTest_2 {

	public static void main(String[] args) {
		
		CountingThread t1 = new CountingThread();
		Thread t = new Thread(t1);
		
		t.start();
		
		
		String password = JOptionPane.showInputDialog("비번 입력 : ");
		System.out.println("Password : " + password);


	}

}
