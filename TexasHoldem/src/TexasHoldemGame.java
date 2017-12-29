/**
 * TexasHoldemGame.java
 */

package src;

import java.util.Scanner;

public class TexasHoldemGame {
	
	TexasHoldemRound round;
	TexasHoldemTable table;
	TexasHoldemDealer dealer;
	
	public TexasHoldemGame() {
		round = new TexasHoldemRound();
		table = new TexasHoldemTable();
		dealer = new TexasHoldemDealer();
	}
	public void startup() {
		System.out.println();
		System.out.println("Welcome to Texas Hold'em poker!");
		System.out.println("You will face eight other players in this single table tournament.");
		System.out.println("Everyone starts with $2000 and the blinds open at $10/$20.");
		System.out.println("If you lose all of your money you are eliminated.");
		System.out.println("Good luck!");
		displayMenu();
	}
	public void displayMenu() {
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println();
			System.out.println("(S) Start new round");
			System.out.println("(D) Display rankings");
			System.out.println("(Q) Quit");
			System.out.print(">> [S|D|Q]: ");
			char option = scan.nextChar();
			switch (option) {
				case 'S':
					startNewRound();
					break;
				case 'D':
					table.displayRankings();
					break;
				case 'Q':
					quit();
			}
		} while ();
	}
	public void startNewRound() {
		round.start();
		round.preflop();
		round.flop();
		round.turn();
		round.river();
		round.showdown();
	}
	public void quit() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nAre you sure you want to quit?");
		System.out.println("(Y) Yes");
		System.out.println("(C) Cancel");
		System.out.print(">> [Y|C]: ");
		char option = scan.nextChar();
		if (option == 'Y') {
			System.exit(0);
		} else {
			displayMenu();
		}
	}
	
}