package xmas.controller.impl;

import java.util.Random;

import xmas.controller.IController;
import xmas.parts.impl.Mob;
import xmas.parts.impl.MobElfe;
import xmas.parts.impl.MobGnom;
import xmas.parts.impl.MobRentier;
import xmas.parts.impl.MobWeihnachtsmann;
import xmas.parts.impl.Player;
import xmas.parts.impl.Spielfeld;
import xmas.parts.ISpielfeld;
import xmas.parts.impl.Tower;
import xmas.parts.impl.TowerKugel;
import xmas.parts.impl.TowerLametta;
import xmas.parts.impl.TowerNuss;

public class Controller implements IController {

	private Player player;
	private ISpielfeld spielfeld;
	private String StartMessage = "Willkommen bei Xmas Tower Defence !";
	private Tower[] towerArray = new Tower[64];
	private int numberTower = 0;
	private int anzahlMobs = 30;
	private Mob[] mobArray = new Mob[anzahlMobs];
	private int mobNummer = 0;
	
	
	// TODO Variabeln für Test 
	int mobnummer = 0;
	int towernummer = 0;
	int durchgang;
	
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
			tower = new TowerNuss(y, x);
			break;
		// Lametta
		case 1:
			tower = new TowerLametta(y, x);
			break;
		// Kugeln
		case 2:
			tower = new TowerKugel(y, x);
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
		
		// Delay for Mobspawn
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
				if(mob.walk(spielfeld.getfieldArray(), spielfeld.getEmpty())) {
					player.loseLive();
					spielfeld.setFieldEmpty(mob.getY(), mob.getX());
				} else {
					spielfeld.updateMob(mob.getSymbol(), mob.getY(), mob.getX(), mob.getOldY(), mob.getOldX());
				}
			}
		}
		// Leben Spieler prüfen
		if(player.gameover() == true) {
			return true;
		}
		
		// Gehe jeden Tower durch der schießen kann
		towernummer = 0;
		mobnummer = 0;
		for(Tower tower : towerArray) {
			if(tower != null) {
				// TODO Fehlerüberprüfung per print
				towernummer++;
				System.out.println("Gewälter Tower " + towernummer + " = " + tower.getSymbol());
				// Gehe jeden Mob durch ob er von dem speziellen Tower getroffen werden kann
				for(Mob mob : mobArray) {
					if(mob != null) {
						// TODO Fehlerüberprüfung per print
						System.out.println("Gewälter mob " + mobnummer + " = " + mob.getSymbol());
						
						
						
						// Oberes Feld
						int tY = tower.getY();
						int tX = tower.getX();
						
						tY -= tower.getRange();
						System.out.println("Y = " + tY);
						System.out.println("X = " + tX);
						mobonFlild(mob, tower, tY, tX);
						System.out.println("---------------------------------");
						
						durchgang = 2;
						for(int i = 0; i < tower.getRange(); i++) {
							if(i==0) { // erster durchlauf
								tY++;
								tX++;
							} else {
								tY++;
								tX = tX + durchgang;
							}
							for(int j = 0; j <= durchgang; j++) {
								System.out.println("Y = " + tY);
								System.out.println("X = " + tX);
								mobonFlild(mob, tower, tY, tX);
								System.out.println("---------------------------------");
								tX--;
							}
							durchgang += 2;
						}
						
						
						// Prüfe unteres Feld
						
						tY = tower.getY();
						tX = tower.getX();
						
						tY += tower.getRange(); 
						System.out.println("Y = " + tY);
						System.out.println("X = " + tX);
						mobonFlild(mob, tower, tY, tX);
						System.out.println("---------------------------------");

						durchgang = 2;
						for(int i = 0; i < (tower.getRange()-1); i++) {
							if(i==0) { // erster durchlauf
								tY--;
								tX--;
							} else {
								tY--;
								tX = tX - durchgang;
							}
							for(int j = 0; j <= durchgang; j++) {
								System.out.println("Y = " + tY);
								System.out.println("X = " + tX);
								mobonFlild(mob, tower, tY, tX);
								System.out.println("---------------------------------");
								tX++;
							}
							durchgang += 2;
						}
						// Mob null setzen 
						if(mob.getHealth() <= 0) {
							System.out.println(mobnummer + "ter Mob " + mob.getSymbol() + "Tod !!!!!");
							spielfeld.setFieldEmpty(mob.getY(), mob.getX());
							mobArray[mobnummer] = null;
						}
					}
					mobnummer++;
				}
			}
		}
		for(int i = 0; i < 10; i++) {
			System.out.print(mobArray[i]+", ");
		}
		return false;
	}


	private void mobonFlild(Mob mob, Tower tower, int tY, int tX) {
		if(mob.mobHit(tY, tX)) {
			System.out.println(mobnummer + "ter Mob " + mob.getSymbol() + "Getroffen !!");
			System.out.println("Leben vor dem Treffer = " + mob.getHealth());
			mob.setHealth((mob.getHealth() - tower.getDamage()));
			System.out.println("Leben nach dem Treffer = " + mob.getHealth());
		}
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
