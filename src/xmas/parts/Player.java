package xmas.parts;

public class Player {
	
	private String name;
	private int gift;
	
	public Player(String name, int gift) {
		this.name = name;
		this.gift = gift;
	}
	
	public String getname() {
		return name;
	}
	
	public void setname(String name) {
		this.name = name;
	}

	public void setgift(int gift) {
		this.gift = gift;
	}
	
	public int checkgifts() {
		return this.gift;
	}
	
	public int gameover() {
		if ( gift == 0) {
			return 0;
		}
		else {
			return 1;
		}
	}
}
