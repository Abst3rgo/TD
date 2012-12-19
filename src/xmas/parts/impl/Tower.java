package xmas.parts.impl;

public class Tower {

	private int y;
	private int x;
	private int range;
	private int towerRadiusY[];
	private int towerRadiusX[];
	private int towerRadiusLength = 1;
	private int number = 0;
	
	public Tower( int y , int x, int range ) {
		this.x = x;
		this.y = y;
		this.range = range;
		createRangeField();
	}
	
	public int getRange() {
		return this.range;
	}

	public int getY() {
		return this.y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public  String getSymbol() {
		return null;
		
	}
	
	public int getDamage() {
		return 0; 
	}
	
	public int getTowerRadiusLength() {
		return towerRadiusLength;
	}
	
	public int[] getRangeFieldY() {
		return towerRadiusY;
		
	}
	
	public int[] getRangeFieldX() {
		return towerRadiusX;
		
	}
	
	private void createRangeField() {
		
		// Lege Feld von Stellen an die der Tower treffen kann
				for(int fak = 1; fak <= range; fak++) {
					towerRadiusLength += fak * 4;
				}
				
				towerRadiusY = new int[towerRadiusLength];
				towerRadiusX = new int[towerRadiusLength];
				
				// Oberes Feld
				int tY = y;
				int tX = x;
				
				tY -= range;
				
				towerRadiusY[number] = tY; 
				towerRadiusX[number] = tX;
				number++;
				
				int durchgang = 2;
				for(int i = 0; i < range; i++) {
					if(i==0) {
						tY++;
						tX++;
					} else {
						tY++;
						tX = tX + durchgang;
					}
					for(int j = 0; j <= durchgang; j++) {
						towerRadiusY[number] = tY; 
						towerRadiusX[number] = tX;
						number++;
						tX--;
					}
					durchgang += 2;
				}
				
				
				// unteres Feld
				tY = y;
				tX = x;
				
				tY += range; 
				towerRadiusY[number] = tY; 
				towerRadiusX[number] = tX;
				number++;

				durchgang = 2;
				for(int i = 0; i < (range-1); i++) {
					if(i==0) {
						tY--;
						tX--;
					} else {
						tY--;
						tX = tX - durchgang;
					}
					for(int j = 0; j <= durchgang; j++) {
						towerRadiusY[number] = tY; 
						towerRadiusX[number] = tX;
						number++;
						tX++;
					}
					durchgang += 2;
				}
				
			}
	

	
}
