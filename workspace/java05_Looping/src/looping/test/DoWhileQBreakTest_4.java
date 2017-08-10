package looping.test;

import java.util.Scanner;

public class DoWhileQBreakTest_4 {
	
	static void display(String text){
		System.out.println(text);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputString = "";
		
		display("Input Messages on Console ('Q' to quit) ");
		do {
		 	inputString = sc.nextLine();
		 	display(inputString);
		} while ( !inputString.equals("Q") && !inputString.equals("q") );
		
		display("\nProgramme Finished !");

	}

}
