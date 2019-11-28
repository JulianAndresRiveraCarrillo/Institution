package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import thread.ClockThread;
import thread.VisibleThread;

public class Profesor implements Initializable{
	
	private ClockThread c;
	private VisibleThread v;
	
	@FXML
	private ImageView carita;
	
	@FXML
	private Label time;
	@FXML
	private Scene scene;
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	@FXML
	public void doThread() {
		c.start();
		time.setText(c.getD());
	}
	
	@FXML
	public void doVisibleThread() {
		boolean exit = false;
		boolean visible = true;
		v = new VisibleThread(carita, exit, visible);
		v.start();
		carita.setVisible(v.getVisible());
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		doVisibleThread();
	}
	
	
	
	

}
