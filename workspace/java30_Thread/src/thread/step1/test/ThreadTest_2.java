package thread.step1.test;

class GThread implements Runnable {
	int i = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() + " : " + i++);
			if(i == 20) break;
		}
	}
	
}

class CThread implements Runnable {
	int i = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Thread.currentThread().getName();
			System.out.println(Thread.currentThread().getName() + " : " + i++);
			if(i == 20) break;
		}
	}
	
}


public class ThreadTest_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GThread g = new GThread();
		CThread c = new CThread();
		
		Thread t1 = new Thread(g);
		Thread t2 = new Thread(c);
		
		t1.start();
		t2.start();
	}

}
