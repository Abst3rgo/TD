package xmas.parts.impl;

public class Mob {


	private int x;
	private int y;
	private int oldX = 0;
	private int oldY = 0;
	
	public Mob(int y, int x) {
		this.x = x;
		this.y = y;
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

	public boolean walk(String[][] fieldArray, String empty) {

		if(fieldArray[y+1][x] == "En" || fieldArray[y-1][x] == "En" || 
				fieldArray[y][x+1] == "En" || fieldArray[y][x-1] == "En") {
			System.out.println("Im Ziel ");
			// Ende ereicht
			return true;
		}
			// Nach unten laufen ?
		 else if(fieldArray[(y+1)][x] == empty && oldY != (y+1)) {
			//System.out.println("Unten ");
			 oldY = y;
			 oldX = x;
			 ++y;
			return false; 
		}
		// Nach links laufen ?
		else if(fieldArray[y][(x-1)] == empty && oldX != x-1) {
			//System.out.println("Links ");
			oldY = y;
			oldX = x;
			x--;
			return false;			
		}
					
		// Nach rechts laufen ?
		else if(fieldArray[y][(x+1)] == empty && oldX != x+1) {
			//System.out.println("Rechts ");
			oldY = y;
			oldX = x;
			x++;
			return false;	
		}
					
		// Nach oben laufen ?
		else if(fieldArray[y-1][(x)] == empty && oldY != y-1) {
			//System.out.println("Oben ");
			oldY = y;
			oldX = x;
			y--;
			return false;
		}	
		// unötig da Mob IMMER laufen kann
		else {
			System.out.println("FEHLER !!!!!!!!!!!!!!!!!!");
			return true;
		}
		
	}
	
	private void printCode() {
		System.out.println("Y = " + y);
		System.out.println("X = " + x);
		System.out.println("OldY = " + oldY);
		System.out.println("OldX = " + oldX);
	}
	
	
} // End Class
