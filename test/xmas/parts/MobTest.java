package xmas.parts;

import xmas.parts.impl.Mob;
import xmas.parts.impl.Spielfeld;
import junit.framework.TestCase;

public class MobTest extends TestCase {
	Mob mob;
	Spielfeld spielfeld = new Spielfeld("1");
	
	public void setUp() {
		mob = new Mob(2,2);
	}

	
	public void testGetValue() {
		// getter/setter
		assertEquals(2, mob.getX());
		assertEquals(2, mob.getY());
		assertEquals(0, mob.getOldX());
		assertEquals(0, mob.getOldY());
		assertEquals(null, mob.getSymbol());
		assertEquals(null, mob.getArt());
		assertEquals(0, mob.getHealth());
		mob.setHealth(0);
		// If Branch
		assertEquals(true, mob.mobHit(2, 2));
		assertEquals(false, mob.mobHit(3, 4));
		assertEquals(false, mob.mobHit(2, 3));
		assertEquals(false, mob.mobHit(3, 2));
		// walk Methode
		while(mob.walk(spielfeld.getfieldArray(), spielfeld.getEmpty())) {
			
		}
		
		
	}
}
