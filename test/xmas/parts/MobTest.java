package xmas.parts;

import junit.framework.TestCase;

public class MobTest extends TestCase {
	
	Mob mob;
	
	public void setUp() {
		mob = new Mob();
	}

	
	public void testGetValue() {
		assertEquals(0, mob.getX());
		assertEquals(42, mob.getY());
	}
}
