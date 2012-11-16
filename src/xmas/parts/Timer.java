package xmas.parts;

public class Timer {
	
	private int StartTime = 30;
	
	public boolean countTime() {
		if(StartTime != 0) {
			StartTime--;
			return false;
		} 
		else {
			return true;
		}
	}
	
	public void timer() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
