package thread.step3.test;

import javax.swing.JOptionPane;

public class InputThreadTest_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String password = JOptionPane.showInputDialog("비번 입력 : ");
		System.out.println("Password : " + password);
		
		for(int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				
			}
		}
		
	}

}
