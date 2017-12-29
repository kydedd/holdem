/* TexasHoldemNPC.java
 * 
 */

package src;

public class TexasHoldemNPC extends TexasHoldemPlayer {
	
	private float findCardValue(TexasHoldemCard card) {
		float cardValue;
		if (card.getRank > 10) {
			switch (card.getRank) {
				case 14:
					cardValue = 10;
					break;
				case 13:
					cardValue = 8;
					break;
				case 12:
					cardValue = 7;
					break;
				case 11:
					cardValue = 6;
			}
		} else {
			cardValue = card.getRank() * 0.5;
		}
		return cardValue;
	}
	private int findPreflopHandValue() {
		float preflopHandValue = findCardValue(holeCards[0]);
		if (holeCards[0].getRank() == holeCards[1].getRank()) {
			preflopHandValue = preflopHandValue * 2.0;
			if (preflopHandValue < 5.0) {
				preflopHandValue = 5.0;
			}
		} else {
			if (holeCards[0].getSuit == holeCards[1].getSuit()) {
				preflopHandValue = preflopHandValue + 2;
			}
			int gap = holeCards[0].getRank() - holeCards[1].getRank();
			switch (gap) {
				case 1:
					if (holeCards[0].getRank() < 12) {
						preflopHandValue = preflopHandValue + 1;
					} else {
						preflopHandValue = preflopHandValue - 0;
					}
					break;
				case 2:
					if (holeCards[0].getRank() < 12) {
						preflopHandValue = preflopHandValue - 0;
					} else {
						preflopHandValue = preflopHandValue - 1;
					}
					break;
				case 3:
					preflopHandValue = preflopHandValue - 2;
					break;
				case 4:
					preflopHandValue = preflopHandValue - 4;
					break;
				default:
					preflopHandValue = preflopHandValue - 5;
			}
		}
		return (int)(preflopHandValue + 0.5);
	}
	
	public void actionPreflop() {
		int preflopHandValue = findPreflopHandValue();
		TablePosition position = table.findPlayerOnActionPostion();
		if (table.getPlayerNumber > 6) {
			switch (postion) {
				case kEarly:
					if (preflopHandValue >= 10) {
						raise(3 * table.getCurrentBet());
					} else {
						if (table.getActionIndex() == table.getBigBlindIndex()) {
							// ****
						} else {
							fold();
						}
					}
					break;
				case kMiddle:
					if (preflopHandValue >= 9) {
						raise(3 * table.getCurrentBet());
					} else {
						fold();
					}
					break;
				case kLate:
					if (preflopHandValue >= 7) {
						raise(3 * table.getCurrentBet());
					} else {
						fold();
					}
					break;
			}
		} else {
			switch (postion) {
				case kEarly:
					if (preflopHandValue >= 9) {
						raise(3 * table.getCurrentBet());
					} else {
						fold();
					}
					break;
				case kMiddle:
					if (preflopHandValue >= 8) {
						raise(3 * table.getCurrentBet());
					} else {
						fold();
					}
					break;
				case kLate:
					if (preflopHandValue >= 7) {
						raise(3 * table.getCurrentBet());
					} else {
						fold();
					}
					break;
			}
		}
	}
	public void actionFlop() {
		
	}
	public void actionTurn() {
		
	}
	public void actionRiver() {
		
	}
	
}