package xmas.parts;

import xmas.parts.impl.MobRentier;
import junit.framework.TestCase;

public class MobRentierTest extends TestCase {

	MobRentier mob;
	
	public void setUp() {
		mob = new MobRentier(2,2);
	}

	
	public void testGetValue() {
		assertEquals(15, mob.getHealth());
		assertEquals(1.5, mob.getSpeed());
		assertEquals("Rentier", mob.getArt());
		assertEquals("m", mob.getSymbol());
	}

}
