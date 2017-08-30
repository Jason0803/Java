package thread.step2.test;

import java.awt.Toolkit;

public class BeepThreadTest_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		for(int i = 0; i < 5; i ++) {
			tk.beep();
			Thread.sleep(200);
		}
		
		for(int i = 0; i < 5; i ++) {
			System.out.println("띵");
			Thread.sleep(200);
		}
	}

}
