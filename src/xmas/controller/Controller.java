package xmas.controller;

import xmas.parts.Mob;
import xmas.parts.MobElfe;
import xmas.parts.MobGnom;
import xmas.parts.MobRentier;
import xmas.parts.Position;
import xmas.parts.Spielfeld;
import xmas.parts.Tower;
import xmas.parts.TowerKugel;
import xmas.parts.TowerLametta;
import xmas.parts.TowerNuss;

public class Controller {

	private Spielfeld spielfeld;
	private String StartMessage = "Willkommen bei Xmas Tower Defence !";
	private Tower[] towerArray = new Tower[8];
	private int numberTower = 0;
	private Mob mobArray[] = new Mob[42];
	private int numberMob = 0;
	
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
		
		StringBuffer done = new StringBuffer(); 
		done.append("Tower wurde erstellt ! \nNächsten Tower positionieren ...\n");
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
		
		towerArray[numberTower++] = tower;
		
		spielfeld.towerSetzen(tower);
		done.append(spielfeld.toString());
		
		return done.toString();
		
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

	public boolean startGame() {
		createMob();
		// TODO mob.laufe();
			// TODO update Spielfeld
			// TODO Pruefe leben spieler falls Mob kamin ereicht
		// TODO tower.schießen();
			// TODO berechen Leben mob neu und entferne enventuell
		// TODO warte timer.wait();
		// TODO so lang bis mobArray voll
		// TODO Wheinachtmann Mob
		// TODO Gewonnen verlorren
		return false;
	}

	private void createMob() {
		int mobType = 0; // Randomzahl für Mobart
		Mob mob = null;
		// TODO MICHI !!! Randomfunktion für mobType
		switch(mobType) {
			case 0:
				mob = new MobElfe();
				break;
			case 1:
				mob = new MobGnom();
				break;
			case 2:
				mob = new MobRentier();
				break;
		}
		
	}
	

}
