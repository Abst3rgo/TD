package xmas.application;

import xmas.tui.TextUI;

import com.google.inject.Guice;
import com.google.inject.Injector;

public final class Xmas {
	
	public static void main(String[] args) {
		
		Injector injector = Guice.createInjector(new XmasModule());
		
		TextUI tui = injector.getInstance(TextUI.class);
		
		// StartMessage
		tui.printMenue();
		// Dauerschleife
		boolean quit = false;
		while (!quit) {
		    quit = tui.iterate();
		}
	}
}

