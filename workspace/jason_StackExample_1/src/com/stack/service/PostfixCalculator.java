package com.stack.service;

import java.util.Stack;

public class PostfixCalculator {
	Stack<Integer> stack;
	
	public int precendence(int op) {
		switch(op) {
	        case '(' : case ')' : return 0;
	        case '+' : case '-' : return 1;
	        case '*' : case '/' : return 2;
		}
		return -1;
	}
	
	public boolean isOperator(char c) {
		if(c == '(' || c == ')'
			|| c == '+' || c == '-' 
			|| c == '*' || c == '/' ) {
			return true;
		} else return false;
	}
	
	public void infixToPostfix(String infix) {
		stack =  new Stack<Integer>();
		char c;
		int op;
		//double val;
		
		for(int i = 0; i < infix.length(); i++) {
			c = infix.charAt(i);
			
			if(isOperator(c)) { // 연산자
				while(!stack.isEmpty()) {
					op = stack.peek();
					if( precendence(c) <= precendence(op) ) {
						System.out.print(op);
						stack.pop();
					} else break;
				}
				stack.push((int)c);
			} else if ( c == '(') {
				stack.push((int)c);
			} else if ( c == ')') {
				while( !stack.isEmpty() ) {
					op = stack.pop();
					if(op == '(') break;
					else System.out.print(op);
				}
			} else { // 숫자
				System.out.print(c);
			}
		}
		
		while(!stack.isEmpty()) {
			int p = stack.pop();
			switch(p) {
				case 42: {
					System.out.print('*');
					break;
				}
				case 43: {
					System.out.print('+');
					break;
				}
				case 45: {
					System.out.print('-');
					break;
				}
				case 47: {
					System.out.print('/');
					break;
				}
			}
		}
		System.out.println();
	}
	
	public int calculatePostFix(String postfix) {
		stack = new Stack<Integer>();
		char c;
		int val1 = 0;
		int val2 = 0;
		
		for(int i = 0; i < postfix.length(); i++) {
			c = postfix.charAt(i);
			
			if(!isOperator(c)) {
				
				val2 = stack.pop();
				val1 = stack.pop();

				switch(c) {
					case '+': {
						stack.push((int)(val1+val2));
						break;
					}
					case '-': {
						stack.push((int)(val1-val2));
						break;
					}
					case '*': {
						stack.push((int)(val1*val2));
						break;
					}
					case '/': {
						stack.push((int)(val1/val2));
						break;
					}
				}
			} else stack.push((int)c);
			
		}
		
		return stack.pop();
	}
	
}
