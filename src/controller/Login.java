package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Login implements Initializable{

	private Scene scene;
	
	private char type;
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	public void getType(char type) {
		this.type=type;
	}

	@FXML
	public void signIn(MouseEvent event) {
((Stage)scene.getWindow()).close();
		
		FXMLLoader f = new FXMLLoader(getClass().getResource("Login.fxml"));
		try {
			Parent root = f.load();
			Stage s = new Stage();
			Scene sc = new Scene(root);
			s.setScene(sc);
			if(type=='D') {
				Director d = f.getController();
				d.setScene(sc);
			}
			else if(type=='P') {
				Profesor p = f.getController();
				p.setScene(sc);
			}
			if(type=='S') {
				Estudiante e = f.getController();
				e.setScene(sc);
			}
			s.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
