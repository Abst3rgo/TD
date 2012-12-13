package xmas.tui;

import java.util.Scanner;
import xmas.controller.IController;



public class TextUI {
	
	private IController controller;
	private int y;
	private int x;
	private boolean mode2 = false;
	private Thread timer = new Thread(new Timer());
	Scanner scanner;
	String input = "";
	int time = 10;

	
	public class Timer extends Thread {
		
		public void run() {
			try {
				while(time != 0) {
					sleep(100);
						time--;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//Konstruktor
	public TextUI(IController controller) {
		this.controller = controller;
		scanner = new Scanner(System.in);
		timer.start();
	}
	

	//Beim Start Test und Spielfeld ausgeben
	public void printMenue() {
		System.out.println(controller.getStartMessage());
		// Spielfeld einstellen
		System.out.println("Spielfeldgröße wählen : ");
		System.out.println("1 = klein ");
		System.out.println("2 = mittel");
		System.out.println("3 = groß");
		input = scanner.next();
		// TODO Fehlerbehandlung
		controller.setSpielfeld(input);
		y = (controller.getSpielfeldY());
		x = (controller.getSpielfeldX());
		System.out.println(controller.getSpielfeld());
		
		
	}
	

	// WICHTIG !!!!!!!!!!
	// Schleife die bis zum verlassen durchläuft
	public boolean iterate() {
		boolean quit = false;
		// User input and Tower set // Modus 1
		if(!mode2) {
			quit = handleinput();
			System.out.println(controller.getSpielfeld());
			if(time == 0) {
				mode2 = true;
				System.out.println("Thread Tod");
			}
		}
		// Create and Move Mobs // Modus 2
		if(!quit && mode2) {
			System.out.println("Mob laufen los ");
			// Wenn Welle vorüber gehe zu Modus 1 zurück
			int erg = controller.startGame();
			System.out.println(controller.getSpielfeld());
			if(erg == 1) {
				mode2 = false;
			}
			else if( erg == -1) {
				quit = true;
				System.out.println("VERLOREN NOOB NOOB NOOB !!!!");
			}
			//scanner.next();
		}
		return quit;
	}

	// Verarbeitete Eingabe und verlässt gegenbenfalls Schleife
	private boolean handleinput() {
		boolean create = false;
		int art = 0;
		int zeile = 0;
		
		System.out.println("Wählen einen Palmentower aus ... ");
		System.out.println("Kokusnuss = K  / Lammeta = L  / Christkugeln = C | Quit = q ");
		input = scanner.next();
		if(input.equals("K") || input.equals("k")) {
			art = 0;
		}
		else if(input.equals("L") || input.equals("l")) {
			art = 1;
		}
		else if(input.equals("C") || input.equals("C")) {
			art = 2;
		} else {
			return quitOrFailure(input);
		}
		
		
		
		System.out.println("Wähle die Zeile für den Palmentower ... ");
		System.out.println("Zahl von 2 bis " + (y-2) + " | Quit = q");
		input = scanner.next();
		// Prüfe ob richtige Eingabe
		if(2 <= Integer.parseInt(input) && Integer.parseInt(input) < y) {
			zeile = Integer.parseInt(input);
		} else {
			return quitOrFailure(input);
		}
		
		
		
		System.out.println("Wähle Spalte für den Palmentower ... ");
		System.out.println(" Zahl von 2 bis " + (x-2) + " | Quit = q");
		input = scanner.next();
		if(2 <= Integer.parseInt(input) && Integer.parseInt(input) < x) {
			create = controller.erstelleTower(art, Integer.parseInt(input), zeile);
		} else {
			return quitOrFailure(input);
		}
		if(create == true) {
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
