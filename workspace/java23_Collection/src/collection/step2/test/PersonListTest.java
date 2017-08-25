package collection.step2.test;
import collection.step2.vo.Person;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class PersonListTest {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person("Sunny", 29, "노원"));
		list.add(new Person("Jason", 24, "강남"));
		list.add(new Person("Kim", 25, "여의도"));
		list.add(new Person("Jimmy", 23, "여의도"));
		list.add(new Person("Terry", 29, "마포구"));
		
		// 1.
		System.out.print("1. Count of Total people stored : ");
		System.out.println(list.size());
		
		// 2. 
		System.out.println("2. Address of 1st Person : ");
		System.out.println(list.get(0).getAddress() );
		
		//3.
		int sum = 0;
		for(Person person : list) {
			sum += person.getAge();
		}
		System.out.println("3. Total age : " + sum);
		
		// 4.
		System.out.println("4. Average age : " + sum / list.size() );
		
		// 5. Same address & Details
		System.out.println("5. People on Yeoui-do");
		int count = 0;
		for(Person person : list) {
			if(person.getAddress().equals("여의도")) count++;
			
		}
		System.out.println("People on Yeoui-do : " + count);
	}

}
