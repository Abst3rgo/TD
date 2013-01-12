package xmas.parts.impl;

import java.util.Arrays;
import java.util.Random;

import xmas.parts.IGameHandler;
import xmas.parts.IPlayer;
import xmas.parts.ISpielfeld;


public class GameHandler implements IGameHandler {
	
	private ISpielfeld spielfeld;
	private IPlayer player;
	
	private int anzahlMobs = 2;
	private Mob[] mobArray;
	private int mobNummer = 0;
	private int indexMob = 0;
	
	private Tower[] towerArray;
	private int numberTower = 0;
	
	private static final int delayTimeMS = 1000;
	
	
	
	//-----------------------------Constructor-------------------------------------
	
	
	public GameHandler(ISpielfeld spielfeld, IPlayer player) {
		mobArray = new Mob[anzahlMobs];
		this.spielfeld = spielfeld;
		this.player = player;
		towerArray = new Tower[(spielfeld.getY()-3)*(spielfeld.getX()-3)];
	}
	
	//------------------------------------Get/Set/... -------------------------------
	
	public void clearArrays() {
		Arrays.fill(mobArray,null);
		Arrays.fill(towerArray,null);
		
	}
	
	
	//---------------------------------- SpielMethoden --------------------------------
	
	public void delay() {
		
		// Delay for Mobspawn
				try {
				    Thread.currentThread();
					Thread.sleep(delayTimeMS);
				} catch(Exception e){}
		
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
		
		// Pruefe ob Weg noch fei für Mobs
		if(spielfeld.setTower(tower.getSymbol(), y, x)) {
			towerArray[numberTower++] = tower;
			return true;
		} else {
			return false;
		}
	}
	
	
	
	public boolean waveOver() {
		if(mobNummer == anzahlMobs && mobArray[anzahlMobs-1] == null) {
			mobNummer = 0;
			// MobAnzahl verdoppelt sich
			// TODO Funktion die Mobs um einen gewissen Faktor erhöht 
			anzahlMobs *= 2;
			mobArray = new Mob[anzahlMobs];
			// TODO Mobs werden stärker
			return true;
		}
		return false;
	}
	
	
	
	public void createMob() {
		
		// Mob erstellen und laufen lassen 
		if(mobNummer < anzahlMobs-1) {
			
			
			// Randomzahl für Mobart
			int mobType = new Random().nextInt(11);
			
			createSpezMob(mobType);
			
		}
		else if (mobNummer == anzahlMobs-1) {
		// Welle komplett Endgegner spawn
			Mob mob = new MobWeihnachtsmann(spielfeld.getStartY(), spielfeld.getStartX());
			mobArray[mobNummer++] = mob;		
		}
	}
	
	public void createSpezMob(int mobType) {
		
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
	public void mobwalk() {
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


	public String towershot() {
		
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
	public void mobonField(Mob mob, Tower tower, int tY, int tX, StringBuffer s) {
		if(mob.mobHit(tY, tX)) {
			s.append("Mob " + mob.getSymbol() + "Getroffen !!" + "\n")
			.append("Leben vor dem Treffer = " + mob.getHealth() + "\n");
			mob.setHealth((mob.getHealth() - tower.getDamage()));
			s.append("Leben nach dem Treffer = " + mob.getHealth() + "\n");
		}
	}


}
