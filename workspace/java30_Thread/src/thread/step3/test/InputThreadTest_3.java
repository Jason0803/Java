package thread.step3.test;

import java.awt.Toolkit;

import javax.swing.JOptionPane;

class CountThread implements Runnable {
	
	@Override
	public void run() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		int i = 0;
		while(!InputThreadTest_3.INPUTCHECK && i < 10) {
			tk.beep();
			System.out.println(i+1);
			i++;
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) { }
		}
		
		if(!InputThreadTest_3.INPUTCHECK) {
			System.out.println("Count is OVER !!");
			System.exit(0);
		}
	}
	
}

class InputThread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		String password = JOptionPane.showInputDialog("비번 입력 : ");
		System.out.println("Password : " + password);
		InputThreadTest_3.INPUTCHECK = true;
	}
	
}

public class InputThreadTest_3 {

	static boolean INPUTCHECK = false;
	
	public static void main(String[] args) {
		
		CountThread t1 = new CountThread();
		Thread th1 = new Thread(t1);
		
		InputThread t2 = new InputThread();
		Thread th2 = new Thread(t2);
		
		th1.start();
		th2.start();
		

	}

}
