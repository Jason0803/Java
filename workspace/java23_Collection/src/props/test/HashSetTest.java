package props.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("IU");
		set.add("Jason");
		set.add("Sunny");
		
		System.out.println(set);
		
		System.out.println(set.contains("IU"));
		
		System.out.println(set);
		
		Iterator<String> order = set.iterator();
		while(order.hasNext()){
			System.out.println(order.next());
		}
	}

}
