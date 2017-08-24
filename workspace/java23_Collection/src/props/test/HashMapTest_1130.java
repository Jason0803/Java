package props.test;
import java.util.*;

public class HashMapTest_1130 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap map = new HashMap();
		map.put("myId", "1234");
		map.put("asdf", "1111");
		map.put("asdf", "1234");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("== Enter ID and PW ==");
			System.out.print("ID : ");
			String id = sc.nextLine().trim();
			
			System.out.print("Password : ");
			String pw = sc.nextLine().trim();
			
			System.out.println();
			
			if(!map.containsKey(id)) {
				System.out.println("The key does not exist !");
			} else {
				if( !map.get(id).equals(pw) ) {
					System.out.println("PW is not matching !");
				} else {
					System.out.println("PW is Matching !");
					break;
				}
			}
		}
		
		
	}

}
