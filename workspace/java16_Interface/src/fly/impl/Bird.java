package fly.impl;

import fly.Flyer;

public class Bird implements Flyer{
	private String kind;
	
	@Override
	public String fly() {
		return "Bird Flies !";
	}

	@Override
	public void takeOff() {
		System.out.println("Bird Takes-Off !");
	}

	@Override
	public void land() {
		System.out.println("Bird Lands !");
	}

	public String layEggs(String kind) {
		this.kind = kind;
		return "Bird [" + kind + "] Lays eggs !";
	}
	
}
