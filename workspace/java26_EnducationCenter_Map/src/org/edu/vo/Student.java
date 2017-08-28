package org.edu.vo;

import org.edu.util.MyDate;

public class Student extends Person{
	private String stuId;

	public Student(int ssn, String name, String address, MyDate birthDate, String stuId) {
		super(ssn, name, address, birthDate);
		this.stuId = stuId;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	@Override
	public String toString() {
		return super.toString()+" Student [stuId=" + stuId + "]" ;
	}	
}






