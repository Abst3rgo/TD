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

	// Schleife die bis zum verlassen durchläuft
	public boolean iterate() {	
		return input_Quit(scanner.next());
	}

	// Verarbeitete Eingabe und verlässt gegenbenfalls Schleife
	private boolean input_Quit(String next) {
		boolean quit = false;
		// Wenn Benutzer q or Q eingiebt stoppt Programm
		return quit;
	}
	
}
