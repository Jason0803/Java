package fly.test;

import fly.Flyer;
import fly.impl.Airplane;
import fly.impl.Bird;
import fly.impl.Eagle;
import fly.impl.Superman;

public class FlyerAppTest {

	public static void main(String[] args) {
		Flyer bird = new Bird(); 
		Flyer superman = new Superman();
		Flyer airplane = new Airplane();
		Bird eagle = new Eagle();
		
		bird.fly();
		superman.fly();
		airplane.fly();
		System.out.println(eagle.fly());
		
		if( bird instanceof Bird ){
			Bird b = (Bird)bird;
			System.out.println(b.layEggs("Pigeon"));
			System.out.println(Flyer.color);
		}
	}

}
