package pizza.child;

import pizza.parent.Pizza;

public class ShrimpPizza extends Pizza {

	public ShrimpPizza(int price, String storeName) {
		super(price, storeName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void topping() {
		System.out.println("Shrimp Topping Pizza...");
	}

}
