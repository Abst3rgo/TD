package xmas.parts;

public class Tower {

	//private Position p;
	private int stelle;
	private int reihe; 

	public Tower() {
		
	}
	
	public Tower( int reihe , int stelle ) {
		this.reihe = reihe;
		this.stelle = stelle;
	}
	
	public int getReihe() {
		return this.reihe;
	}
	
	public int getStelle() {
		return this.stelle;
	}
	
	public String getSymbol() {
		return null;
		
	}
	
	
	
	
	
}
