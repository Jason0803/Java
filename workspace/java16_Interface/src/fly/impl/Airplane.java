package fly.impl;

import fly.Flyer;

public class Airplane implements Flyer{
	
	@Override
	public String fly() {
		return "Airplane Flies !";
	}

	@Override
	public void takeOff() {
		System.out.println("Airplane Takes-Off !");
	}

	@Override
	public void land() {
		System.out.println("Airplane Lands !");
	}

	
}
