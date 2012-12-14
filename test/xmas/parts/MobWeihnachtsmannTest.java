package xmas.parts;

import xmas.parts.impl.MobWeihnachtsmann;
import junit.framework.TestCase;

public class MobWeihnachtsmannTest extends TestCase {

	MobWeihnachtsmann mob;
	
	public void setUp() {
		mob = new MobWeihnachtsmann(2,2);
	}

	
	public void testGetValue() {
		// GetMehtode
		assertEquals(100, mob.getHealth());
		assertEquals(1.0, mob.getSpeed());
		assertEquals("&&", mob.getSymbol());
		// SetMehtode
		mob.setHealth(10);
		assertEquals(10, mob.getHealth());
	}
}
