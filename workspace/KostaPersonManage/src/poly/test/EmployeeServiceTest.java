package poly.test;

import poly.parent.Employee;
import poly.child.Manager;
import poly.child.Engineer;
import poly.service.EmployeeService;

public class EmployeeServiceTest {

	public static void main(String[] args) {
		Employee e = new Employee("e123", "IU", "방배동", 450);
		Manager m = new Manager("m777", "이상순","제주", 500, "관리부");
		Engineer eng_1 = new Engineer("eng112", "효리_1", "신사동", 400, "jQuery", 230);
		Engineer eng_2 = new Engineer("eng113", "효리_2", "제주", 500, "Driver", 100);
		

		
		EmployeeService service = new EmployeeService();
		
		System.out.println(e.toString());
		System.out.println(m.toString());
		System.out.println(eng_1.toString());
		System.out.println(eng_2.toString());
		
		Employee[] ea = new Employee[] {
				m, eng_1, eng_2	
			};
		
		service.changeEmployeeInfo(ea);
		
		System.out.println(m.toString());
		System.out.println(eng_1.toString());
		System.out.println(eng_2.toString());
		
		
		System.out.println("\n===== EmpID Find =====");
		System.out.println(service.findEmployeeByEmpId(ea, "m777").toString());
		
		System.out.println("\n===== Address Find =====");
		System.out.println(service.findEmplyoeeByAddress(ea, "제주").toString());
		
		//System.out.println("\n===== Address Find (for no result) =====");
		//System.out.println(service.findEmplyoeeByAddress(ea, "서초").toString());
		
		
		System.out.println("\n===== Address Find (Jason) =====");
		Employee[] temp = service.findEmployeesByAddress(ea, "제주");
		for(int i = 0; i < temp.length; i++){
			System.out.println(temp[i].toString());
		}
		
	}

}
