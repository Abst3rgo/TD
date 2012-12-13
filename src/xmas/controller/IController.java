package xmas.controller;

public interface IController {

	int getSpielfeldY();

	int getSpielfeldX();

	String getStartMessage();

	String getSpielfeld();

	int startGame();

	boolean erstelleTower(int art, int parseInt, int spalte);
	 
	void setSpielfeld(String input);

}
