package vo.child;

import util.MyDate;
import vo.parent.Employee;

public class Manager extends Employee {
	private String dept;
	
	public Manager(String ssn, String name, MyDate birthDate, double salary, String dept){
		super(ssn, name, birthDate, salary);
		this.dept = dept;
	}

	@Override
	public String getDetails() {
		return super.getDetails() + "\t" + dept;
		
	}
	
	public void changeDept(String dept){
		this.dept = dept;
	}
}
