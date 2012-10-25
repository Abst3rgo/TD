package xmas.controller;

import xmas.parts.Spielfeld;

public class Controller {

	private Spielfeld spielfeld;
	private String StartMessage = "Willkommen bei Xmas Tower Defence !";
	
	public Controller() {
		this.spielfeld  = new Spielfeld();
	}
	
	// return StartMessage
	public String getStartMessage() {
		return StartMessage;
	}
	
	// holt Spielfeld und returnd es
	public String getSpielfeld() {
		return spielfeld.toString();
	}
}
