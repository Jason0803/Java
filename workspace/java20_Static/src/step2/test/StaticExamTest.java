package step2.test;

public class StaticExamTest {
	int i = 0;
	static int j = 20;
	
	void test() {
		System.out.println("Member Variable :: " + i);
		System.out.println("Static Variable :: " + j);
	}
	
	static void test2() {
		//System.out.println("Member Variable :: " + i);
		System.out.println("Static Variable :: " + j);
	}
	
	public static void main(String[] args) {
		int k = 0;
	}

}
