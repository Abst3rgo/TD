package xmas.tui;

import java.util.Scanner;

import xmas.controller.Controller;

public class TextUI {
	
	private Controller controller;
	Scanner scanner;

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
	

	// Schleife die bis zum verlassen durchl�uft
	public boolean iterate() {
		boolean quit = false;
		quit = inputorQuit();
		return quit;
	}

	// Verarbeitete Eingabe und verl�sst gegenbenfalls Schleife
	private boolean inputorQuit() {
		String input;
		int art;
		int reihe;
		
		System.out.println("W�hlen einen Palmentower aus ... ");
		System.out.println("Kokusnuss = k  / Lammeta = l  / Christkugeln = c | Quit = q ");
		// Wenn Q f�r verlassen gerd�ckt wird;
		input = scanner.next();
		if(input.equalsIgnoreCase("q")) {
			System.out.println("!!! Spiel wird beendet !!!");
			return true;
		} else {
			// Eingabenverarbeitung Tower oder falsche Eingabe
			switch(input) {
			case "k":
			case "K": 
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
				System.out.println("!!! Falsche Eingabe !!!");
				System.out.println("!!! Spiel wird beendet !!!");
				return true;
			}
		}
		
		System.out.println("W�hle die Reihe aus indie die gesetz wird ... ");
		System.out.println("Reihe1 = 1 / Reihe2 = 2 | Quit = q");
		// Wenn Q f�r verlassen gerd�ckt wird;
		input = scanner.next();
		if(input.equalsIgnoreCase("q")) {
			System.out.println("!!! Spiel wird beendet !!!");
			return true;
		} else {
			if(input.equals("1")) {
				reihe = 1;
			}
			else if (input.equals("2")){
				reihe = 2;
			} else {
				System.out.println("!!! Falsche Eingabe !!!");
				System.out.println("!!! Spiel wird beendet !!!");
				return true;
			}
		}
		
		System.out.println("W�hle Platz f�r den Palmentower ... ");
		System.out.println("P1 = p1 / P2 = p2 / P3 = p3 / P4 = p4 / P5 = p5 / P6 = p6 | Quit = q");
		input = scanner.next();
		// Wenn Q f�r verlassen gerd�ckt wird;
		if(input.equalsIgnoreCase("q")) {
			System.out.println("!!! Spiel wird beendet !!!");
			return true;
		} else {
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
				System.out.println("!!! Falsche Eingabe !!!");
				System.out.println("!!! Spiel wird beendet !!!");
				return true;	
			}	
		}
		return false;
	}
}
