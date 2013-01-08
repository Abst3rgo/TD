package xmas.application;

import org.apache.log4j.PropertyConfigurator;

import xmas.tui.TextUI;

import com.google.inject.Guice;
import com.google.inject.Injector;

public final class Xmas {
	
	public static void main(String[] args) {
		
		PropertyConfigurator.configure("log4j.properties");
		
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

