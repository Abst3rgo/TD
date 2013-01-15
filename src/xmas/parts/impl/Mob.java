package xmas.parts.impl;

import org.apache.log4j.Logger;

public class Mob {


	private int x;
	private int y;
	private int oldX = 0;
	private int oldY = 0;
	private boolean[][] visitField;
	
	private Logger logger = Logger.getLogger("xmas.parts.impl.Mob");

	
	public Mob(int y, int x) {
		this.x = x;
		this.y = y;
		// dynamisch
		visitField = new boolean[24][24];
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getOldX() {
		return this.oldX;
	}
	
	public int getOldY() {
		return this.oldY;
	}
	
	public String getArt() {
		return null;
	}
	
	public String getSymbol() {
		return null;
	}
	
	public int getHealth() {
		return 0;
	}
	
	public boolean mobHit(int tY, int tX) {
		if(this.y == tY && this.x == tX) {
			return true;
		}
		return false;
	}
	
	
	public void setHealth(int health) {
		
	}

	public boolean walk(String[][] fieldArray, String empty) {
		
		if(zielEreicht(fieldArray)) {
			return true;
		}
		
		// Nach unten laufen ?
		 else if(fieldArray[(y+1)][x] == empty && !visitField[(y+1)][x]) {
			 visitField[(y+1)][x] = true;
			 oldY = y;
			 oldX = x;
			 ++y;
			return false; 
		}
		
		// Nach links laufen ?
		else if(fieldArray[y][(x-1)] == empty && !visitField[(y)][x-1]) {
			visitField[(y)][x-1] = true;
			oldY = y;
			oldX = x;
			x--;
			return false;			
		}
					
		// Nach rechts laufen ?
		else if(fieldArray[y][(x+1)] == empty && !visitField[(y)][x+1]) {
			visitField[(y)][x+1] = true;
			oldY = y;
			oldX = x;
			x++;
			return false;	
		}
					
		// Nach oben laufen ?
		else if(fieldArray[y-1][(x)] == empty) {
			visitField[(y-1)][x] = true;
			oldY = y;
			oldX = x;
			y--;
			return false;
		}	
		// unötig da Mob IMMER laufen kann
		else {
			// TODO FEHLER NACH DEM MOBS LANGE GELAUFEN SIND ???????????
			logger.error("\n FEHLER !!!!!!!!!!!!!!!!!!");
			return true;
		}
		
	}

	public boolean zielEreicht(String[][] fieldArray) {
		if(fieldArray[y+1][x].equals("En") || fieldArray[y-1][x].equals("En") || 
				fieldArray[y][x+1].equals("En") || fieldArray[y][x-1].equals("En")) {
			// Ende ereicht
			return true;
		}
		return false;
	}

	public double getSpeed() {
		return 0;
	}
	
} // End Class
