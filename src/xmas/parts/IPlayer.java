package xmas.parts;

public interface IPlayer {
	
	// Returns the Name of the actual Player
	String getname();
	
	// Set the Name of the actual Player
	void setname(String name);
	
	// Returns the existing Live of the  Player
	int getLive();
	
	// Set the Live of the Player to a spezific Number
	void setLive(int life);
	
	// Decrement the Live of the Player by 1
	void loseLive();
	
	// Returns true if the Players Live are lower than 1
	boolean gameover();

}
