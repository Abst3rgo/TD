package xmas.tui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.google.inject.Inject;

import xmas.controller.IController;



public class TextUI {
	
	private IController controller;
	private int y;
	private int x;
	private boolean mode2 = false;
	private Thread timer = new Thread(new Timer());
	private Scanner scanner;
	private String input = "";
	
	
	private String newLine = System.getProperty("line.separator");
	private Logger logger = Logger.getLogger("xmas.tui");
	
	private int time = 3;
	private final int sleepTimeMS = 1000;
	private boolean timeOut;
	
	public class Timer extends Thread {
		
		public void run() {
			try {
				while(true) {
					if(time != 0) {
						sleep(sleepTimeMS);
						time--;
					} else {
						timeOut = true;
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}
		}
	}

	//Konstruktor
	@Inject
	public TextUI(IController controller) {
		this.controller = controller;
		scanner = new Scanner(System.in);
	}
	

	//Beim Start Test und Spielfeld ausgeben
	public void printMenue() {
		logger.info(newLine + controller.getStartMessage() + 
				
		// Spielfeld einstellen
				newLine + "Spielfeldgröße wählen : " +
				newLine + "1 = klein " +
				newLine + "2 = mittel" +
				newLine + "3 = groß");
		input = scanner.next();
		timer.start();
		// TODO Fehlerbehandlung
		controller.setSpielfeld(input);
		y = (controller.getSpielfeldY());
		x = (controller.getSpielfeldX());
		logger.info( newLine + controller.getSpielfeld());
		
		
	}
	

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

	// Verarbeitete Eingabe und verlässt gegenbenfalls Schleife
	private boolean handleinput() {
		boolean create = false;
		int art = 0;
		int zeile = 0;
		
		logger.info( newLine + "Wählen einen Palmentower aus ... " +
				newLine + "Kokusnuss = K  / Lammeta = L  / Christkugeln = C | Quit = q ");
		input = scanner.next();
		if(input.equals("K") || input.equals("k")) {
			art = 0;
		}
		else if(input.equals("L") || input.equals("l")) {
			art = 1;
		}
		else if(input.equals("c") || input.equals("C")) {
			art = 2;
		} else {
			return quitOrFailure(input);
		}
		
		
		
		logger.info( newLine + "Wähle die Zeile für den Palmentower ... " +
				newLine + "Zahl von 2 bis " + (y-2) + " | Quit = q");
		input = scanner.next();
		// Prüfe ob richtige Eingabe
		if(2 <= Integer.parseInt(input) && Integer.parseInt(input) < y) {
			zeile = Integer.parseInt(input);
		} else {
			return quitOrFailure(input);
		}
		
		
		
		logger.info( newLine + "Wähle Spalte für den Palmentower ... " +
				newLine + " Zahl von 2 bis " + (x-2) + " | Quit = q");
		input = scanner.next();
		if(2 <= Integer.parseInt(input) && Integer.parseInt(input) < x) {
			
			create = controller.erstelleTower(art, Integer.parseInt(input), zeile);
		} else {
			return quitOrFailure(input);
		}
		if(create) {
			logger.info( newLine + "Tower erstellt !!!");
		} else {
			logger.info( newLine + "Tower nicht erstellt");
		}
		return false;

	}
	
	
	public boolean quitOrFailure(String input) {
		// if Q is pressed Game quits
		if(input.equalsIgnoreCase("q")) {
			logger.info( newLine + "!!! Spiel wird beendet !!!");
			return true;
		} else {
			logger.info( newLine + "!!! Falsche Eingabe. Bitte erneut setzen");
			handleinput();
			return false;	
		}	
	}
}
