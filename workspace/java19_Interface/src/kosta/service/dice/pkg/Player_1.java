package kosta.service.dice.pkg;

import kosta.service.dice.Dice;

public class Player_1 {
	private Dice a = new Dice();
	private int tatalValue = 0;
	
	public Dice getA() {
		return a;
	}

	public void setA(Dice a) {
		this.a = a;
	}

	public int getTatalValue() {
		return tatalValue;
	}

	public void setTatalValue(int tatalValue) {
		this.tatalValue = tatalValue;
	}

	public void playDice(int count) {
		for(int i = 0; i < count; i++){
			a.selectedNumber();
			tatalValue += a.getValue();
			System.out.println("Dice number for round " + (i+1) + " : " + a.getValue()); 
		}
	}
	
}
