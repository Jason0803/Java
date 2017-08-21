package pizza.child;

import pizza.parent.Pizza;

public class HawaianPizza extends Pizza{

	public HawaianPizza(int price, String storeName) {
		super(price, storeName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void topping() {
		System.out.println("Hawaian Topping Pizza...");
	}

}
