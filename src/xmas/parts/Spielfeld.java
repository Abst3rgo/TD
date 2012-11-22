package xmas.parts;

public class Spielfeld {
	
	/* Bedeutung Zahlen:
		-1 = Rand:
		0 = Leeres Feld;
		1 = Tower Nuss
		2 = Tower Lameta
		3 = Tower Kugeln
		5 = Mob Elfe;
		6 = Mob Gnom;
		7 = Mob Rentier;
		8 = Start;
		9 = Ende;
	*/
	
	private int y = 20;
	private int x = 25;
	private String fieldArray[][] = new String[y][x];
	private int startX = 2;
	private int startY = 1;
	private int endX = 2;
	private int endY = y-1;

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
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	
	public void setTower(String symbol, int y, int x) {
		fieldArray[x][y] = symbol;
	}
	
	public void setMob(String symbol, int y, int x) {
		fieldArray[x][y] = symbol;
	}
	
	public String tostring() {
		StringBuilder field = new StringBuilder();
		
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
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
		for(int i = 2; i < (y-1); i++) {
			for(int j = 2; j < (x-1); j++) {
				fieldArray[i][j] = ".";
			}
		}
		// Zahlenrand setzen
		
		// Ober Zahlenrand
		for(int i = 0; i < x; i++) {
			fieldArray[0][i] = Integer.toString(i);
		}
		// Seitlicher Zahlenrand
		for(int i = 0; i < y; i++) {
			fieldArray[i][0] = Integer.toString(i);
		}
		
		// Ränder für Spielfeld felder setzen 
		//ObererRand
		for(int i = 1; i < x; i++) {
			fieldArray[1][i] = "#";
		}
		//UntererRand
		for(int i = 1; i < x; i++) {
			fieldArray[(y-1)][i] = "#";
		}
		//LinkerRand
		for(int i = 1; i < y; i++) {
			fieldArray[i][1] = "#";
		}
		//RechterRand
		for(int i = 1; i < y; i++) {
			fieldArray[i][(x-1)] = "#";
		}
		// Start und Ende setzen 
		fieldArray[startY][startX] = "S";
		fieldArray[endY][endX] = "E";
		// TODO Randomässig nicht besetzbare Blöcke erstellen
		
	}

}
