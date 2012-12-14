package xmas.application;

import xmas.controller.impl.Controller;
import xmas.tui.TextUI;

public class Xmas {
	
	private Xmas() {
		
	}
	
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
		
		System.out.println("Programm Ende");
	}
}

