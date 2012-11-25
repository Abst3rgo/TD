package xmas.parts;

import xmas.controller.Controller;
import xmas.tui.TextUI;
import junit.framework.TestCase;

public class XmasTest extends TestCase {
	
	
	public void testGetValue() {
		
		TextUI tui = new TextUI(new Controller());
		tui.printMenue();
	
	}

}
