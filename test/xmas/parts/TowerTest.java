package xmas.parts;

import junit.framework.TestCase;

public class TowerTest extends TestCase {
	Tower tower;

	protected void setUp() {
		tower = new Tower();
	}
	
	public void testGetValue() {
		tower.setRange(6);
		assertEquals(6, tower.getRange());
		tower.setX(10);
		assertEquals(10, tower.getX());
		tower.setY(22);
		assertEquals(22,tower.getY());
	}

}
