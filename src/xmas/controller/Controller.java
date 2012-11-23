package xmas.controller;

import java.util.Scanner;

import xmas.parts.Mob;
import xmas.parts.MobElfe;
import xmas.parts.MobGnom;
import xmas.parts.MobRentier;
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
	private Mob[] mobArray = new Mob[30];
	private int mobNummer = 0;
	private String fieldArray[][];
	Scanner scanner = new Scanner(System.in);
	
	public Controller() {
		this.spielfeld  = new Spielfeld();
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
		spielfeld.setTower(tower.getSymbol(), y, x);
		boolean temp = checkWay(spielfeld.getfieldArray(), spielfeld.getStartY(), spielfeld.getStartX());
		System.out.println(temp);
		if( temp == true ) {
			towerArray[numberTower++] = tower;
			System.out.println("STOP !!! ");
			return true;
		} 
		spielfeld.setTower("..", y, x);
		return false;
	}

	// Rekursive Mehtode die Prüft ob der Weg frei ist 
	private boolean checkWay(String[][] fieldArray, int y, int x) {

		
			// Nach unten laufen ?
			if(fieldArray[(y+1)][x] == "..") {
				System.out.println("Unten ");
				System.out.println("x = " + x);
				System.out.println("y = " + y+ "\n");
				if(true == reachEnd(fieldArray, y, x)) {
					return true;
				}
				checkWay(fieldArray, ++y, x); 
			}
			// Nach links laufen ?
			else if(fieldArray[y][(x-1)] == "..") {
				System.out.println("Links ");
				System.out.println("x = " + x);
				System.out.println("y = " + y+ "\n");
				if(true == reachEnd(fieldArray, y, x)) {
					return true;
				}
				checkWay(fieldArray, y, --x);	
			}
			// Nach rechts laufen ?
			else if(fieldArray[y][(x+1)] == "..") {
				System.out.println("Rechts ");
				System.out.println("x = " + x);
				System.out.println("y = " + y+ "\n");
				if(true == reachEnd(fieldArray, y, x)) {
					return true;
				}
				checkWay(fieldArray, y, ++x);	
			}
			// Nach oben laufen ?
			else if(fieldArray[(y-1)][x] == ".." ) {
				System.out.println("Oben ");
				System.out.println("x = " + x);
				System.out.println("y = " + y + "\n");
				if(true == reachEnd(fieldArray, y, x)) {
					return true;
				}
				checkWay(fieldArray, --y, x);
			}
	
				System.out.println("Out ");
				System.out.println("x = " + x);
				System.out.println("y = " + y + "\n");
				return false;
	}

	private boolean reachEnd(String[][] fieldArray, int y, int x) {
		if(fieldArray[(y+1)][x] == "En" || fieldArray[(y-1)][x] == "En" ||
		   fieldArray[(y)][x+1] == "En" || fieldArray[(y)][x-1] == "En" ) {
			return true;
		}
		return false;
	}

	public boolean startGame() {
		createMob();
		// TODO mob.laufe();
		for(Mob mob : mobArray) {
			mob.walk(spielfeld);
		}
			// TODO update Spielfeld
			// TODO Pruefe leben spieler falls Mob kamin ereicht
		// TODO tower.schießen();
			// TODO berechen Leben mob neu und entferne enventuell
		// TODO warte timer.wait();
		// TODO so lang bis mobArray voll
		// TODO Wheinachtmann Mob
		// TODO Gewonnen verlorren
		System.out.println(spielfeld.toString());
		return false;
	}


	private void createMob() {
		
		Mob mob = null;
		int mobType = 0; // Randomzahl für Mobart
		// TODO MICHI !!! Randomfunktion für mobType
		
		switch(mobType) {
			case 0:
				mob = new MobElfe();
				mobArray[mobNummer++] = mob;
				break;
			case 1:
				mob = new MobGnom();
				mobArray[mobNummer++] = mob;
				break;
			case 2:
				mob = new MobRentier();
				mobArray[mobNummer++] = mob;
				break;
		}
		//spielfeld.placeMob(mob);
	}
	

	

}
