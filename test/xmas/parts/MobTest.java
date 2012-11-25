package xmas.parts;

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
		assertEquals(true, mob.walk(wayArray, counter));
		int[] wayArray2 = {2,4,8,6,0};
		counter = 6;
		for(int i = 0; i <= counter; i++) {
			assertEquals(false, mob.walk(wayArray2, counter));
		}
	}
}
