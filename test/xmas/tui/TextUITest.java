package xmas.tui;

import java.io.ByteArrayInputStream;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import xmas.controller.impl.Controller;
import xmas.tui.TextUI.Timer;
import junit.framework.TestCase;

public class TextUITest extends TestCase {
	
	TextUI tui;
	Controller controller;
	Timer time;
	Thread timer;
	
	static Logger logger = Logger.getLogger(TextUITest.class);

	
	public void setUp() {
		tui = new TextUI(controller);
		timer = new Thread(time);
		PropertyConfigurator.configure("log4j.properties");
	}

	
	public void testGetValue() {
		// Set
		timer.run();
		//assertEquals(false,tui.quitOrFailure("z"));
		String input = "k";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		//tui.handleinput();
		
		/*
		String s = "2";
		System.setIn(new ByteArrayInputStream(s.getBytes()));
		tui.printMenue();
		assertEquals(true,tui.quitOrFailure("q"));
		*/
		
	}
	
}
