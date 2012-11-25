package xmas.parts;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	Player player;
	
	
	public void setUp() {
		player = new Player("Horst");
		player = new Player("Bernd", 3);
	}
	
	
	public void testGetValue() {
		// Life Test;
		assertEquals(3, player.getLive());
		player.loseLive();
		assertEquals(2, player.getLive());
		// Name Test
		player.setname("Bernd");
		assertEquals("Bernd", player.getname());
		// GameOver Test false
		assertEquals(false, player.gameover());
		player.setLive(0);
		assertEquals(true, player.gameover());
		
		
	}

}

