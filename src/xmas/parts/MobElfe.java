package xmas.parts;

public class MobElfe extends Mob {

	private int health;
	private double speed;
	
	
	public MobElfe() {
		super();
		this.health = 15;
		this.speed = 1.5;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public double getSpeed() {
		return this.speed;
	}
	

}
