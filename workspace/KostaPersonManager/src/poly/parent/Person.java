package poly.parent;

import poly.course.Course;

public class Person {
	private String name;
	private String personId;
	private String address;
	private String phoneNumber;
	private Course course;

	public Person() {
	}

	public Person(String name, String personId, String address, String phoneNumber) {
		super();
		this.name = name;
		this.personId = personId;
		this.address = address;
		this.phoneNumber = phoneNumber;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	@Override
	public String toString(){
		return name;
	}

}
