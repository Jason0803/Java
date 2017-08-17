package vo.parent;

import util.MyDate;

public class Employee {
	// Fields
	private String ssn;
	private String name;
	private MyDate birthDate;
	private double salary;
	
	// Constants
	public static final String DEFAULT_NAME = "Guest";
	public static final double DEFAULT_SALARY = 10000.0;
	
	
	public Employee(String ssn, String name, MyDate birthDate, double salary) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.birthDate = birthDate;
		this.salary = salary;
	}

	public Employee(String ssn){
		this(ssn, DEFAULT_NAME, new MyDate(1900,1,1), DEFAULT_SALARY);
	}
	
	public String getDetails(){
		return name + "\t" + birthDate.toString() + "\t" + salary;
	}
	
}
