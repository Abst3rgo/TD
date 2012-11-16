package xmas.parts;

public class MobGnom extends Mob {

	private int health;
	private double speed;
	
	
	public MobGnom() {
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
