package fly.impl;

public class Eagle extends Bird {
	public void eat() {
		System.out.println("Eagle eats !");
	}
	
	@Override
	public String fly() {
		return super.fly() + " : Eagle"; 
	}
}
