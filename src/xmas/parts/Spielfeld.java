package xmas.parts;

import java.util.Scanner;

public class Spielfeld {
	
	
	private int laengeY = 8;
	private int breiteX = 8;
	private String[][] fieldArray = new String[laengeY][breiteX];
	private int wayArray[] = new int[(laengeY*breiteX)];
	private int wayCounter = 0;
	// wayArray inputs
		// 8 == oben
		// 4 == links
		// 2 == unten
		// 6 == rechts
		
	
	private int startX = 2;
	private int startY = 1;
	private int endX = 2;
	private int endY = laengeY-1;
	private String empty = "..";
	private String border = "##";
	Scanner scanner = new Scanner(System.in);
	
	private boolean[][] visitField = new boolean[laengeY][breiteX];
	
	private void clearArrays() {
		// visitField set all false
		for(int i = 2; i < (laengeY-1); i++) {
			for(int j = 2; j < (breiteX-1); j++) {
				visitField[i][j] = false;
			}
		}
		// wayArray counter reset 
			wayCounter = 0;
		
	}
	
	
	public Spielfeld() {
		init();
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
	
	public int[] getWayArray() {
		return this.wayArray;
	}
	
	public int getWayCount() {
		return this.wayCounter;
	}
	
	public String getEmpty() {
		return empty;
	}
	
	
	public boolean setTower(String symbol, int y, int x) {
		clearArrays();
		fieldArray[y][x] = symbol;
		if (checkWay(startY, startX) == false) {
			fieldArray[y][x] = empty;
			return false;
		} else {
			for(int i = 0; i<= wayCounter; i++ ){
				System.out.print(wayArray[i] + ", ");
			}
			
			return true;
		}
		
	}
	
	public void setMob(String symbol, int y, int x) {
		fieldArray[y][x] = symbol;
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

		
			if(reachEnd(y, x) == true) {
				System.out.println("Ende ereicht");
				wayArray[wayCounter++] = 0;
				return true;
			} else { 
				// Nach unten laufen ?
				if(fieldArray[(y+1)][x] == empty && visitField[(y+1)][x] == false) {
					//System.out.println("Unten ");
					visitField[(y+1)][x] = true;
					wayArray[wayCounter++] = 2;
					return checkWay(++y, x); 
				}
				
				// Nach links laufen ?
				if(fieldArray[y][(x-1)] == empty && visitField[y][(x-1)] == false) {
					//System.out.println("Links ");
					visitField[y][(x-1)] = true;
					wayArray[wayCounter++] = 4;
					return checkWay(y, --x);	
				}
				
				// Nach rechts laufen ?
				if(fieldArray[y][(x+1)] == empty && visitField[y][(x+1)] == false) {
					//System.out.println("Rechts ");
					visitField[y][(x+1)] = true;
					wayArray[wayCounter++] = 6;
					return checkWay(y, ++x);	
				}
				
				// Nach oben laufen ?
				if(fieldArray[(y-1)][x] == empty && visitField[(y-1)][x] == false) {
					//System.out.println("Oben ");
					visitField[(y-1)][x] = true;
					wayArray[wayCounter++] = 8;
					return checkWay(--y, x);
				}
				System.out.println("Out ");
				ausgabe(y,x);
				return false;
			}
	}
	
	
	
	private void ausgabe(int y, int x) {
		System.out.println("x = " + x);
		System.out.println("y = " + y + "\n");
	}
	

	private boolean reachEnd(int y, int x) {
		//System.out.println(fieldArray[y][x]);
		if(fieldArray[y+1][x] == "En" || fieldArray[y-1][x] == "En" || 
				fieldArray[y][x+1] == "En" || fieldArray[y][x-1] == "En") {
			return true;
		}
		return false;
	}

}
