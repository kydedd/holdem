/**
 * TexasHoldemRound.java
 */

package src;

public class TexasHoldemRound {
	
	public void start() {
		table.moveDealerButton();
		dealer.shuffleDeck();
		dealer.dealHoleCards();
		table.resetActionIndex();
		table.resetBoard();
	}
	public void preflop() {
		table.postBlinds();
		table.displayPot();
		while (true) {
			if (table.playerOnAction.getHasFolded() == false) {
				table.playerOnAction.actionPreflop();
			}
			table.moveActionIndex();
			if (table.getActionIndex() == table.getCurrentBetIndex()) {
				break;
			}
		}
	}
	public void flop() {
		table.resetActionIndex();
		dealer.dealFlop();
		while (true) {
			if (table.playerOnAction.getHasFolded() == false) {
				table.playerOnAction.actionPreflop();
			}
			table.moveActionIndex();
			if (table.getActionIndex() == table.getCurrentBetIndex()) {
				break;
			}
		}
	}
	public void turn() {
		table.resetActionIndex();
		dealer.dealTurn();
		while (true) {
			if (table.playerOnAction.getHasFolded() == false) {
				table.playerOnAction.actionPreflop();
			}
			table.moveActionIndex();
			if (table.getActionIndex() == table.getCurrentBetIndex()) {
				break;
			}
		}
	}
	public void river() {
		table.resetActionIndex();
		dealer.dealRiver();
		while (true) {
			if (table.playerOnAction.getHasFolded() == false) {
				table.playerOnAction.actionPreflop();
			}
			table.moveActionIndex();
			if (table.getActionIndex() == table.getCurrentBetIndex()) {
				break;
			}
		}
	}
	public void showdown() {
		// code to rank holdem hands
	}
	
}