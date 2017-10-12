package superTest;

public class HierTest {

	public static void main(String[] args) {
		ChildClass cc = new ChildClass(1, "a", 2);
		cc.increment();
		cc.display();
		cc.superIncre();
		cc.display();
	}

}
