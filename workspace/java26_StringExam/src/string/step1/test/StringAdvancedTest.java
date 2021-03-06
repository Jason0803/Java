package string.step1.test;

import java.util.HashSet;
import java.util.Scanner;

public class StringAdvancedTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] files = {
			"Begin Again.avi",
			"StringTest1.java",
			"August Rush.mp3",
			"루시.avi",
			"rt.jar"
		};
		
		String stars = "박보영 박형식 아이유 박보영 클라라 아이유 전도연";
		
		StringService service = new StringService();
		
		System.out.print("Extension of file to find : ");
		String extension = sc.nextLine();
		service.printFileName(files, extension);
		
		System.out.println("\nStars..");
		System.out.println(service.getUniqueStar(stars));
	}
}

class StringService {
	public void printFileName(String[] files, String extension) {
		for(String file : files){ 
			if(file.endsWith("." + extension)) {
				System.out.println("> " + file.substring(0, file.indexOf("." + extension)));
			}
		}
	}
	
	public HashSet<String> getUniqueStar(String stars) {
		HashSet<String> set = new HashSet<String>();
		String[] temp = stars.split(" ");
		
		for(int i = 0; i < temp.length; i++) {
			if(set.contains(temp[i])) continue;
			set.add(temp[i]);
		}
		
		
		return set;
	}
}