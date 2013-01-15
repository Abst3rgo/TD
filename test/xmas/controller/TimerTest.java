package xmas.controller;

import xmas.controller.impl.Timer;
import junit.framework.TestCase;

public class TimerTest extends TestCase {
	
	Timer timer;
	
	public void setUp() {
		timer = new Timer();
	}

	
	public void testGetValue() throws InterruptedException {
		// GetMethode
		assertEquals(false, timer.timeOver());
		Thread.sleep(11000);
		assertEquals(true, timer.timeOver());
		// SetMethode
		timer.resetTimer();
		timer.startTimer();
		
	}

}
