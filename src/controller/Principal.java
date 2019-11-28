package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Principal implements Initializable{
	
	@FXML
	private Button director;
	@FXML
	private Button teacher;
	@FXML
	private Button student;
	@FXML
	private BorderPane bp;
	
	private Scene scene;
	
	private Login l;
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	@FXML
	public void director(MouseEvent event) {
		((Stage)scene.getWindow()).close();
		
		FXMLLoader f = new FXMLLoader(getClass().getResource("Login.fxml"));
		try {
			Parent root = f.load();
			Stage s = new Stage();
			l = f.getController();
			Scene sc = new Scene(root);
			l.setScene(sc);
			s.setScene(sc);
			s.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
