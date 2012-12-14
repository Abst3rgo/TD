package xmas.parts;

import xmas.parts.impl.Spielfeld;
import junit.framework.TestCase;

public class SpielfeldTest extends TestCase {
	Spielfeld spielfeld;

	protected void setUp() throws Exception {
		super.setUp();
		spielfeld = new Spielfeld("1");
	}
	
	public void testGetValue() {
	
		// getter/setter
		assertEquals(8, spielfeld.getX());
		assertEquals(8, spielfeld.getY());
		assertEquals(true,spielfeld.setTower("K|", 4, 3));
		assertEquals(true,spielfeld.setTower("K|", 4, 2));
		assertEquals(true,spielfeld.setTower("K|", 3, 4));
		assertEquals(false,spielfeld.setTower("K|", 2, 2) );
		
		
	}
	

}
