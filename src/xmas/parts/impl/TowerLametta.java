package xmas.parts.impl;

public class TowerLametta extends Tower {

	private int damage;
	private int range;
	private String symbol;
	
	public TowerLametta( int y , int x ) {
		
		super(y, x);
		this.damage = 10;
		this.range = 5;
		this.symbol = "L|";
	}
	
	public int getRange() {
		return range;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
}
