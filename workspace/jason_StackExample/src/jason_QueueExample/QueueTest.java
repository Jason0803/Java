package jason_QueueExample;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue queue = new LinkedList();
		Scanner sc = new Scanner(System.in);
		
		String input = "";
		String value = "";
		// ------------------------------------- while ------------------------------------- //
		while(true) {
			System.out.println("==============================");
			System.out.println("-1. offer()");
			System.out.println("-2. poll()");
			System.out.println("-3. peek()");
			System.out.println("-4. Display Queue contents");
			System.out.println("-Q. Exit Programme..");
			System.out.println("==============================");
			
			System.out.print("\nSelect Menu : ");
			input = sc.nextLine();
			
			if(input.equalsIgnoreCase("Q")) break;
			
			else {
				switch (Integer.parseInt(input)) {
					// ----------------------------- offer() -------------------------------- //
					case 1:{
						System.out.print("\nEnter Value : ");
						// offer()
                        
						System.out.println("\n-Value [" + value + "] is offered !");
						break;
					}
					// ----------------------------- poll() -------------------------------- //
					case 2:{
						// poll()
						
						break;
					}
					// ----------------------------- peek() -------------------------------- //
					case 3:{
						// peek()
						
						break;
					}
					// ----------------------------- display() ----------------------------- //
					case 4:{
						// while + pop --> ?
                        
						break;
					}

				} // switch
			} // else
		} // while
	} // main

}
