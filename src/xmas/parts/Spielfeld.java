package xmas.parts;

public class Spielfeld {
	
	
	private int laengeY = 8;
	private int breiteX = 8;
	private String[][] fieldArray = new String[laengeY][breiteX];
	
	private int startX = 2;
	private int startY = 1;
	private int endX = 2;
	private int endY = laengeY-1;

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
	
	
	public void setTower(String symbol, int y, int x) {
		fieldArray[x][y] = symbol;
	}
	
	public void setMob(String symbol, int y, int x) {
		fieldArray[x][y] = symbol;
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
				fieldArray[i][j] = "..";
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
		
		// R�nder f�r Spielfeld felder setzen 
		//ObererRand
		for(int i = 1; i < breiteX; i++) {
			fieldArray[1][i] = "##";
		}
		//UntererRand
		for(int i = 1; i < breiteX; i++) {
			fieldArray[(laengeY-1)][i] = "##";
		}
		//LinkerRand
		for(int i = 1; i < laengeY; i++) {
			fieldArray[i][1] = "##";
		}
		//RechterRand
		for(int i = 1; i < laengeY; i++) {
			fieldArray[i][(breiteX-1)] = "##";
		}
		// Start und Ende setzen 
		fieldArray[startY][startX] = "St";
		fieldArray[endY][endX] = "En";
		// TODO Random�ssig nicht besetzbare Bl�cke erstellen
		
	}

}
