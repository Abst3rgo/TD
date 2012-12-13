package xmas.parts;

import xmas.parts.impl.Tower;
import junit.framework.TestCase;

public class TowerTest extends TestCase {
	Tower tower;

	protected void setUp() {
		tower = new Tower(1,2,1);
	}
	
	public void testGetValue() {
		assertEquals(2, tower.getX());
		assertEquals(1, tower.getY());
		assertEquals(null, tower.getSymbol());
	}

}
