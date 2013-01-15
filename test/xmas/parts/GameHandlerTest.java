package xmas.parts;

import xmas.parts.impl.GameHandler;
import xmas.parts.impl.Mob;
import xmas.parts.impl.MobElfe;
import xmas.parts.impl.Player;
import xmas.parts.impl.Spielfeld;
import xmas.parts.impl.Tower;
import xmas.parts.impl.TowerNuss;
import junit.framework.TestCase;

public class GameHandlerTest extends TestCase {
	
	GameHandler gameHandler;
	Mob mob;
	IPlayer player;
	Spielfeld spielfeld;
	StringBuffer s;
	Tower tower;
	
	protected void setUp() throws Exception {
		player = new Player("Hans");
		mob = new MobElfe(2,2);
		spielfeld = new Spielfeld("1");
		gameHandler = new GameHandler(spielfeld, player);
		s = new StringBuffer();
		tower = new TowerNuss(2, 3);
		
		
	
	}
	
	public void testGetValue() {
		
		gameHandler.createSpezMob(8);
		gameHandler.createSpezMob(5);
		gameHandler.createSpezMob(1);
		
		gameHandler.mobonField(mob, tower, 2, 3, s);
		gameHandler.mobonField(mob, tower, 2, 2, s);
		
		mob.setHealth(0);
		gameHandler.killMob(mob, s);
		
		
	
		
	}

}
