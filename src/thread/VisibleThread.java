package thread;

import javafx.scene.image.ImageView;

public class VisibleThread extends Thread {

	private ImageView image;	
	private boolean exit = false;
	private boolean visible = true;
	public VisibleThread(ImageView i,boolean exit,boolean visible) {
		image = i;
		this.exit = exit;
		this.visible = visible;
	}
	
	public boolean getVisible() {
		return visible;
	}
	public void run() {
		try {
			while(!exit) {
				image.setVisible(!visible);
				sleep(250);
				image.setVisible(visible);
				sleep(250);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
