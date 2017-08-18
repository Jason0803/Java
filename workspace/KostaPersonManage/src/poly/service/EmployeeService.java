package poly.service;

import poly.child.Engineer;
import poly.child.Manager;
import poly.parent.Employee;

public class EmployeeService {
	public Employee getEmployeeInfo(Employee e){
		return e;
	}
	public Employee getEmployeeInfo(Manager m){
		return m;
	}
	public Employee getEmployeeInfo(Engineer eng){
		return eng;
	}
	
	// Use of 'instanceof'
	public void changeEmployeeInfo(Employee[] ea){
		for(Employee e : ea){
			if (e instanceof Manager){
				Manager m = (Manager)e;
				m.changeDept("총무");
			} else if (e instanceof Engineer){
				Engineer eng = (Engineer)e;
				eng.changeTech("C++");
			}
		}
	}

	// 1. empId 값 일치하는 Employee 자식객체 리턴
	public Employee findEmployeeByEmpId(Employee[] ea, String eid){
		Employee result = null;
		int count = 0;
		for(Employee emp : ea){
			count++;
			if(emp.getEmpId().equals(eid)){
				result = emp;
				break;
			}	
		}
		
		if(count == ea.length ){
			System.out.println("No Result Found !");
			System.exit(0);
		}
		return result;
	}
	
	// 2-1. Address find
	public Employee findEmplyoeeByAddress(Employee[] ea, String addr){
		Employee result = null;
		int count = 0;
		for(Employee emp : ea){
			count++;
			if(emp.getAddress().equals(addr)){
				result = emp;
				break;
			}
		}
		if(count == ea.length){
			System.out.println("No Result Found !");
			System.exit(0);
		}
		
		return result;
	}
	
	// 2-2.Address find (array) 
	// Still have some errors
	public Employee[] findEmployeesByAddress(Employee[] ea, String addr){
		Employee[] temp = new Employee[ea.length];
		Employee[] result = null;
		int count = 0;
		
		int[] index = new int[ea.length];
		
		for(int i = 0; i < ea.length; i++){
			if(ea[i].getAddress().equals(addr)){
				temp[i] = ea[i];
			} else {
				index[i] = i;
				count++;
			}
		}
		int a = count;
		result = new Employee[ea.length-a];
		for(int i = 0; i < ea.length; i++){
			if(i == index[i])
				continue;
			
			else if( i >= result.length)
				break;
			
			else{
				result[i] = ea[i];
			}
			
		}
		
		
		
		return result;
	}
	
	// 3. Emplyoee annual salary
	// 4. Total
	
}
