package xmas.controller.impl;

import java.util.Arrays;
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
	
	private String message = "";
	
	private Tower[] towerArray;
	private int numberTower = 0;
	private int anzahlMobs = 2;
	private Mob[] mobArray;
	private int mobNummer = 0;
	private int indexMob = 0;
	private static final int delayTimeMS = 1000;
	
	
	//--------------------------Getter und Setter Methoden ------------------------
	
	public Controller() {
		this.player = new Player("Player1");
		mobArray = new Mob[anzahlMobs];
	}
	
	public void setSpielfeld(String groese) {
		this.spielfeld  = new Spielfeld(groese);
		towerArray = new Tower[(spielfeld.getY()-3)*(spielfeld.getX()-3)];
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
	
	
	public void clearArrays() {
		Arrays.fill(mobArray,null);
		Arrays.fill(towerArray,null);
		
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
		default:
			return false;
		}
		
		// Pruefe ob Weg noch fei f�r Mobs
		if(spielfeld.setTower(tower.getSymbol(), y, x)) {
			towerArray[numberTower++] = tower;
			return true;
		} else {
			return false;
		}
	}

	
	// Return: -1 = SpielerTod / 0 = Spiel geht weiter / 1 = Welle vor�ber
	public int startGame() {
		
		
		// Wenn Welle vor�ber ?
		if(waveOver()){
			return 1;
		}
		
		
		// Zeit vertreichen lassen 
		delay();
		
		// Mob erstellen und laufen lassen 
		createMob();
			
		// Mob bewegen sich in Richtung Ende
		mobwalk();
		
		
		// Leben Spieler pr�fen
		if(player.gameover()) {
			return -1;
		}
		
		
		// Gehe jeden Tower durch der schie�en kann
		message = towershot();

		return 0;
	}
	

	//--------------------------Methoden zum erstellen die ausgelagert werden k�nnen ------------------------
	
	
	private void delay() {
		
		// Delay for Mobspawn
				try {
				    Thread.currentThread();
					Thread.sleep(delayTimeMS);
				} catch(Exception e){}
		
	}
	
	
	
	private boolean waveOver() {
		if(mobNummer == anzahlMobs && mobArray[anzahlMobs-1] == null) {
			mobNummer = 0;
			// MobAnzahl verdoppelt sich
			// TODO Funktion die Mobs um einen gewissen Faktor erh�ht 
			anzahlMobs *= 2;
			mobArray = new Mob[anzahlMobs];
			// TODO Mobs werden st�rker
			return true;
		}
		return false;
	}
	
	
	
	private void createMob() {
		
		// Mob erstellen und laufen lassen 
		if(mobNummer < anzahlMobs-1) {
			
			
			// Randomzahl f�r Mobart
			int mobType = new Random().nextInt(11);
			
			createSpezMob(mobType);
			
		}
		else if (mobNummer == anzahlMobs-1) {
		// Welle komplett Endgegner spawn
			Mob mob = new MobWeihnachtsmann(spielfeld.getStartY(), spielfeld.getStartX());
			mobArray[mobNummer++] = mob;		
		}
	}
	
	private void createSpezMob(int mobType) {
		
		Mob mob = null;
		
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

	// TODO In Clean Code umschreiben
	private void mobwalk() {
		indexMob = 0;
		for(Mob mob : mobArray) {
			if(mob != null) {
				if(mob.walk(spielfeld.getfieldArray(), spielfeld.getEmpty())) {
					player.loseLive();
					spielfeld.setFieldEmpty(mob.getY(), mob.getX());
					mobArray[indexMob] = null;
				} else {
					spielfeld.updateMob(mob.getSymbol(), mob.getY(), mob.getX(), mob.getOldY(), mob.getOldX());
				}
			}
			indexMob++;
		}
	}


	private String towershot() {
		
		StringBuffer s = new StringBuffer();
		
		// gehen jeden Tower durch
		for(Tower tower : towerArray) {
			if(tower != null) {
				
				indexMob = 0;
				// Gehe jeden Mob durch und schaue ob er auf Feld liegt.
				for(Mob mob : mobArray) {
					if(mob != null) {
						
						for(int i = 0; i < tower.getTowerRadiusLength(); i++) {
							mobonField(mob, tower, tower.getRangeFieldY()[i] , tower.getRangeFieldX()[i], s );
						}
						
						
						// Mob null setzen 
						if(mob.getHealth() <= 0) {
							s.append(indexMob + "ter Mob " + mob.getSymbol() + "Tod !!!!!" + "\n");
							spielfeld.setFieldEmpty(mob.getY(), mob.getX());
							mobArray[indexMob] = null;
						}
					}
					indexMob++;
				}	
			}
		}
		return s.toString();
	}
			
			

	// TODO In Clean Code umschreiben
	private void mobonField(Mob mob, Tower tower, int tY, int tX, StringBuffer s) {
		if(mob.mobHit(tY, tX)) {
			s.append("Mob " + mob.getSymbol() + "Getroffen !!" + "\n")
			.append("Leben vor dem Treffer = " + mob.getHealth() + "\n");
			mob.setHealth((mob.getHealth() - tower.getDamage()));
			s.append("Leben nach dem Treffer = " + mob.getHealth() + "\n");
		}
	}

	
}
