package xmas.tui;

import java.util.Scanner;
import xmas.controller.IController;



public class TextUI {
	
	boolean timeOver = false;
	private IController controller;
	private int y;
	private int x;
	private boolean mode2 = false;
	private Thread timer = new Thread(new Timer());
	Scanner scanner;

	
	public class Timer extends Thread {
		
		int time = 10;
		
		public void run() {
			try {
				while(true) {
					sleep(100);
					if(time != 0) {
						time--;
					} else {
						timeOver = true;
					}
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
		y = (controller.getSpielfeldY());
		x = (controller.getSpielfeldX());
		timer.start();
	}
	

	//Beim Start Test und Spielfeld ausgeben
	public void printMenue() {
		System.out.println(controller.getStartMessage());
		System.out.println(controller.getSpielfeld());
	}
	

	// WICHTIG !!!!!!!!!!
	// Schleife die bis zum verlassen durchläuft
	@SuppressWarnings("deprecation")
	public boolean iterate() {
		boolean quit = false;
		// User input and Tower set // Modus 1
		if(!mode2) {
			quit = handleinput();
			System.out.println(controller.getSpielfeld());
			if(timeOver == true) {
				mode2 = true;
				System.out.println("Thread Tod");
				timer.stop();
			}
		}
		// Create and Move Mobs // Modus 2
		if(!quit && mode2) {
			System.out.println("Mob laufen los ");
			quit = controller.startGame();
			System.out.println(controller.getSpielfeld());
			scanner.next();
		}
		return quit;
	}

	// Verarbeitete Eingabe und verlässt gegenbenfalls Schleife
	private boolean handleinput() {
		boolean create = false;
		String input = "";
		int art = 0;
		int spalte = 0;
		
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
		
		
		
		System.out.println("Wähle die Spalte für den Palmentower ... ");
		System.out.println("Zahl von 2 bis " + (y-2) + " | Quit = q");
		input = scanner.next();
		// Prüfe ob richtige Eingabe
		if(2 <= Integer.parseInt(input) && Integer.parseInt(input) < y) {
			spalte = Integer.parseInt(input);
		} else {
			return quitOrFailure(input);
		}
		
		
		
		System.out.println("Wähle Zeile für den Palmentower ... ");
		System.out.println(" Zahl von 2 bis " + (x-2) + " | Quit = q");
		input = scanner.next();
		if(2 <= Integer.parseInt(input) && Integer.parseInt(input) < x) {
			create = controller.erstelleTower(art, Integer.parseInt(input) , spalte);
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
