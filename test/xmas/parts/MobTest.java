package xmas.parts;

import junit.framework.TestCase;

public class MobTest extends TestCase {
	
	Mob mob;
	
	public void setUp() {
		mob = new Mob("Santa");
	}

	
	public void testGetValue() {
		mob.setName("Klaus");
		assertEquals("Klaus", mob.getName());
		mob.setHealth(42);
		assertEquals(42, mob.getHealth());
		mob.setSpeed(2.5);
		assertEquals(2.5, mob.getSpeed());
		
	}
}
