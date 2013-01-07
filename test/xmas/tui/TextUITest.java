package xmas.tui;

import xmas.controller.impl.Controller;
import xmas.tui.TextUI.Timer;
import junit.framework.TestCase;

public class TextUITest extends TestCase {
	
	TextUI tui;
	Controller controller;
	Timer time;
	Thread timer;

	
	public void setUp() {
		tui = new TextUI(controller);
		timer = new Thread(time);
	}

	
	public void testGetValue() {
		// Set
		timer.run();
		//assertEquals(false,tui.quitOrFailure("z"));
		assertEquals(true,tui.quitOrFailure("q"));
		
	}
	
}
