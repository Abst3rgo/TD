package xmas.application;

import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import xmas.gui.GUI;
import xmas.tui.TextUI;

import com.google.inject.Guice;
import com.google.inject.Injector;

public final class Xmas {
	
	
	private Xmas() {
		
	}

	
	//------------------------------------------Main Mehtode Start Programm-----------------------------
	
	public static void main(String[] args) {
		
		PropertyConfigurator.configure("log4j.properties");
		
		Injector injector = Guice.createInjector(new XmasModule());
		
		TextUI tui = injector.getInstance(TextUI.class);
		
		//GUI gui = new GUI();
		
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		// StartMessage
		tui.printStartMenue();
		tui.setStartMenue(scanner.next());
		
		
		// Dauerschleife die bei Ablauf der Zeit vom Setzen auf den Spielen Modus wechselt
		boolean quit = false;
		
		while (!quit) {
			
			if(!tui.timeOver()) {
				for(int i = 0; i < 3; i++) {
					tui.printInstuktion(i);
					quit = tui.handleInput(scanner.next(), i);
					if(quit) {
						break;
					}
				}
			} 
			else {
				tui.iterate();
			}
		}
		tui.printTui("Spiel Beendet !!!!");
	}
}

