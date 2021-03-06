package kosta.service.dice.pkg;

import kosta.service.dice.Dice;
import kosta.service.dice.DiceInterface;

public class Player_2 {

	private int tatalValue = 0;
	private DiceInterface dice;
	

	public DiceInterface getDice() {
		return dice;
	}

	public void setDice(DiceInterface dice) {
		this.dice = dice;
	}

	public int getTatalValue() {
		return tatalValue;
	}

	public void setTatalValue(int tatalValue) {
		this.tatalValue = tatalValue;
	}
	

	public void playDice(int count) {
		for(int i = 0; i < count; i++){
			dice.selectedNumber();
			tatalValue += dice.getValue();
			System.out.println("Dice number for round " + (i+1) + " : " + dice.getValue()); 
		}
	}
	
}
