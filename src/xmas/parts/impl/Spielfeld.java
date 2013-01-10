package xmas.parts.impl;


import com.google.inject.Inject;

import xmas.parts.ISpielfeld;

public class Spielfeld implements ISpielfeld {
	
	
	private int laengeY;
	private int breiteX;
	private String[][] fieldArray;
	
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private String empty = "..";
	private String border = "##";
	
	private boolean[][] visitField;
	
	@Inject
	public Spielfeld(String groese) {
		
		if(groese.equals("3")) {
			this.laengeY = 24;
			this.breiteX = 24;
		}
		else if (groese.equals("2")) {
			this.laengeY = 10;
			this.breiteX = 10;
		}
		else {
			this.laengeY = 8;
			this.breiteX = 8;
			
		}
		// Init Felder
		fieldArray = new String[laengeY][breiteX];
		startX = 2;
		startY = 1;
		endX = 2;
		endY = laengeY-1;
		visitField = new boolean[laengeY][breiteX];
		
		// Spielfeld Init ! 
		init();
		setBorder();
	}
	
	private void clearArrays() {
		// visitField set all false
		for(int i = 2; i < (laengeY-1); i++) {
			for(int j = 2; j < (breiteX-1); j++) {
				visitField[i][j] = false;
			}
		}
	}
	
	public int getStartX() {
		return startX;
	}
	
	public int getStartY() {
		return startY;
	}
	
	public int getEndY() {
		return endY;
	}
	
	public int getEndX() {
		return endX;
	}
	
	public int getX() {
		return this.breiteX;
	}
	
	public int getY() {
		return this.laengeY;
	}
	
	public String[][] getfieldArray() {
		return this.fieldArray;
	}
	
	public boolean[][] getVisitField() {
		return this.visitField;
	}
	
	public String getEmpty() {
		return empty;
	}
	
	public void setFieldEmpty(int y, int x) {
		fieldArray[y][x] = empty;
	}
	
	
	public boolean setTower(String symbol, int y, int x) {
		clearArrays();
		fieldArray[y][x] = symbol;
		if (!checkWay(startY, startX)) {
			fieldArray[y][x] = empty;
			return false;
		} else {
			return true;
		}
		
	}
	
	public void setMob(String symbol, int y, int x) {
		fieldArray[y][x] = symbol;
	}
	
	public void updateMob(String symbol, int y, int x, int oldY, int oldX) {
		fieldArray[y][x] = symbol;
		fieldArray[oldY][oldX] = empty;
	}
	
	public String tostring() {
		StringBuilder field = new StringBuilder();
		
		for(int i = 0; i < laengeY; i++) {
			for(int j = 0; j < breiteX; j++) {
				field.append(fieldArray[i][j]);
				field.append(" ");
			}
			field.append("\n");
		}
		
		field.append("\n");
		
		return field.toString();
	}
	
	
	
	private void init() {
		
		// Feld init
		for(int i = 2; i < (laengeY-1); i++) {
			for(int j = 2; j < (breiteX-1); j++) {
				fieldArray[i][j] = empty;
			}
		}
		// Zahlenrand setzen
		
		// Ober Zahlenrand
		for(int i = 0; i < breiteX; i++) {
			if (i <= 9) {
			fieldArray[0][i] = Integer.toString(i)+" ";
			} else {
				fieldArray[0][i] = Integer.toString(i);
			}
		}
		// Seitlicher Zahlenrand
		for(int i = 0; i < laengeY; i++) {
			if (i <= 9) {
				fieldArray[i][0] = Integer.toString(i)+" ";
			} else {
				fieldArray[i][0] = Integer.toString(i);
			}
		}
	}
	
	private void setBorder() {
		
		// Ränder für Spielfeld felder setzen 
		//ObererRand
		for(int i = 1; i < breiteX; i++) {
			fieldArray[1][i] = border;
		}
		//UntererRand
		for(int i = 1; i < breiteX; i++) {
			fieldArray[(laengeY-1)][i] = border;
		}
		//LinkerRand
		for(int i = 1; i < laengeY; i++) {
			fieldArray[i][1] = border;
		}
		//RechterRand
		for(int i = 1; i < laengeY; i++) {
			fieldArray[i][(breiteX-1)] = border;
		}
		// Start und Ende setzen 
		fieldArray[startY][startX] = "St";
		fieldArray[endY][endX] = "En";
		// TODO Randomässig nicht besetzbare Blöcke erstellen
		
	}
	
	// Rekursive Mehtode die Prüft ob der Weg frei ist 
	private boolean checkWay(int y, int x) {

		
			if(reachEnd(y, x)) {
				return true;
			} else { 
				// Nach unten laufen ?
				if(fieldArray[(y+1)][x] == empty && !visitField[(y+1)][x]) {
					visitField[(y+1)][x] = true;
					int newY = y + 1;
					return checkWay(newY, x); 
				}
				
				// Nach links laufen ?
				else if(fieldArray[y][(x-1)] == empty && !visitField[y][(x-1)]) {
					visitField[y][(x-1)] = true;
					int newX = x - 1;
					return checkWay(y, newX);	
				}
				
				// Nach rechts laufen ?
				else if(fieldArray[y][(x+1)] == empty && !visitField[y][(x+1)]) {
					visitField[y][(x+1)] = true;
					int newX = x + 1;
					return checkWay(y, newX);	
				}
				
				// Nach oben laufen ?
				else if(fieldArray[(y-1)][x] == empty) {
					visitField[(y-1)][x] = true;
					int newY = y - 1;
					return checkWay(newY, x);
				}
				return false;
			}
	}
	

	private boolean reachEnd(int y, int x) {
		if(fieldArray[y+1][x].equals("En") 
				/*|| fieldArray[y-1][x].equals("En") || fieldArray[y][x+1].equals("En") || fieldArray[y][x-1].equals("En")*/
				) {
			return true;
		}
		return false;
	}

}
