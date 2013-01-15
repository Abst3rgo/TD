package xmas.controller;

public interface IController {
	

	// Returns the high of the Battelfield 
	int getSpielfeldY();

	// Returns the width of the Battelfield
	int getSpielfeldX();

	// Returns a Message for the User
	String getStartMessage();
	
	// Returns important Informations for the User
	String getGameMessage();

	// Retruns a String that includes the Battelfield for the Tui
	String getSpielfeld();

	// Start the Game in Mode2 and Return -1 if User lose Game / 0 if Game run / 1 if a Wave are over 
	int startGame();
	 
	// Set the Battelfield to a specific size
	void setSpielfeld(String input);

	boolean erstelleTower(int art, int parseInt, int zeile);
	
	boolean timeOver();


}
