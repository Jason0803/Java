package kosta.cons.test;
import kosta.cons.*;

public class CarAppTest {

	public static void main(String[] args) {
		// 1. 3 Car objects
		/*
		 * car1 :: default
		 * car2 :: 3 arguments
		 * car3 :: 4 arguments
		 * 
		 */
		// 2. car2 --> set engine
		// 3. print details
		
		Car car1 = new Car();
		Car car2 = new Car("Z4", 'W', 140000.0f);
		Car car3 = new Car("R8", 'B', 130000.0f, new Engine("Audi", 3) );
		
		car2.setEngine(new Engine("BMW", 5));
		
		System.out.println(car1.getDetails());
		System.out.println(car2.displayDetails());
		System.out.println(car3.displayDetails());
	}

}
