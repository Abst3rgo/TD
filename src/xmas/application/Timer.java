package xmas.application;

public class Timer {
	
	private Thread timer;
	private int time = 5;
	private final int sleepTimeMS = 1000;
	private boolean timeOut;
	
	// --------------------------Konstuktor Get/Set---------------------------
	
	public Timer() {
		timer = new Thread(new Time());
		timer.start();
	}
	
	public void startTimer(){
		
	}
	
	public boolean timeOver() {
		return timeOut;
	}
	
	public void resetTimer() {
		timer.stop();
		time = 10;
		this.timeOut = false;
		System.out.println("Timer resetet: TimeOut = " + timeOut);
	}
	
	// -------------------------Timer Thread Inner Class----------------------------
	
	class Time extends Thread {
		
		public void run() {
			try {
				while(true) {
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
