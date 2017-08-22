package step3.test;

public class StaticExamTest {
	static int i;
	
	public static void main(String[] args) {
		System.out.println("Main method static block..." + StaticExamTest.i );
	}
	
	static {
		i++;
		System.out.println("static initialization block..." + StaticExamTest.i );
	}

}
