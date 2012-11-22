package xmas.tui;

import java.util.Scanner;

import xmas.controller.Controller;

public class TextUI {
	
	private Controller controller;
	private int y;
	private int x;
	Scanner scanner;

	//Konstruktor
	public TextUI(Controller controller) {
		this.controller = controller;
		scanner = new Scanner(System.in);
		y = (controller.getSpielfeldY());
		x = (controller.getSpielfeldX());
	}

	//Beim Start Test und Spielfeld ausgeben
	public void printMenue() {
		System.out.println(controller.getStartMessage());
		System.out.println(controller.getSpielfeld());
	}
	

	// WICHTIG !!!!!!!!!!
	// Schleife die bis zum verlassen durchl�uft
	public boolean iterate() {
		boolean quit = false;
		boolean mode1 = true;
		// User input and Tower set // Modus 1
		if(mode1) {
		quit = handleinput();
		System.out.println(controller.getSpielfeld());
		}
		/*
		mode1 = false;
		// Create and Move Mobs // Modus 2
		if(!quit) {
			quit = controller.startGame();
		}
		*/
		return quit;
	}

	// Verarbeitete Eingabe und verl�sst gegenbenfalls Schleife
	private boolean handleinput() {
		String input = "";
		int art = 0;
		int spalte = 0;
		
		System.out.println("W�hlen einen Palmentower aus ... ");
		System.out.println("Kokusnuss = K  / Lammeta = L  / Christkugeln = C | Quit = q ");
		input = scanner.next();
		switch(input) {
			case "K":
			case "k": 
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
		
		
		
		System.out.println("W�hle die Spalte f�r den Palmentower ... ");
		System.out.println("Zahl von 2 bis " + (y-2) + " | Quit = q");
		input = scanner.next();
		// Pr�fe ob richtige Eingabe
		if(2 <= Integer.parseInt(input) && Integer.parseInt(input) < y) {
			spalte = Integer.parseInt(input);
		} else {
			return quitOrFailure(input);
		}
		
		
		
		System.out.println("W�hle Zeile f�r den Palmentower ... ");
		System.out.println(" Zahl von 2 bis " + (x-2) + " | Quit = q");
		input = scanner.next();
		if(2 <= Integer.parseInt(input) && Integer.parseInt(input) < x) {
			controller.erstelleTower(art, spalte, Integer.parseInt(input));
		} else {
			return quitOrFailure(input);
		}
		
		System.out.println("Tower erstellt !!!");
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
