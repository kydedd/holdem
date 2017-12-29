/**
 * TexasHoldemTable.java
 */

package src;

import java.util.Random; // for starting dealer button position

public class TexasHoldemTable {
	
	private int playerNumber;
	private TexasHoldemPlayer[] player = new TexasHoldemPlayer[9];
	private int dealerButtonIndex, smallBlindIndex, bigBlindIndex;
	private int actionIndex;
	private int smallBlind, bigBlind;
	private int pot;
	private TexasHoldemCard[] board = new TexasHoldemCard[5];
	private int currentBet;
	private int currentBetIndex;
	
	enum TablePostion {
		kEarly,
		kMiddle,
		kLate
	}
	
	public Player playerOnAction;
	public TexasHoldemTable {
		playerNumber = 9;
		player[0] = new TexasHoldemUser();
		player[0].setName("Player");
		player[1].setName("Avery");
		player[2].setName("Brian");
		player[3].setName("Cindy");
		player[4].setName("David");
		player[5].setName("Elise");
		player[6].setName("Frank");
		player[7].setName("Grace");
		player[8].setName("Henry");
		Random rand = new Random();
		dealerButtonIndex = rand.nextInt() % 9;
	}
	public void setUserName(String name) {
		player[0].setName(name);
	}
	public void displayRankings() {
		for (int i = 0; i < playerNumber; ++i) {
			
		}
	}
	public int getPlayerNumber {
		return playerNumber;
	}
	public void postBlinds() {
		player[smallBlindIndex].postSmallBlind(smallBlind);
		player[bigBlindIndex].postBigBlind(bigBlind);
	}
	// method will cause problems when players are eliminated
	public void moveDealerButton() {
		if (dealerButtonIndex < playerNumber - 1) {
			dealerButtonIndex = dealerButtonIndex + 1;
		} else {
			dealerButtonIndex = 0;
		}
		if (playerNumber > 2) {
			if (smallBlindIndex != playerNumber - 1) {
				smallBlindIndex = smallBlindIndex + 1;
			} else {
				smallBlindIndex = 0;
			}
			if (bigBlindIndex != playerNumber - 1) {
				bigBlindIndex = bigBlindIndex + 1;
			} else {
				bigBlindIndex = 0;
			}
		} else {
			smallBlindIndex = dealerButtonIndex;
			if (dealerButtonIndex == 0) {
				bigBlindIndex = 1;
			} else {
				bigBlindIndex = 0;
			}
		}
	}
	public void displayPot() {
		System.out.println("Pot: $" + pot);
	}
	public void setPlayerHoleCards(TexasHoldemCard[] holeCards) {
		for (int i = 0, j = 0; i < playerNumber; ++i, j += 2) {
			player[i].setHoleCards(holeCards[j], holeCards[j + 1]);
		}
	}
	public void resetActionIndex() {
		if (dealerButtonIndex != playerNumber - 1) {
			actionIndex = dealerButtonIndex + 1;
		} else {
			actionIndex = 0;
		}
		playerOnAction = player[actionIndex];
	}
	public void moveAction() {
		if (actionIndex != playerNumber - 1) {
			actionIndex = actionIndex + 1;
		} else {
			actionIndex = 0;
		}
		playerOnAction = player[actionIndex];
	}
	public int getActionIndex() {
		return actionIndex;
	}
	public void resetBoard() {
		for (int i = 0; i < 5; ++i) {
			board[i] = null;
		}
	}
	public void setFlop(TexasHoldemCard[] flop) {
		for (int i = 0; i < 3; ++i) {
			board[i] = flop[i];
		}
	}
	public void displayFlop() {
		System.out.print("Dealer deals flop: ");
		for (int i = 0; board[i] != null; ++i) {
			board[i].display();
		}
	}
	public void setTurnCard(TexasHoldemCard turnCard) {
		board[3] = turnCard;
	}
	public void displayTurn() {
		System.out.print("Dealer deals turn card: ");
		for (int i = 0; board[i] != null; ++i) {
			board[i].display();
		}
	}
	public void setRiverCard(TexasHoldemCard riverCard) {
		board[4] = riverCard;
	}
	public void displayRiver() {
		System.out.print("Dealer deals river card: ");
		for (int i = 0; board[i] != null; ++i) {
			board[i].display();
		}
	}
	public TablePostion findPlayerOnActionPosition() {
		int seatsFromDealer = 0;
		for (int i = dealerButtonIndex; i != actionIndex; ++i) {
			seatsFromDealer = seatsFromDealer + 1;
			if (i >= playerNumber) {
				i = 0;
			}
		}
		float percentile = (float)seatsFromDealer / playerNumber;
		TablePostion position;
		if (0.0 < percentile && percentile < 0.34) {
			postion = kEarly;
		} else if (0.34 < percentile && percentile < 0.67) {
			position = kMiddle;
		} else {
			position = kLate;
		}
		return position;
	}
	public TexasHoldemCard[] getBoard() {
		return board;
	}
	public void setCurentBet(int currentBet) {
		this.currentBet = currentBet;
		currentBetIndex = actionIndex;
	}
	public int getCurrentBet() {
		return currentBet;
	}
	public int getCurentBetIndex() {
		return currentBetIndex;
	}
	
}