package pizza.parent;

public abstract class Pizza {
	private int price;
	private String storeName;
	
	/*
	public Pizza() {
		super();
	}
	 */
	
	public Pizza(int price, String storeName) {
		super();
		this.price = price;
		this.storeName = storeName;
	}
	
	public void dough() {
		System.out.println("Make Dough");
	}
	
	public void bake() {
		System.out.println("Bake on 180 degree");
	}
	
	public abstract void topping();
	
	public void cut() {
		System.out.println("Cut into 8 pieces");
	}
	
	public void makePizza() {
		dough();
		topping();
		bake();
		cut();
	}
	
	@Override
	public String toString() {
		return storeName + " :" + price;
	}
}
