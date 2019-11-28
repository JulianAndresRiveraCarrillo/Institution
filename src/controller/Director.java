package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import thread.ClockThread;

public class Director implements Initializable{
	
private ClockThread c;
	
	@FXML
	private Label time;
	
	@FXML
	Label label1;
	
	@FXML
	Label label2;
	
	@FXML
	Button profesor;
	
	@FXML
	Button directorGrupo;
	
	@FXML
	Button estudiante;
	
	@FXML
	Button personero;

	@FXML
	ImageView image1;
	
	@FXML
	ImageView image2;
	
	@FXML
	ImageView image3;
	
	@FXML
	ImageView image4;

	private Scene scene;
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	@FXML
	public void doThread() {
		c.start();
		time.setText(c.getD());
	}
	
	void Teacher(MouseEvent evet) {
		label1.setVisible(false);
		label2.setVisible(false);
		
		image1.setVisible(false);
		image2.setVisible(false);
		image3.setVisible(false);
		image4.setVisible(false);
		
		profesor.setVisible(false);
		directorGrupo.setVisible(false);
		estudiante.setVisible(false);
		personero.setVisible(false);
		
		
	}
		
}
