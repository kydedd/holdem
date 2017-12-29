/**
 * TexasHoldemUser.java
 * 
 */

package src;

import java.util.Scanner;

public class TexasHoldemUser extends TexasHoldemPlayer {
	
	private inputAction() {
		Scanner scan = new Scanner(System.in);
		char action = scan.next();
		int amount;
		switch(action) {
			case 'C':
			case 'c':
				checkOrCall();
				break;
			case 'B':
			case 'b':
				amount = scan.nextInt();
				if (0 < amount && amount <= stack) {
					bet(amount);
				}
				break;
			case 'R':
			case 'r':
				amount = scan.nextInt();
				if (0 < amount && amount <= stack) {
					raise(amount);
				}
				break;
			default:
				fold();
		}
	}
	
	public void actionPreflop() {
		displayNameStack();
		displayHoldCards();
		inputAction();
	}
	public void actionFlop() {
		displayNameStack();
		displayHoldCards();
		
	}
	public void actionTurn() {
		displayNameStack();
		displayHoldCards();
		
	}
	public void actionRiver() {
		displayNameStack();
		displayHoldCards();
		
	}
	
}