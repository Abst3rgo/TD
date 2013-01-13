package xmas.controller.impl;


import xmas.controller.IController;
import xmas.parts.impl.GameHandler;

import xmas.parts.impl.Player;
import xmas.parts.impl.Spielfeld;
import xmas.parts.IGameHandler;
import xmas.parts.IPlayer;
import xmas.parts.ISpielfeld;


public class Controller implements IController {

	private IPlayer player;
	private ISpielfeld spielfeld;
	private IGameHandler gameHandler;

	
	private String message = "";
	
	
	
	
	
	
	//--------------------------Getter und Setter Methoden ------------------------
	
	public Controller() {
		this.player = new Player("Player1");
	}
	
	public boolean erstelleTower(int art, int spalte, int zeile) {
		return gameHandler.erstelleTower(art, spalte, zeile);
	}
	
	public void setSpielfeld(String groese) {
		this.spielfeld  = new Spielfeld(groese);
		this.gameHandler =  new GameHandler(spielfeld, player);
	}
	
	public int getSpielfeldX() {
		return spielfeld.getX();
	}
	
	public int getSpielfeldY() {
		return spielfeld.getY();
	}
	
	// return StartMessage
	public String getStartMessage() {
			return "Willkommen bei Xmas Tower Defence !";
	}
	
	public String getGameMessage() {
		return message;
}
	
	// holt Spielfeld und returnd es
	public String getSpielfeld() {
		return spielfeld.tostring();
	}
	
	public void setPlayerLive(int life) {
		player.setLive(life);
	}

	
	// Return: -1 = SpielerTod / 0 = Spiel geht weiter / 1 = Welle vorüber
	public int startGame() {
		
		
		// Wenn Welle vorüber ?
		if(gameHandler.waveOver()){
			return 1;
		}
		
		
		// Zeit vertreichen lassen 
		gameHandler.delay();
		
		// Mob erstellen und laufen lassen 
		gameHandler.createMob();
			
		// Mob bewegen sich in Richtung Ende
		gameHandler.mobwalk();
		
		
		// Leben Spieler prüfen
		if(player.gameover()) {
			return -1;
		}
		
		
		// Gehe jeden Tower durch der schießen kann
		message = gameHandler.towershot();

		return 0;
	}
	
	
	

	
}
