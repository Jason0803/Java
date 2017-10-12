package superTest;

public class SuperClass {
	int number;
	String name;
	
	SuperClass() {	
		
	}
	SuperClass(int number, String name) {
		this.number = number;
		this.name = name;
	}
	
	void increment() {
		this.number += 1;
	}
}
