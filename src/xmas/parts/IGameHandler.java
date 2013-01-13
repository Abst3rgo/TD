package xmas.parts;

import xmas.parts.impl.Mob;
import xmas.parts.impl.Tower;


public interface IGameHandler {
	
	// Returns true if a Tower was create and set to a Place on the Field
	public boolean erstelleTower(int art, int x, int y);
	
	// Wait a Second betwen each Mob run
	public void delay();
	
	// Returns true if all Mobs are dead or reach Finish
	public boolean waveOver();
	
	// Ceck numbers of Mobs and create a new Mob
	public void createMob();
	
	// Create 1 of 3 Kinds of Mobs Types
	public void createSpezMob(int mobType);
	
	// Change the Postiotions of all Mobs
	public void mobwalk();
	
	// Returns a String that tells wihch Mobs are hit by a Tower
	public String towershot();
	
	// Ceck if a spezific Mob is on a Field that a Tower can reach
	public void mobonField(Mob mob, Tower tower, int tY, int tX, StringBuffer s);
	

}
