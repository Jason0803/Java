package kosta.service.dice.test;

import java.util.Scanner;
import kosta.service.dice.pkg.Player_1;

public class DiceTestApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Player_1 player_1 = new Player_1();
		
		System.out.print("Input rounds to play : ");
		int round = sc.nextInt();
		
		player_1.playDice(round);
		
		System.out.print("\nTotal Value of " + round + " rounds " + 
				" : " + player_1.getTatalValue());
	}

}
