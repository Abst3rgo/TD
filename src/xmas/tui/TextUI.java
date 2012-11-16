package xmas.tui;

import java.util.Scanner;

import xmas.controller.Controller;

public class TextUI {
	
	private Controller controller;
	Scanner scanner;
	private int inputdurchlauf = 0;

	//Konstruktor
	public TextUI(Controller controller) {
		this.controller = controller;
		scanner = new Scanner(System.in);
	}

	//Beim Start Test und Spielfeld ausgeben
	public void printMenue() {
		System.out.println(controller.getStartMessage());
		System.out.println(controller.getSpielfeld());
	}
	

	// WICHTIG !!!!!!!!!!
	// Schleife die bis zum verlassen durchläuft
	public boolean iterate() {
		boolean quit = false;
		// User input and Tower set // Modus 1
		quit = handleinput();
		// Create and Move Mobs // Modus 2
		if(!quit) {
			quit = controller.startGame();
		}
		return quit;
	}

	// Verarbeitete Eingabe und verlässt gegenbenfalls Schleife
	private boolean handleinput() {
		String input = "";
		int art = 0;
		int reihe = 0;
		
		System.out.println("Wählen einen Palmentower aus ... ");
		System.out.println("Kokusnuss = n  / Lammeta = l  / Christkugeln = c | Quit = q ");
		input = scanner.next();
		switch(input) {
			case "N":
			case "n": 
				art = 0;
				break;
			case "l":
			case "L": 
				art = 1;
				break;
			case "c":
			case "C": 
				art = 2;
				break;
			default: 
				return quitOrFailure(input);
		}
		
		System.out.println("Wähle die Reihe aus indie die gesetz wird ... ");
		System.out.println("Reihe1 = 1 / Reihe2 = 2 | Quit = q");
		input = scanner.next();
		if(input.equals("1")) {
			reihe = 1;
		}
		else if (input.equals("2")){
			reihe = 2;
		} else {
			return quitOrFailure(input);
		}
		
		System.out.println("Wähle Platz für den Palmentower ... ");
		System.out.println("P1 = p1 / P2 = p2 / P3 = p3 / P4 = p4 / P5 = p5 / P6 = p6 | Quit = q");
		input = scanner.next();
		switch(input) {
			case "p1":
				System.out.println(controller.erstelleTower(art, reihe, 1));
				break;
			case "p2":
				System.out.println(controller.erstelleTower(art, reihe, 2));
				break;
			case "p3":
				System.out.println(controller.erstelleTower(art, reihe, 3));
				break;
			case "p4":
				System.out.println(controller.erstelleTower(art, reihe, 4));
				break;
			case "p5":
				System.out.println(controller.erstelleTower(art, reihe, 5));
				break;
			case "p6":
				System.out.println(controller.erstelleTower(art, reihe, 6));
				break;
			default: 
				return quitOrFailure(input);
				
		}
		while(inputdurchlauf < 8) {
			inputdurchlauf++;
			handleinput();
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
