package xmas.parts.impl;

public class TowerKugel extends Tower {
	
	private int damage;
	private String symbol;
	private static int range = 1;
	
	public TowerKugel( int y , int x ) {
		super(y, x, range);
		this.damage = 20;
		this.symbol = "C|";

	}
	
	public int getDamage() {
		return damage; //+ rand(10); Um Variablen Damage zu erzeugen
	}

	public String getSymbol() {
		return this.symbol;
	}
	

}
