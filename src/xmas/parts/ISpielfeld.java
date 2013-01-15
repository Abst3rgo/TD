package xmas.parts;

public interface ISpielfeld {

	// Returns the wight of the current Field
	int getX();

	// Returns the high of the current Field
	int getY();

	// Returns the Battelfield in a String for TUI
	String tostring();

	// Place a Tower with a specific Symbol on the y and x of the Field
	boolean setTower(String symbol, int y, int x);

	// Returns the Battelfield in a Array
	String[][] getfieldArray();

	// Returns the Symbol for the empty Field
	String getEmpty();

	// Set a specific Field with the Cordinates y and x empty
	void setFieldEmpty(int y, int x);

	// Set the Mob to a new Position an save the old Position
	void updateMob(String symbol, int y, int x, int oldY, int oldX);

	// Returns the Y Cordinate of the StartPosition
	int getStartY();

	// Returns the X Cordinate of the StartPosition
	int getStartX();
	
	// Returns a boolean Copy of the Battelfield that where visited
	boolean[][] getVisitField();

}
