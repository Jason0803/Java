package reference.test;

import reference.vo.Person;

public class PersonArrayTest {

	public static void main(String[] args) {
		Person[] people = {
			new Person("Jason", 24),
			new Person("Sunny", 28),
			new Person("IU", 24)
		};
		
		for(int i=0; i < people.length; i++){
			people[i].display();
		}
		
	}

}
