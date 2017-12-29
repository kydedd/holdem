/**
 * TexasHoldemMain.java
 * The entry point for the Texas Hold'em application
 */
	
/**
 * Created by Kyle Deddo on 01/04/14.
 * Copyright (c) 2014 Kyle Deddo. All rights reserved.
 */

package src;

public class TexasHoldemMain {
	
	TexasHoldemGame game;
	
	public static void main(String[] args) {
		game = new TexasHoldemGame();
		game.startup();
	}
	
}