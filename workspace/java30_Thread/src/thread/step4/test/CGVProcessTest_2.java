package thread.step4.test;

class CGVUser implements Runnable {
	private static boolean seat = false;
	@Override
	public void run() {
		// 좌석 예매
		reserve();
	}
	
	private synchronized void reserve() {
		// 1.예매하는 기능 쓰레드 --> 이름 지정
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " came for reservation !");
		if(seat == false) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(threadName + " 좌석 예매 성공");
			seat = true;
		} else {
			System.out.println("The seat is already taken !");
		}
	}
	
}

public class CGVProcessTest_2 {

	public static void main(String[] args) {
		CGVUser user = new CGVUser();
		
		Thread t1 = new Thread(user, "jason");
		Thread t2 = new Thread(user, "김기쁨");
		
		t1.start();
		t2.start();
	}

}
