package conditionswitch.test;

public class SwitchNoBreakTest_2 {

	public static void main(String[] args) {
		int time = (int)(Math.random() * 4) + 8;
		System.out.println("[Current Time : " + time + "]");
		
		switch(time) {
			case 8: System.out.println("Commit !");  break;
			case 9: System.out.println("Start Work !"); break;
			case 10: System.out.println("Morning Meeting !"); break;
			case 11: System.out.println("Break  !"); break;
		}
		
		

	}

}
