package xmas.parts.impl;

public class MobWeihnachtsmann extends Mob {
	
	private int health;
	private double speed;
	private String symbol;
	
	
	public MobWeihnachtsmann(int y, int x) {
		super(y,x);
		this.health = 100;
		this.speed = 1.0;
		this.symbol = "&&";
		
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public double getSpeed() {
		return this.speed;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}

}
