package xmas.parts;
import java.io.*;
import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	Player player;
	
	
	public void setUp() {
		player = new Player("Horst", 3);
	}
	
	
	public void testGetValue() {
		// Life Test
		player.setgift(2);
		assertEquals(2, player.checkgifts());
		// Name Test
		player.setname("Bernd");
		assertEquals("Bernd", player.getname());
		// GameOver Test false
		assertEquals(1, player.gameover());
		player.setgift(0);
		assertEquals(0, player.gameover());
		
		
	}

}

