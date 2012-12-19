package xmas.parts;

import xmas.parts.impl.TowerNuss;
import junit.framework.TestCase;

public class TowerNussTest extends TestCase {

	TowerNuss nuss;

	protected void setUp() throws Exception {
		//super.setUp();
		 nuss = new TowerNuss(1,2);
	}
		
	public void testGetValue() {
		assertEquals(1, nuss.getRange());
		assertEquals(5, nuss.getDamage());
		assertEquals("K|", nuss.getSymbol());
	}

}
