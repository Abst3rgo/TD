package xmas.parts;

public class TowerKugel extends Tower {
	
	private int damage;
	private int range;
	private String symbol;
	
	public TowerKugel( int y , int x ) {
		
		super(y, x);
		this.damage = 20;
		this.range = 15;
		this.symbol = "C";
	}
	
	public int getRange() {
		return range;
	}
	
	public int getDamage() {
		return damage; //+ rand(10); Um Variablen Damage zu erzeugen
	}

	public String getSymbol() {
		return this.symbol;
	}

}
