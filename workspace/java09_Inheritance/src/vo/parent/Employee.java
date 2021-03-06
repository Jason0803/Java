package vo.parent;

import util.MyDate;

public class Employee {
	private String ssn;
	private String name;
	private MyDate birthDate;
	private double salary;
	
	public Employee(String ssn, String name, MyDate birthDate, double salary) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.birthDate = birthDate;
		this.salary = salary;
	}

	public Employee(String ssn){
		this(ssn, "Guest", new MyDate(1900,1,1), 10000);
	}
	
	public String getDetails(){
		return name + "\t" + birthDate.toString() + "\t" + salary;
	}
	
}
