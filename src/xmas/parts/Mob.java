package xmas.parts;

public class Mob {


	private int x;
	private int y;
	private int route;
	
	public Mob(int y, int x) {
		this.x = x;
		this.y = y;
		this.route = 0;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public String getArt() {
		return null;
	}
	
	public String getSymbol() {
		return null;
	}
	
	public boolean walk(int[] wayArray, int wayCounter) {
		if(wayCounter != route) {
			switch(wayArray[route]) {
				case 0:
					return true;
				case 2:
					y++;
					break;
				case 4:
					x--;
					break;
				case 6:
					x++;
				case 8:
					y--;
					break;
			}
			route++;
			return false;
		} else {
			return true;
		}
	}
	
} // End Class
