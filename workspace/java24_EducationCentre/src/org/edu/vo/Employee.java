package org.edu.vo;

import org.edu.util.MyDate;

public class Employee extends Person{
	private String dept;

	public Employee(int ssn, String name, String address, MyDate birthDate, String dept) {
		super(ssn, name, address, birthDate);
		this.dept = dept;
	}	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return super.toString()+" Employee [dept=" + dept + "]" ;
	}	
}






