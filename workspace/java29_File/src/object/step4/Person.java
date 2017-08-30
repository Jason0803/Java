package object.step4;

import java.io.Serializable;
/*
 *  ** Serializable **
 *  Person 클래스의 객체를 스트림 통해 목적지 전달 하려고 할 때
 *  전달되는 정체는 객체의 필드값이 된다.
 *  클래스의 메드는 직렬화의 대상에서 제외된다.
 *  
 *  --> Person 클래스의 값이 스트림을 통과하려면,
 *  해당 클래스는 Serializable 이라는 인터페이스 구현 받음으로서 가능해 짐.
 */
public class Person implements Serializable {	
	private String name;
	private int age;
	private transient String password;
	private String address;
	
	public Person(String name, int age, String password, String address) {
		super();
		this.name = name;
		this.age = age;
		this.password = password;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", password=" + password + ", address=" + address + "]";
	}
	
	
	
}
