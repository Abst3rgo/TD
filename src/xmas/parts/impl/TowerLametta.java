package xmas.parts.impl;

public class TowerLametta extends Tower {

	private int damage;
	private String symbol;
	private static int range = 1;
	
	
	public TowerLametta( int y , int x ) {
		
		super(y, x, range);
		this.damage = 10;
		this.symbol = "L|";
	}
	
	public int getDamage() {
		return damage;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
}
