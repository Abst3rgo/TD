package xmas.parts;

import junit.framework.TestCase;

public class MobElfeTest extends TestCase {
	MobElfe mob;
	
	public void setUp() {
		mob = new MobElfe(2,2);
	}

	
	public void testGetValue() {
		assertEquals(15, mob.getHealth());
		assertEquals(1.5, mob.getSpeed());
		assertEquals("Elfe", mob.getArt());
		assertEquals("**", mob.getSymbol());
	}

}
