package xmas.parts;

import xmas.parts.impl.MobElfe;
import junit.framework.TestCase;

public class MobElfeTest extends TestCase {
	MobElfe mob;
	
	public void setUp() {
		mob = new MobElfe(2,2);
	}

	
	public void testGetValue() {
		// getMehtode
		assertEquals(15, mob.getHealth());
		assertEquals(1.5, mob.getSpeed());
		assertEquals("Elfe", mob.getArt());
		assertEquals("**", mob.getSymbol());
		// SetMehtode
		mob.setHealth(10);
		assertEquals(10, mob.getHealth());
	}

}
