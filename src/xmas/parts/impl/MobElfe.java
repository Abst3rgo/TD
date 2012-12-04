package xmas.parts.impl;

public class MobElfe extends Mob {

	private String art;
	private int health;
	private double speed;
	private String symbol;
	
	
	public MobElfe(int y, int x) {
		super(y,x);
		this.art = "Elfe";
		this.health = 15;
		this.speed = 1.5;
		this.symbol = "**";
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
	
	public int setHealth(int health) {
		this.health = health;
		return this.health;
	}
	

}
