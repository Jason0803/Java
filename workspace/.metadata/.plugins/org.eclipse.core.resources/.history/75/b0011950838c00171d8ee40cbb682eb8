package jason_StackExample;

import java.util.Scanner;
import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		Scanner sc = new Scanner(System.in);
		
		String input = "";
		String value = "";
		// ------------------------------------- while ------------------------------------- //
		while(true) {
			System.out.println("==============================");
			System.out.println("-1. push()");
			System.out.println("-2. pop()");
			System.out.println("-3. peek()");
			System.out.println("-4. Display Stack contents");
			System.out.println("-Q. Exit Programme..");
			System.out.println("==============================");
			
			System.out.print("\nSelect Menu : ");
			input = sc.nextLine();
			
			if(input.equalsIgnoreCase("Q")) break;
			
			else {
				switch (Integer.parseInt(input)) {
					// ----------------------------- push() -------------------------------- //
					case 1:{
						System.out.print("\nEnter Value : ");
						value = sc.nextLine();
						
						stack.push(value);
						System.out.println("\n-Value [" + value + "] is pushed !");
						break;
					}
					// ----------------------------- pop() -------------------------------- //
					case 2:{
						if(!stack.isEmpty()) {
							value = stack.pop();
							System.out.println("-Value [" + value + "] is popped !");
						} else System.out.println("\nStack is Empty");
						
						break;
					}
					// ----------------------------- peek() -------------------------------- //
					case 3:{
						if(!stack.isEmpty()) {
							value = stack.peek();
							System.out.println("\n-Top of the stack is : " + value);
						} else System.out.println("Stack is Empty");
						
						break;
					}
					// ----------------------------- display() ----------------------------- //
					case 4:{
						int count = 0;
						while(!stack.isEmpty()) {
							System.out.println(count+1 + "-" + stack.pop());
							count++;
						}
						break;
					}

				} // switch
			} // else
		} // while
	} // main

}
