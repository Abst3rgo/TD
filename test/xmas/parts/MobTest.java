package xmas.parts;

import xmas.parts.impl.Mob;
import junit.framework.TestCase;

public class MobTest extends TestCase {
	Mob mob;
	
	public void setUp() {
		mob = new Mob(2,2);
	}

	
	public void testGetValue() {
		// getter/setter
		assertEquals(2, mob.getX());
		assertEquals(2, mob.getY());
		assertEquals(null, mob.getSymbol());
		assertEquals(null, mob.getArt());
		// walk Methode
		int[] wayArray = null;
		int counter = 0;
	}
}
