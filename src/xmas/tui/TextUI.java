package xmas.tui;


import org.apache.log4j.Logger;

import com.google.inject.Inject;

import xmas.controller.IController;



public class TextUI {
	
	private IController controller;
	private int y;
	private int x;
	
	int art = 0;
	int spalte = 0;
	int zeile  = 0;
	
	
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

	public void printInstuktion(int i) {
		if(i == 0) {
			printTui("Wählen einen Palmentower aus ... " +
					newLine + "Kokusnuss = K  / Lammeta = L  / Christkugeln = C | Quit = u.a ");
		}
		else if(i == 1) {
			printTui("Wähle die Spalte für den Palmentower ... " +
				newLine + "Zahl von 2 bis " + (y-2));
		}
		else {
			printTui("Wähle Zeile für den Palmentower ... " +
					newLine + " Zahl von 2 bis " + (x-2));
		}
	}

	public boolean handleInput(String input, int index) {
		
		// erster Durchgang wähle Towerart
		if(index == 0) {
			if(input.equalsIgnoreCase("k")) {
				art = 0;
			}
			else if(input.equalsIgnoreCase("l")) {
				art = 1;
			}
			else if(input.equalsIgnoreCase("c")) {
				art = 2;
			} 
			else {
				return true;
			}
		}
		
		// zweiter Durchgang wähle Spalte
		else if(index == 1) {
			spalte = Integer.parseInt(input);
			if ( spalte < 2 || spalte > y) {
				return true;
			}
		}
		
		// dritter Durchgang wähel Zeile
		else {
			zeile = Integer.parseInt(input);
			if ( zeile < 2 || zeile > x) {
				return true;
			}
			
			createTower();
		}
		return false;
	}

	private void createTower() {
		if(!controller.erstelleTower(art, spalte, zeile)) {
			printTui("Tower konnte nicht gesetz werden ! ");
		}
		printTui(controller.getSpielfeld());
	}
	
	public void printTui(String ausgabe) {
		logger.info(newLine + ausgabe);
	}

}
