package xmas.parts.impl;

public class Tower {

	private int y;
	private int x;
	 
	
	public Tower( int y , int x ) {
		this.x = x;
		this.y = y;
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
	
	public int getRange() {
		return 1;
	}
	
	
	
	
	
}
