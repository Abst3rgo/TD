package xmas.parts;

import junit.framework.TestCase;

public class TowerTest extends TestCase {
	Tower tower;

	protected void setUp() {
		tower = new Tower(1,2);
	}
	
	public void testGetValue() {
		assertEquals(2, tower.getX());
		assertEquals(1, tower.getY());
		assertEquals(null, tower.getSymbol());
	}

}
