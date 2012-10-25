package xmas.application;

import xmas.controller.Controller;
import xmas.tui.TextUI;

public class Xmas {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		TextUI tui = new TextUI(new Controller());
		// StartMessage
		tui.printMenue();
		// Dauerschleife
		boolean quit = false;
		while (!quit) {
		    quit = tui.iterate();
		}
		
	}
}

