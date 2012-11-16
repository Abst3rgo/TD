package xmas.parts;

public class TowerLametta extends Tower {

	private int damage;
	private int range;
	private String symbol;
	
	public TowerLametta( int reihe , int stelle ) {
		
		super(reihe, stelle);
		this.damage = 30;
		this.range = 10;
		this.symbol = " L";
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
