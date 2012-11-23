package xmas.parts;

import junit.framework.TestCase;

public class TowerNussTest extends TestCase {

	TowerNuss nuss;

	protected void setUp() throws Exception {
		//super.setUp();
		 nuss = new TowerNuss(1,2);
	}
		
	public void testGetValue() {
		assertEquals(10, nuss.getRange());
		assertEquals(20, nuss.getDamage());
		assertEquals("K|", nuss.getSymbol());
	}

}
