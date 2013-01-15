package xmas.parts;

import xmas.parts.impl.Mob;
import xmas.parts.impl.MobElfe;
import xmas.parts.impl.Spielfeld;
import xmas.parts.impl.Tower;
import junit.framework.TestCase;

public class MobElfeTest extends TestCase {
	Mob mob;
	Spielfeld spielfeld;
	Tower tower;
	Mob mobElf;
	
	
	public void setUp() {
		mob = new Mob(2,2);
		mobElf = new MobElfe(2,3);
		spielfeld = new Spielfeld("1");
	}

	
	public void testGetValue() {
		// getMehtode
		
		assertEquals(15, mobElf.getHealth());
		assertEquals(1.5, mobElf.getSpeed());
		assertEquals("Elfe", mobElf.getArt());
		assertEquals("**", mobElf.getSymbol());
		
		assertEquals(2,mob.getY());
		assertEquals(2,mob.getX());
		assertEquals(0,mob.getOldY());
		assertEquals(0,mob.getOldX());
		assertEquals(null,mob.getArt());
		assertEquals(null,mob.getSymbol());
		assertEquals(0,mob.getHealth());
		
		// SetMehtode
		mob.setHealth(10);
		mobElf.setHealth(10);
		
		// Mob getoffen
		assertEquals(true,mob.mobHit(2, 2));
		assertEquals(false,mob.mobHit(2, 3));
		assertEquals(false,mob.mobHit(3, 2));
		assertEquals(false,mob.mobHit(3, 3));
		
		// Ziel ereicht
		//mob = new Mob(2, 6);
		//assertEquals(true,mob.zielEreicht(spielfeld.getfieldArray()));
		
		// Mob Walk Mehtode
		for(int i = 0; i < 4; i++) {
			spielfeld.setTower("|K", 4, 2);
			spielfeld.setTower("|K", 4, 3);
			spielfeld.setTower("|K", 3, 4);
			assertEquals(false,mob.walk(spielfeld.getfieldArray(), spielfeld.getEmpty()));
		}
		
		//
		//assertEquals(false,mob.walk(spielfeld.getfieldArray(), spielfeld.getEmpty()));
		
		
	}

}
