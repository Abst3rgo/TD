package xmas.parts;

import xmas.parts.impl.Tower;
import junit.framework.TestCase;

public class TowerTest extends TestCase {
	Tower tower;

	protected void setUp() {
		tower = new Tower(3,5,3);
	}
	
	public void testGetValue() {
		assertEquals(5, tower.getX());
		assertEquals(3, tower.getY());
		assertEquals(null, tower.getSymbol());
		assertEquals(3,tower.getRange());
		assertEquals(0,tower.getDamage());
		assertEquals(25,tower.getTowerRadiusLength());
		// Test der Range Field bei Tower auf Punkt 3,5 mit Range 3
		int towerRadiusY[] = tower.getRangeFieldY();
			//{0, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 6, 5, 5, 5, 4, 4, 4, 4, 4};
		int towerRadiusX[] = tower.getRangeFieldX();
			//{5, 6, 5, 4, 7, 6, 5, 4, 3, 8, 7, 6, 5, 4, 3, 2, 5, 4, 5, 6, 3, 4, 5, 6, 7};
		assertEquals(towerRadiusY,tower.getRangeFieldY());
		assertEquals(towerRadiusX,tower.getRangeFieldX());
	}

}
