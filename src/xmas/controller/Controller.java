package xmas.controller;

import xmas.parts.Mob;
import xmas.parts.MobElfe;
import xmas.parts.MobGnom;
import xmas.parts.MobRentier;
import xmas.parts.MobWeihnachtsmann;
import xmas.parts.Player;
import xmas.parts.Spielfeld;
import xmas.parts.Tower;
import xmas.parts.TowerKugel;
import xmas.parts.TowerLametta;
import xmas.parts.TowerNuss;

public class Controller {

	private Player player;
	private Spielfeld spielfeld;
	private String StartMessage = "Willkommen bei Xmas Tower Defence !";
	private Tower[] towerArray = new Tower[8];
	private int numberTower = 0;
	private int anzahlMobs = 30;
	private Mob[] mobArray = new Mob[anzahlMobs];
	private int mobNummer = 0;
	
	
	public Controller() {
		this.spielfeld  = new Spielfeld();
		this.player = new Player("Player1");
		
	}
	
	public int getSpielfeldX() {
		return spielfeld.getX();
	}
	
	public int getSpielfeldY() {
		return spielfeld.getY();
	}
	
	// return StartMessage
	public String getStartMessage() {
		return StartMessage;
	}
	
	// holt Spielfeld und returnd es
	public String getSpielfeld() {
		return spielfeld.tostring();
	}
	
	
	public boolean erstelleTower(int art, int x, int y) {
		
		// Art der Towers ermitteln und erstellen
		Tower tower = null;
		switch (art) {
		// Kokusnuss
		case 0:
			tower = new TowerNuss(x, y);
			break;
		// Lametta
		case 1:
			tower = new TowerLametta(x, y);
			break;
		// Kugeln
		case 2:
			tower = new TowerKugel(x, y);
			break;
		}
		
		// Pruefe ob Weg noch fei für Mobs
		if(spielfeld.setTower(tower.getSymbol(), y, x) == true) {
			towerArray[numberTower++] = tower;
			System.out.println("Tower Set ");
			return true;
		} else {
			return false;
		}
	}

	public boolean startGame() {
		
		// Mob erstellen und laufen lassen 
		if (mobArray.length != anzahlMobs-1) {
			createMob();
		} else {
			// Welle komplett Endgegner spawn
			boss();
		}
		for(Mob mob : mobArray) {
			if(mob != null) {
				if(!mob.walk(spielfeld.getWayArray(), spielfeld.getWayCount())) {
					spielfeld.setMob(mob.getSymbol(), mob.getY(), mob.getX());
				} else {
					player.loseLive();
					spielfeld.setMob(spielfeld.getEmpty(), mob.getY(), mob.getX());
					mob = null;
				}
			}
			// Leben Spieler prüfen
			if(player.gameover() == true) {
				return true;
			}
			
			
		}
		// TODO tower.schießen();
			// TODO berechen Leben mob neu und entferne enventuell
		// TODO warte timer.wait();
		
		return false;
	}


	private void createMob() {
		
		Mob mob = null;
		int mobType = 0; // Randomzahl für Mobart
		// TODO MICHI !!! Randomfunktion für mobType
		
		switch(mobType) {
			case 0:
				mob = new MobElfe(spielfeld.getStartY()+1, spielfeld.getStartX());
				mobArray[mobNummer++] = mob;
				break;
			case 1:
				mob = new MobGnom(spielfeld.getStartY()+1, spielfeld.getStartX());
				mobArray[mobNummer++] = mob;
				break;
			case 2:
				mob = new MobRentier(spielfeld.getStartY()+1, spielfeld.getStartX());
				mobArray[mobNummer++] = mob;
				break;
		}
		//spielfeld.placeMob(mob);
	}
	
	private void boss() {
		Mob mob = new MobWeihnachtsmann(spielfeld.getStartY()+1, spielfeld.getStartX());
		mobArray[mobNummer++] = mob;
	}
	

	

}
