package xmas.controller;

import java.util.Random;

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
	private int anzahlMobs = 5;
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
		
		// Delay für Mobspwan
		try {
		    Thread.currentThread();
			Thread.sleep(1000);
		} catch(Exception e){}
		
		// TODO Überarbeiten
		// Mob erstellen und laufen lassen 
			//if(mobNummer < anzahlMobs-1) {
				createMob();
			//}
			//else if (mobNummer == anzahlMobs-1) {
				// Welle komplett Endgegner spawn
			//	boss();
			//}
		
		for(Mob mob : mobArray) {
			if(mob != null) {
				System.out.println(mob.getSymbol());
				if(mob.walk(spielfeld.getfieldArray(), spielfeld.getEmpty())) {
					System.out.println("mobWalk == true");
					player.loseLive();
					spielfeld.setFieldEmpty(mob.getY(), mob.getX());
				} else {
					//spielfeld.updateMob(mob.getSymbol(), mob.getY(), mob.getX(), mob.getOldY(), mob.getOldX());
					spielfeld.updateMob(mob.getSymbol(), mob.getY(), mob.getX(), mob.getOldY(), mob.getOldX());
				}
			}
		}
		System.out.println(spielfeld.tostring());
			// Leben Spieler prüfen
			if(player.gameover() == true) {
				return true;
			}
		// TODO tower.schießen();
			// TODO berechen Leben mob neu und entferne enventuell
		// TODO warte timer.wait();
		
		return false;
	}


	private void createMob() {
		
		Mob mob = null;
		int mobType = new Random().nextInt(11); // Randomzahl für Mobart
		switch(mobType) {
			case 0:
			case 1:
			case 2:
			case 3:
				mob = new MobElfe(spielfeld.getStartY(), spielfeld.getStartX());
				mobArray[mobNummer++] = mob;
				break;
			case 4:
			case 5:
			case 6:
				mob = new MobGnom(spielfeld.getStartY(), spielfeld.getStartX());
				mobArray[mobNummer++] = mob;
				break;
			case 7:
			case 8:
				mob = new MobRentier(spielfeld.getStartY(), spielfeld.getStartX());
				mobArray[mobNummer++] = mob;
				break;
		}
	}
	
	private void boss() {
		Mob mob = new MobWeihnachtsmann(spielfeld.getStartY(), spielfeld.getStartX());
		mobArray[mobNummer++] = mob;
	}
	

	

}
