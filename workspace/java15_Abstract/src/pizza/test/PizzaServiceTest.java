package pizza.test;

import java.util.Vector;
import pizza.parent.Pizza;
import pizza.child.*;
import pizza.service.PizzaService;

public class PizzaServiceTest {

	public static void main(String[] args) {
		PizzaService service = new PizzaService();
		Vector<Pizza> vp = new Vector<Pizza>();
		
		vp.add(new PotatoPizza(15000, "Pizza Hut"));
		vp.add(new ShrimpPizza(17000, "Domino's"));
		vp.add(new HawaianPizza(15500, "Pizza Hut"));
		vp.add(new PotatoPizza(13500, "abc"));
		
		System.out.println(vp.size());
		System.out.println(vp.capacity());

	}

}
