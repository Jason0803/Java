package kosta.service.dice;

public class Dice_3 {
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void selectedNumber() {
		value = (int)(Math.random()*6 + 1);
	}
}
