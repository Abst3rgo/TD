package xmas.parts.impl;

public class MobRentier extends Mob {

	private String art;
	private int health = 30;
	private double speed;
	private String symbol;
	
	
	public MobRentier(int y, int x) {
		super(y,x);
		this.art = "Rentier";
		this.speed = 1.5;
		this.symbol = "mt";
		
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
	
	public void setHealth(int health) {
		this.health = health;
	}
	
}
