package xmas.parts;

public class MobRentier extends Mob {

	private String art;
	private int health;
	private double speed;
	private String symbol;
	
	
	public MobRentier() {
		super();
		this.art = "Rentier";
		this.health = 15;
		this.speed = 1.5;
		this.symbol = "m";
		
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public double getSpeed() {
		return this.speed;
	}
	
	public String getArt() {
		return art;
	}
	
	public String getSymbol() {
		return symbol;
	}
}
