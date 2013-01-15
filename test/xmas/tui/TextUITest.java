package xmas.tui;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import xmas.controller.impl.Controller;
import junit.framework.TestCase;

public class TextUITest extends TestCase {
	
	TextUI tui;
	Controller controller;
	Logger logger = Logger.getLogger(TextUITest.class);

	
	public void setUp() {
		controller = new Controller();
		tui = new TextUI(controller);
		PropertyConfigurator.configure("log4j.properties");
	}

	
	public void testGetValue() {
		// output
		tui.printStartMenue();
		tui.printInstuktion(0);
		tui.printInstuktion(1);
		tui.printInstuktion(2);
		
		// Set
		tui.setStartMenue("1");
		for(int i = 0; i < 9; i++) {
			tui.iterate();
		}
		
		// Tower erstellen
		
		assertEquals(false,tui.handleInput("k", 0));
		assertEquals(false,tui.handleInput("3", 1));
		assertEquals(false,tui.handleInput("3", 2));
		
		
		assertEquals(true,tui.handleInput("i", 0));
		assertEquals(false,tui.handleInput("4", 1));
		assertEquals(false,tui.handleInput("4", 2));
		
		assertEquals(false,tui.handleInput("l", 0));
		assertEquals(true,tui.handleInput("1", 1));
		assertEquals(true,tui.handleInput("1", 2));
		
		assertEquals(false,tui.handleInput("c", 0));
		assertEquals(true,tui.handleInput("10", 2));
		assertEquals(true,tui.handleInput("10", 1));
		
		
		
		
		// Get
		assertEquals(false,tui.timeOver());
		

		
		
	}
	
}
