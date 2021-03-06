package props.test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class HashMapTest {
// ** Wrapper Class ** //
/*
 * Character, Short, Integer, ...
 * Integer score = new Integer(80);
 *  
 */
	public static void main(String[] args) {
		HashMap<String, Integer> studentGrades = new HashMap<String, Integer>();
		studentGrades.put("IU", new Integer(80));
		studentGrades.put("Jason", new Integer(100));
		studentGrades.put("Sunny", new Integer(80));
		studentGrades.put("Kim", new Integer(65));
		
		Set<String> set = studentGrades.keySet();
		System.out.println(set);
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			int value = studentGrades.get(key);
			System.out.println(key + " :: " + value);
		}
		Collection<Integer> scores = studentGrades.values();
		
		System.out.println(Collections.max(scores));
		
		
	}

}
