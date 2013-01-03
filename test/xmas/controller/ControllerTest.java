package xmas.controller;

import xmas.controller.impl.Controller;
import xmas.parts.impl.Spielfeld;
import junit.framework.TestCase;

public class ControllerTest extends TestCase {
	Controller controller;
	Spielfeld spielfeld;
	
	protected void setUp() throws Exception {
		controller = new Controller();
		spielfeld = new Spielfeld("1");
	}
	
	public void testGetValue() {
		// getter/setter
		controller.setSpielfeld("1");
		assertEquals(8,controller.getSpielfeldY());
		assertEquals(8,controller.getSpielfeldX());
		assertEquals("Willkommen bei Xmas Tower Defence !",controller.getStartMessage());
		assertEquals(spielfeld.tostring(),controller.getSpielfeld());
		// Erstelle Tower
		assertEquals(true,controller.erstelleTower(0, 4, 2));
		assertEquals(true,controller.erstelleTower(1, 4, 2));
		assertEquals(false,controller.erstelleTower(3, 4, 2));
		assertEquals(false,controller.erstelleTower(2, 2, 2));
		// Start Game
		assertEquals(0,controller.startGame());
		controller.setPlayerLive(0);
		assertEquals(-1,controller.startGame());
		for(int i = 0; i <= 12; i++) {
			controller.startGame();
		}
		controller.clearArrays();
		assertEquals(1,controller.startGame());

		
		
	}

}
