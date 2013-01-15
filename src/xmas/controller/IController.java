package xmas.controller;

public interface IController {
	

	// Returns the high of the Battelfield 
	int getSpielfeldY();

	// Returns the width of the Battelfield
	int getSpielfeldX();

	// Returns a Message for the User // TUI
	String getStartMessage();
	
	// Returns important Informations for the User // TUI 
	String getGameMessage();

	// Retruns a String that includes the Battelfield for the Tui
	String getSpielfeld();

	// Start the Game in Mode2 and Return -1 if User lose Game / 0 if Game run / 1 if a Wave are over 
	int startGame();
	 
	// Set the Battelfield to a specific size
	void setSpielfeld(String input);

	// erstellt Tower auf der Art auf den vorgegebenen Feldern
	boolean erstelleTower(int art, int spalte, int zeile);
	
	// Retruns true wenn 30 Sec rum und Mobs losslaufen 
	boolean timeOver();
	
	// Return the Array of the Field for the GUI
	String[][] getSpielfeldArray();


}
