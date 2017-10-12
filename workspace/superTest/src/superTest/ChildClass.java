package superTest;

public class ChildClass extends SuperClass {
	int count;

	ChildClass(int number, String name, int count) {
		this.number = number;
		this.name = name;
		this.count = count;
	}
	@Override
	void increment() {
		this.number += 2;
	}
	
	void superIncre() {
		super.increment();
	}
	
	void display() {
		System.out.println("currVal : " + this.number);
	}
}
