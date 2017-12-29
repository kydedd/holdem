/**
 * TexasHoldemPlayer.java
 * 
 */

package src;

public class TexasHoldemPlayer {
	
	protected String name;
	protected TexasHoldemCard[] holeCards = new TexasHoldemCard[2];
	protected int stack;
	protected boolean hasfolded;
	
	public void setName(String name) {
		this.name = name;
	}
	public void displayNameStack() {
		System.out.print("\n" + "name" + "[$" + stack + "] ");
	}
	public int getStack() {
		return stack;
	}
	public void postSmallBlind(int smallBlind) {
		stack = stack - smallBlind;
		displayNameStack();
		System.out.print("posts small blind $" + smallBlind);
	}
	public void postBigBlind(int bigBlind) {
		stack = stack - bigBlind;
		displayNameStack();
		System.out.print("posts big blind $" + bigBlind);
	}
	public void setHoleCards(TexasHoldemCard card0, TexasHoldemCard card1) {
		if (card0.getRank() >= card1.getRank()) {
			holeCards[0] = card0;
			holeCards[1] = card1;
		} else {
			holeCards[0] = card1;
			holeCards[1] = card0;
		}
	}
	public void displayHoleCards() {
		holeCards[0].display();
		holeCards[1].display();
	}
	public void fold() {
		setHasFolded(true);
		displayNameStack();
		System.out.print("Folds");
	}
	public void checkOrCall() {
		if (table.getCurrentBet == 0) {
			displayNameStack();
			System.out.print("Checks");
		} else {
			stack = stack - table.getCurrentBet();
			displayNameStack();
			System.out.print("Calls $" + table.getCurrentBet());
		}
	}
	public void bet(int amount) {
		if (amount >= stack) {
			amount = stack;
			stack = stack - amount;
			displayNameStack();
			System.out.print("All in $" + amount);
		} else {
			stack = stack - amount;
			displayNameStack();
			System.out.print("Bets $" + amount);
		}
		table.setCurrentBet(amount);
	}
	public void raise(int amount) {
		if (amount >= stack) {
			amount = stack;
			stack = stack - amount;
			displayNameStack();
			System.out.println("All in $" + amount);
		} else {
			stack = stack - amount;
			displayNameStack();
			System.out.print("Raises to $" + amount);
		}
		table.setCurrentBet(amount);
	}
	protected void setHasFolded(boolean hasFolded) {
		this.hasFolded = hasFolded;
	}
	public boolean getHasFolded() {
		return hasFolded;
	}
	// the followng methods will be overridden by subclass
	public void actionPreflop() {}
	public void actionFlop() {}
	public void actionTurn() {}
	public void actionRiver() {}
	
}