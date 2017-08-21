package fly.impl;

import fly.Flyer;

public class Superman implements Flyer{
	
	@Override
	public String fly() {
		return "Superman Flies !";
	}

	@Override
	public void takeOff() {
		System.out.println("Superman Takes-Off !");
	}

	@Override
	public void land() {
		System.out.println("Superman Lands !");
	}
	
	public String stopBullet() {
		return "Yay !";
	}
}
