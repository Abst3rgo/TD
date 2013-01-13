package xmas.parts;

import xmas.parts.impl.GameHandler;
import junit.framework.TestCase;

public class GameHandlerTest extends TestCase {
	
	IGameHandler gameHandler;
	
	protected void setUp() throws Exception {
		gameHandler = new GameHandler(null, null);
	
	}
	
	public void testGetValue() {
		
		for(int i = 0; i < 12; i++) {
			gameHandler.createMob();
		}
	
		
	}

}
