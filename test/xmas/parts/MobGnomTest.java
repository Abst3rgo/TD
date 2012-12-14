package xmas.parts;

import xmas.parts.impl.MobGnom;
import junit.framework.TestCase;

public class MobGnomTest extends TestCase {

	MobGnom mob;
	
	public void setUp() {
		mob = new MobGnom(2,2);
	}

	
	public void testGetValue() {
		// GetMethode
		assertEquals(20, mob.getHealth());
		assertEquals(1.5, mob.getSpeed());
		assertEquals("Gnom", mob.getArt());
		assertEquals("^^", mob.getSymbol());
		
		// SetMehtode
		mob.setHealth(15);
		assertEquals(15, mob.getHealth());
	}
}
