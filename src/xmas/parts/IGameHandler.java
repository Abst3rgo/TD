package xmas.parts;


public interface IGameHandler {
	
	// Returns true if a Tower was create and set to a Place on the Field
	boolean erstelleTower(int art, int x, int y);
	
	// Wait a Second betwen each Mob run
	void delay();
	
	// Returns true if all Mobs are dead or reach Finish
	boolean waveOver();
	
	// Ceck numbers of Mobs and create a new Mob
	void createMob();
	
	// Create 1 of 3 Kinds of Mobs Types
	void createSpezMob(int mobType);
	
	// Change the Postiotions of all Mobs
	void mobwalk();
	
	// Returns a String that tells wihch Mobs are hit by a Tower
	String towershot();
	
	

}
