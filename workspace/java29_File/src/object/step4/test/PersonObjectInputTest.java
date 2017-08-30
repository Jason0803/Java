package object.step4.test;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import object.step4.Person;


public class PersonObjectInputTest {

	public static void main(String[] args) throws Exception {
		String fileName = "src/objFile/person.obj";
		
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Person returnPerson = (Person)ois.readObject();
		System.out.println(returnPerson);

	}

}
