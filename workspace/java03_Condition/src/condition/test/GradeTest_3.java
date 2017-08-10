package condition.test;

import java.util.Scanner;

public class GradeTest_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		int score;
		char grade;
		
		System.out.print("Enter your name : ");
		name = sc.next();
		
		System.out.print(name + ", please enter your grade : ");
		score = sc.nextInt();
		
		
		if(score > 90 && score <= 100){
			grade = 'A';
			
		} else if(score > 80 && score <= 90){
			grade = 'B';
		} else if(score > 70 && score <= 80) {
			grade = 'C';
		} else {
			grade = 'F';
		}
		
		System.out.println("\n" + name + ", your grade is : " +  grade);
	}

}
