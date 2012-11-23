package xmas.parts;

import junit.framework.TestCase;

public class MobTest extends TestCase {
	
	Mob mob;
	
	public void setUp() {
		mob = new Mob();
	}

	
	public void testGetValue() {
		assertEquals(0, mob.getX());
		assertEquals(20, mob.getY());
		assertEquals("", mob.getSymbol());
		assertEquals(null, mob.getArt());
	}
}
