package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import thread.ClockThread;

public class Profesor implements Initializable{
	
private ClockThread c;
	
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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	
	
	

}
