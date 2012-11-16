package xmas.parts;

public class Tower {

	private int range;
	private int damage;
	private int art;
	private Position p;

	public Tower(int art, Position p) {
		this.p = p;
		switch (this.art = art) {
		// Kokusnuss
		case 0:
			this.range = 10;
			this.damage = 30;
			break;
		// Lametta
		case 1:
			this.range = 3;
			this.damage = 0;
			break;
		// Kugeln
		case 2:
			this.range = 20;
			this.damage = 10;
			break;
		}
	}
	
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	
	
	
	
}
