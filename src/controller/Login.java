package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Scene;

public class Login implements Initializable{

	private Scene scene;
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	public char getType(char type) {
		return type;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
