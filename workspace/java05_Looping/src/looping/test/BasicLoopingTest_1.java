package looping.test;

public class BasicLoopingTest_1 {
	
	// println for a String
	static void display(String text){
		System.out.println(text);
	}
	public static void main(String[] args) {
		// for statement
		display("===== For Statement =====");
		for(int i = 0; i < 10; i++){
			display(i + "\tfor");
		}
		
		// while statement
		display("===== While Statement =====");
		int i = 0;
		while(i < 10){
			display(i + "\twhile");
			i++;
		}
		
		// do-while statement
		display("===== Do-While Statement =====");
		int j = 0;
		do {
			display(j + "\tdo-while");
			j++;
		} while(j < 10);
		
	}

}
