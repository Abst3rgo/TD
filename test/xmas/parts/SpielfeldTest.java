package xmas.parts;

import xmas.parts.impl.Spielfeld;
import junit.framework.TestCase;

public class SpielfeldTest extends TestCase {
	Spielfeld spielfeld;

	protected void setUp() throws Exception {
		super.setUp();
		spielfeld = new Spielfeld("3");
		spielfeld = new Spielfeld("1");
		spielfeld = new Spielfeld("2");
	}
	
	public void testGetValue() {
	
		String fieldArray[][] = spielfeld.getfieldArray();
		boolean visitArray[][] = spielfeld.getVisitField();
		
		// getter/setter
		assertEquals(10, spielfeld.getX());
		assertEquals(10, spielfeld.getY());
		assertEquals(1, spielfeld.getStartY());
		assertEquals(2, spielfeld.getStartX());
		assertEquals(9, spielfeld.getEndY());
		assertEquals(2, spielfeld.getEndX());
		assertEquals(fieldArray,spielfeld.getfieldArray());
		assertEquals(visitArray, spielfeld.getVisitField());
		spielfeld.setFieldEmpty(7, 7);
		assertEquals("..", fieldArray[7][7]);
		assertEquals("..", spielfeld.getEmpty());
		spielfeld.setMob("^^", 6, 6);
		assertEquals("^^", fieldArray[6][6]);
		spielfeld.updateMob("^^", 6, 7, 6, 6);
		assertEquals("^^", fieldArray[6][7]);
		assertEquals(spielfeld.tostring(), spielfeld.tostring());
		// Tower Setzen
		assertEquals(true,spielfeld.setTower("K|", 4, 3));
		assertEquals(true,spielfeld.setTower("K|", 4, 2));
		assertEquals(true,spielfeld.setTower("K|", 3, 4));
		assertEquals(false,spielfeld.setTower("K|", 2, 2) );
		assertEquals(true,spielfeld.setTower("K|", 3, 5));
		assertEquals(true,spielfeld.setTower("K|", 3, 6));
		assertEquals(true,spielfeld.setTower("K|", 6, 7));
		assertEquals(true,spielfeld.setTower("K|", 6, 6));
		assertEquals(true,spielfeld.setTower("K|", 5, 5));
		
		
	}
	

}
