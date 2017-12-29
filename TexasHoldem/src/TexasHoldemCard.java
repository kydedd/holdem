/* TexasHoldemCard.java
 * simulates a standard playing card with rank and suit
 */

package src;

public class TexasHoldemCard {
	
	private static final kAce = 14;
	private static final kKing = 13;
	private static final kQueen = 12;
	private static final kJack = 11;
	private int rank;
	private Suit suit;
	private enum Suit {
		kHeart,
		kDiamond,
		kClub,
		kSpade
	}
	
	public void initialize(int rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	public int getRank() {
		return rank;
	}
	public Suit getSuit() {
		return suit;
	}
	public void display() {
		if (rank <= 10) {
			System.out.print(rank);
		} else {
			switch (rank) {
				case kJack:
					System.out.print("J");
					break;
				case kQueen:
					System.out.print("Q");
					break;
				case kKing:
					System.out.print("K");
					break;
				case kAce:
					System.out.print("A");
			}
		}
		switch (suit) {
			case kHeart:
				System.out.print((char)3 + " ");
				break;
			case kDiamond:
				System.out.print((char)4) + " ";
				break;
			case kClub:
				System.out.print((char)5 + " ");
				break;
			case kSpade:
				System.out.print((char)6 + " ");
		}
	}
	
}