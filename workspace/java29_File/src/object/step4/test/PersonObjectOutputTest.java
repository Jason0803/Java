package object.step4.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import object.step4.Person;

public class PersonObjectOutputTest {
/*
 * Person 객체 필드값을 sink (파일 : person.obj) 쪽으로 날리는 로직 생성
 * 1. Stream 생성
 * 	--> ObjectOutputStream | FileOutputStream
 * 2. 뿌림 (출력)
 * 	--> writeObject(Person person)
 * 3. 자원 닫음 (close)
 * 
 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String fileName = "src/objFile/person.obj";
		File f = new File(fileName);
		f.getParentFile().mkdirs();
		
		// 1.Stream !
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		// 2. write !
		Person person = new Person("Jason", 24, "1234", "강남구");
		oos.writeObject(person);
		
		// 다시 역직렬화
		
		oos.close();
	}

}
