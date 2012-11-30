package xmas.parts;

import xmas.parts.impl.TowerKugel;
import junit.framework.TestCase;

public class TowerKugelTest extends TestCase {

	TowerKugel kugel;

	protected void setUp() throws Exception {
		super.setUp();
		 kugel = new TowerKugel(1,2);
	}
		
	public void testGetValue() {
		assertEquals(15, kugel.getRange());
		assertEquals(20, kugel.getDamage());
		assertEquals("C|", kugel.getSymbol());
	}
}
