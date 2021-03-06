package collection.step2.test;

import collection.step2.vo.Customer;
import java.util.HashMap;
import java.util.Set;
import java.util.Enumeration;
import java.util.Iterator;

public class CustomerMapTest {

	public static void main(String[] args) {
		HashMap<Integer, Customer> map = new HashMap<Integer, Customer>();
		
		map.put(111, new Customer(111, "효리", 35));
		map.put(222, new Customer(222, "이상순", 37));
		map.put(333, new Customer(333, "아이유", 25));
		
		System.out.println(map.get(222));
		// ID : 111 --> name
		
		Set<Integer> keys = map.keySet();
		Iterator<Integer> it = keys.iterator();
		
		/*
		while(it.hasNext()) {
			int id = it.next();
			Customer temp = map.get(id);
			if(temp.getCusId() == 111) {
				System.out.println(temp.getName());
				break;
			}
			
		}
		*/
		
		// Iterater goes empty on use !!
		 
		int sum = 0;
		while(it.hasNext()) {
			sum += map.get(it.next()).getAge();
		}
		System.out.println("Total age : " + sum);
		System.out.println("Average age : " + sum / map.size());
	}

}
