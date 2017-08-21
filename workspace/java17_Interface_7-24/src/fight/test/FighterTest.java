package fight.test;

import fight.Attackable;
import fight.Fightable;
import fight.Movable;
import fight.child.Fighter;
import fight.parent.Unit;

public class FighterTest {

	public static void main(String[] args) {
		Fighter fighter = new Fighter();
		
		if(fighter instanceof Unit) {
			System.out.println("Unit 의 자손");
		}
		if(fighter instanceof Fightable) {
			System.out.println("Fightable 의 자손");
		}
		if(fighter instanceof Movable) {
			System.out.println("Movable 의 자손");
		}
		if(fighter instanceof Attackable) {
			System.out.println("Attackable 의 자손");
		}
		if(fighter instanceof Object) {
			System.out.println("Object 의 자손");
		}
	}

}
