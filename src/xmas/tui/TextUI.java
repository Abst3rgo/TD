package xmas.tui;


import org.apache.log4j.Logger;

import com.google.inject.Inject;

import xmas.controller.IController;



public class TextUI {
	
	private IController controller;
	private int y;
	private int x;
	
	
	private StringBuffer buffer = new StringBuffer();
	private String newLine = System.getProperty("line.separator");
	private Logger logger = Logger.getLogger("xmas.tui");
	

	//Konstruktor
	@Inject
	public TextUI(IController controller) {
		this.controller = controller;
	}
	
	public boolean timeOver() {
		return controller.timeOver();
	}
	

	//Beim Start Test und Spielfeld ausgeben
	public void printStartMenue() {
		buffer.append(controller.getStartMessage() + 
				
		// Spielfeld einstellen
				newLine + "Spielfeldgröße wählen : " +
				newLine + "1 = klein " +
				newLine + "2 = mittel" +
				newLine + "3 = groß");
		
		printTui(buffer.toString());
	}
	
	public void setStartMenue(String input) {
		// TODO Thread auslagern
		
		
		// TODO Fehlerbehandlung von input
		controller.setSpielfeld(input);
		y = (controller.getSpielfeldY());
		x = (controller.getSpielfeldX());
		printTui(controller.getSpielfeld());
	}
	
	public void iterate() {
		// Bedinungen
			if(controller.startGame() == 1) {
				printTui("Welle vorüber !");
			}
			printTui(controller.getGameMessage());
			printTui(controller.getSpielfeld());
				
	}
	
/*
	// WICHTIG !!!!!!!!!!
	// Schleife die bis zum verlassen durchläuft
	public boolean iterate() {
		boolean quit = false;
		// User input and Tower set // Modus 1
		if(!mode2) {
			quit = handleinput();
			if(!quit) {
				logger.info( newLine + controller.getSpielfeld());
			}
			if(timeOut) {
				mode2 = true;
			}
		}
		// Create and Move Mobs // Modus 2
		if(!quit && mode2) {
			time = 10;
			timeOut = false;
			
			// Wenn Welle vorüber gehe zu Modus 1 zurück
			int erg = controller.startGame();
			logger.info( newLine + controller.getGameMessage());
			logger.info( newLine + controller.getSpielfeld());
			if(erg == 1) {
				mode2 = false;
			}
			else if( erg == -1) {
				quit = true;
				logger.info( newLine + "VERLOREN !!!!");
			}
		}
		return quit;
	}
	
	*/


	public void printInstuktion(int i) {
		if(i == 0) {
			printTui("Wählen einen Palmentower aus ... " +
					newLine + "Kokusnuss = K  / Lammeta = L  / Christkugeln = C | Quit = q ");
		}
		else if(i == 1) {
			printTui("Wähle die Zeile für den Palmentower ... " +
				newLine + "Zahl von 2 bis " + (y-2));
		}
		else {
			printTui("Wähle Spalte für den Palmentower ... " +
					newLine + " Zahl von 2 bis " + (x-2));
		}
	}


	public void printTui(String ausgabe) {
		logger.info(newLine + ausgabe);
	}


	public boolean handleInput(String input, int index) {
		
		int art = 0;
		int spalte = 0;
		int zeile  = 0;
		
		// erster Durchgang wähle Towerart
		if(index == 0) {
			if(input.equals("K") || input.equals("k")) {
				art = 0;
			}
			else if(input.equals("L") || input.equals("l")) {
				art = 1;
			}
			else if(input.equals("c") || input.equals("C")) {
				art = 2;
			} 
			else {
				return true;
			}
		}
		
		// zweiter Durchgang wähle Spalte
		else if(index == 1) {
			spalte = Integer.parseInt(input);
			if ( spalte < 2 && spalte > y) {
				return true;
			}
		}
		
		// dritter Durchgang wähel Zeile
		else if(index == 2) {
			zeile = Integer.parseInt(input);
			if ( zeile < 2 && zeile > x) {
				return true;
			}
			
			controller.erstelleTower(art, spalte, zeile);
			printTui(controller.getSpielfeld());
		}
		else {
			printTui("Fehler");
		}
		return false;
	}
	
	/*
	public boolean quitOrFailure(String input, int index) {
		// if Q is pressed Game quits
		if(input.equalsIgnoreCase("q")) {
			logger.info( newLine + "!!! Spiel wird beendet !!!");
			return true;
		} else {
			logger.info( newLine + "!!! Falsche Eingabe. Bitte erneut setzen");
			iterate(int i, String input)
			return false;	
		}	
	}
	*/

}
