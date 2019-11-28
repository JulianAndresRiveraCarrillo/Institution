package thread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.Label;

public class ClockThread extends Thread{
	
	private String d;
	private boolean x;
	
	public ClockThread(boolean x) {
		this.x = x;
	}
	
	public void changeD(String d) {
		this.d = d;
	}
	
	public String getD() {
		return d;
	}
	
	@Override
	public void run() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		while(!x) {
		   LocalDateTime now = LocalDateTime.now();
		   changeD(dtf.format(now));
		   try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
