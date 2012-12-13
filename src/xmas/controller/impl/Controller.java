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
	private int anzahlMobs = 2;
	private Mob[] mobArray;
	private int mobNummer = 0;
	int indexMob = 0;
	
	//--------------------------Getter und Setter Methoden ------------------------
	
	public Controller() {
		this.player = new Player("Player1");
		mobArray = new Mob[anzahlMobs];
	}
	
	public void setSpielfeld(String groese) {
		this.spielfeld  = new Spielfeld(groese);
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

	
	// Return: -1 = SpielerTod / 0 = Spiel geht weiter / 1 = Welle vorüber
	public int startGame() {
		
		
		// Wenn Welle vorüber ?
		if(waveOver()){
			return 1;
		}
		
		
		// Zeit vertreichen lassen 
		delay();
		
		// Mob erstellen und laufen lassen 
		createMob();
			
		// Mob bewegen sich in Richtung Ende
		mobwalk();
		
		
		// Leben Spieler prüfen
		if(player.gameover() == true) {
			return -1;
		}
		
		
		// Gehe jeden Tower durch der schießen kann
		towershot();
		
		// Test Ausgabe zum Überprüfen
		for(int i = 0; i < anzahlMobs; i++) {
			System.out.print(mobArray[i]+", ");
		}
		System.out.print("\n");
		
		return 0;
	}
	

	//--------------------------Methoden zum erstellen die ausgelagert werden können ------------------------
	
	
	private void delay() {
		
		// Delay for Mobspawn
				try {
				    Thread.currentThread();
					Thread.sleep(1000);
				} catch(Exception e){}
		
	}
	
	
	
	private boolean waveOver() {
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
	
	
	
	private void createMob() {
		
		// Mob erstellen und laufen lassen 
		if(mobNummer < anzahlMobs-1) {
			
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
		else if (mobNummer == anzahlMobs-1) {
		// Welle komplett Endgegner spawn
			Mob mob = new MobWeihnachtsmann(spielfeld.getStartY(), spielfeld.getStartX());
			mobArray[mobNummer++] = mob;		
		}
	}
	
	
	// TODO In Clean Code umschreiben
	private void mobwalk() {
		indexMob = 0;
		for(Mob mob : mobArray) {
			if(mob != null) {
				if(mob.walk(spielfeld.getfieldArray(), spielfeld.getEmpty())) {
					System.out.print("ist Mob " + mob.getSymbol() + "\n");
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


	private void towershot() {
		
		// gehen jeden Tower durch
		for(Tower tower : towerArray) {
			if(tower != null) {
				
				indexMob = 0;
				// Gehe jeden Mob durch und schaue ob er auf Feld liegt.
				for(Mob mob : mobArray) {
					if(mob != null) {
						
						for(int i = 0; i < tower.getTowerRadiusLength(); i++) {
							mobonField(mob, tower, tower.getRangeFieldY()[i] , tower.getRangeFieldX()[i] );
						}
						
						
						// Mob null setzen 
						if(mob.getHealth() <= 0) {
							System.out.println(indexMob + "ter Mob " + mob.getSymbol() + "Tod !!!!!");
							spielfeld.setFieldEmpty(mob.getY(), mob.getX());
							mobArray[indexMob] = null;
						}
					}
					indexMob++;
				}	
			}
		}
	}
			
			

	// TODO In Clean Code umschreiben
	private void mobonField(Mob mob, Tower tower, int tY, int tX) {
		if(mob.mobHit(tY, tX)) {
			System.out.println("Mob " + mob.getSymbol() + "G etroffen !!");
			System.out.println("Leben vor dem Treffer = " + mob.getHealth());
			mob.setHealth((mob.getHealth() - tower.getDamage()));
			System.out.println("Leben nach dem Treffer = " + mob.getHealth());
		}
	}

	
}
