package xmas.controller.impl;

public class Timer {
	
	private Thread timer;
	private int time = 10;
	private final static int sleepTimeMS = 1000;
	private boolean timeOut;
	
	// --------------------------Konstuktor Get/Set---------------------------
	
	public Timer() {
		timer = new Thread(new Time());
		timer.start();
	}
	
	public void startTimer(){
		timer = new Thread(new Time());
		timer.start();
	}
	
	public boolean timeOver() {
		return timeOut;
	}
	
	public void resetTimer() {
		time = 10;
		this.timeOut = false;
	}
	
	// -------------------------Timer Thread Inner Class----------------------------
	
	class Time extends Thread {
		
		public void run() {
			try {
				while(!timeOut) {
					if(time != 0) {
						sleep(sleepTimeMS);
						time--;
					} else {
						timeOut = true;
						
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}
		}
	}
	
	

}
