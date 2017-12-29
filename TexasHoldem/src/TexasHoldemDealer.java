/**
 * TexasHoldemDealer.java
 */

package src;

import java.util.Random;

public class TexasHoldemDealer {
	
	private TexasHoldemCard[] deck = new TexasHoldemCard[52];
	private int deckIndex;
	private void dealCard() {
		deckIndex = deckIndex + 1;
		return deck[deckIndex];
	}
	
	public TexasHoldemDealer() {
		Random rand = new Random();
		for (int i = 0, j = 2; j <= 14; i += 4, ++j) {
			deck[i].initialize(j, kClub);
			deck[i + 1].initialize(j, kDiamond);
			deck[i + 2].initialize(j, kHeart);
			deck[i + 3].initialize(j, kSpade);
		}
	}
	public void shuffleDeck() {
		for (int i = 0; i <= 51; ++i) {
			int j = rand.nextInt(52);
			TexasHoldemCard temp = deck[j];
			deck[j] = deck[i];
			deck[i] = temp;
		}
		deckIndex = 0;
	}
	public void dealHoleCards() {
		int numberOfCards = table.getPlayerNumber() * 2;
		TexasHoldemCard[] holeCards = new TexasHoldemCard[numberOfCards];
		for (int i = 0; i <= numberOfCards; ++i) {
			holeCards[i] = getCard();
		}
		table.setPlayerHoleCards(holeCards);
	}
	public void dealFlop() {
		TexasHoldemCard[] flop = new TexasHoldemCard[3];
		for (int i = 0; i < 3; ++i) {
			flop[i] = getCard();
		}
		table.setFlop(flop);
		table.displayFlop();
		
	}
	public void dealTurnCard() {
		TexasHoldemCard turnCard = new TexasHoldemCard();
		turnCard = getCard();
		table.setTurnCard(turnCard);
		table.displayTurn();
		
	}
	public void dealRiverCard() {
		TexasHoldemCard riverCard = new TexasHoldemCard();
		riverCard = getCard();
		table.setRiverCard(riverCard);
		table.displayRiver();
		
	}
	
}