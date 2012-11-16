package xmas.controller;

import xmas.parts.Position;
import xmas.parts.Spielfeld;
import xmas.parts.Tower;
import xmas.parts.TowerKugel;
import xmas.parts.TowerLametta;
import xmas.parts.TowerNuss;

public class Controller {

	private Spielfeld spielfeld;
	private String StartMessage = "Willkommen bei Xmas Tower Defence !";
	private Tower[] towerArr = new Tower[8];
	private int i = 0;
	
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
	
	public String erstelleTower(int art, int reihe, int stelle) {
		
		String done = "Tower wurde erstellt ! \nNächsten Tower positionieren ...";
		// Position p = berechnePosition(reihe, stelle);
		// Art der Towers ermitteln und erstellen
		Tower tower = null;
		switch (art) {
		// Kokusnuss
		case 0:
			tower = new TowerNuss(reihe, stelle);
			break;
		// Lametta
		case 1:
			tower = new TowerLametta(reihe, stelle);
			break;
		// Kugeln
		case 2:
			tower = new TowerKugel(reihe, stelle);
			break;
		}
		towerArr[i++] = tower;
		spielfeld.towerSetzen(tower);
		System.out.println(spielfeld.toString());
		for(int j = 0; j<i; j++){
			Tower out = towerArr[j];
			System.out.println(out.getSymbol());
		}
		
		return done;
		
	}
	

	public Position berechnePosition(int reihe, int stelle ) {
		Position p = new Position(0,0);
		if(reihe == 1) {
			p.setPositionY(20);
		} else {
			p.setPositionY(40);
		}
		switch(stelle) {
		case 1: 
			p.setPositionX(10);
			break;
		case 2: 
			p.setPositionX(20);
			break;
		case 3: 
			p.setPositionX(30);
			break;
		case 4: 
			p.setPositionX(40);
			break;
		case 5: 
			p.setPositionX(50);
			break;
		case 6: 
			p.setPositionX(60);
			break;
		}
		return p;
	}
	
	private void update() {
		
		
	}

}
