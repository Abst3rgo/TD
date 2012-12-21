package xmas.tui;

import java.util.Scanner;
import xmas.controller.IController;



public class TextUI {
	
	private IController controller;
	private int y;
	private int x;
	private boolean mode2 = false;
	private Thread timer = new Thread(new Timer());
	private Scanner scanner;
	private String input = "";
	private int time = 330;
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
	public TextUI(IController controller) {
		this.controller = controller;
		scanner = new Scanner(System.in);
	}
	

	//Beim Start Test und Spielfeld ausgeben
	public void printMenue() {
		System.out.println(controller.getStartMessage());
		
		// Spielfeld einstellen
		System.out.println("Spielfeldgr��e w�hlen : ");
		System.out.println("1 = klein ");
		System.out.println("2 = mittel");
		System.out.println("3 = gro�");
		input = scanner.next();
		timer.start();
		// TODO Fehlerbehandlung
		controller.setSpielfeld(input);
		y = (controller.getSpielfeldY());
		x = (controller.getSpielfeldX());
		System.out.println(controller.getSpielfeld());
		
		
	}
	

	// WICHTIG !!!!!!!!!!
	// Schleife die bis zum verlassen durchl�uft
	public boolean iterate() {
		boolean quit = false;
		// User input and Tower set // Modus 1
		if(!mode2) {
			quit = handleinput();
			System.out.println(controller.getSpielfeld());
			if(timeOut) {
				mode2 = true;
			}
		}
		// Create and Move Mobs // Modus 2
		if(!quit && mode2) {
			time = 10;
			timeOut = false;
			
			// Wenn Welle vor�ber gehe zu Modus 1 zur�ck
			int erg = controller.startGame();
			System.out.println(controller.getSpielfeld());
			if(erg == 1) {
				mode2 = false;
			}
			else if( erg == -1) {
				quit = true;
				System.out.println("VERLOREN !!!!");
			}
		}
		return quit;
	}

	// Verarbeitete Eingabe und verl�sst gegenbenfalls Schleife
	private boolean handleinput() {
		boolean create = false;
		int art = 0;
		int zeile = 0;
		
		System.out.println("W�hlen einen Palmentower aus ... ");
		System.out.println("Kokusnuss = K  / Lammeta = L  / Christkugeln = C | Quit = q ");
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
		
		
		
		System.out.println("W�hle die Zeile f�r den Palmentower ... ");
		System.out.println("Zahl von 2 bis " + (y-2) + " | Quit = q");
		input = scanner.next();
		// Pr�fe ob richtige Eingabe
		if(2 <= Integer.parseInt(input) && Integer.parseInt(input) < y) {
			zeile = Integer.parseInt(input);
		} else {
			return quitOrFailure(input);
		}
		
		
		
		System.out.println("W�hle Spalte f�r den Palmentower ... ");
		System.out.println(" Zahl von 2 bis " + (x-2) + " | Quit = q");
		input = scanner.next();
		if(2 <= Integer.parseInt(input) && Integer.parseInt(input) < x) {
			
			create = controller.erstelleTower(art, Integer.parseInt(input), zeile);
		} else {
			return quitOrFailure(input);
		}
		if(create) {
			System.out.println("Tower erstellt !!!");
		} else {
			System.out.println("Tower nicht erstellt");
		}
		return false;

	}
	
	
	public boolean quitOrFailure(String input) {
		// if Q is pressed Game quits
		if(input.equalsIgnoreCase("q")) {
			System.out.println("!!! Spiel wird beendet !!!");
			return true;
		} else {
			System.out.println("!!! Falsche Eingabe. Bitte erneut setzen");
			handleinput();
			return false;	
		}	
	}
}
