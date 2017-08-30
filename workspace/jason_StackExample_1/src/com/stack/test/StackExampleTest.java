package com.stack.test;

import java.util.Scanner;

import com.stack.service.PostfixCalculator;

public class StackExampleTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PostfixCalculator calculator = new PostfixCalculator();
		System.out.print("Enter Expr : ");
		String expr = sc.nextLine();
		
		calculator.infixToPostfix(expr);
		
		System.out.print("\nEnter Expr for Post-fix Calc : ");
		expr = sc.nextLine();
		
		System.out.println(calculator.calculatePostFix(expr));

	}

}
