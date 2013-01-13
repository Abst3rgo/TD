package xmas.parts;

public interface IPlayer {
	
	// Returns the Name of the actual Player
	public String getname();
	
	// Set the Name of the actual Player
	public void setname(String name);
	
	// Returns the existing Live of the  Player
	public int getLive();
	
	// Set the Live of the Player to a spezific Number
	public void setLive(int life);
	
	// Decrement the Live of the Player by 1
	public void loseLive();
	
	// Returns true if the Players Live are lower than 1
	public boolean gameover();

}
