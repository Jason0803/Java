package test;

import util.MyDate;
import vo.child.Manager;
import vo.parent.Employee;

public class EmployeeAppTest_2 {
	public static void main(String[] args){
		Employee e = new Employee("111-111", "Sunny", new MyDate(1988,12,5), 599);
		Manager m = new Manager("222-222", "Jason", new MyDate(1993,3,8), 799, "Dept");
			
		Employee e_new = new Employee("930-308");
	}

}
