package kosta.service.dice.impl;

import kosta.service.dice.DiceInterface;

public class DiceImpl implements DiceInterface {
	private int value; 
	
	public DiceImpl(DiceInterface dice) {
		System.out.println("Hi !");
	}

	@Override
	public void selectedNumber() {
		value = (int)(Math.random()*6 + 1);
		
	}
	
	public int getValue() {
		return value;
	}
	
}
