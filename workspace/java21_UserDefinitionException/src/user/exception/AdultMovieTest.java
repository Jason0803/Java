package user.exception;

import java.util.Scanner;

class UnderAgeException extends Exception {
	UnderAgeException(String msg) {
		super(msg);
	}
	UnderAgeException() {
		this("미성년자임 !");
	}
}

class AdultMovie {
	public void enter(int age) throws UnderAgeException {
		if(age < 19) throw new UnderAgeException("미성년자 안됨 !");
	}
}

public class AdultMovieTest {

	public static void main(String[] args) throws UnderAgeException {
		Scanner sc = new Scanner(System.in);
		
		AdultMovie jutso = new AdultMovie();
		System.out.print("Type ur age : ");
		int age = sc.nextInt();
		
		try {
			jutso.enter(age);
		} catch(UnderAgeException uae) {
			System.out.println(uae.getMessage());
		}
	}

}
