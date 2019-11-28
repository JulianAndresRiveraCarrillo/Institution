package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.*;
public class Director {
	
	@FXML
	Button profesor;
	
	@FXML
	Button directorGrupo;
	
	@FXML
	Button estudiante;
	
	@FXML
	Button personero;
	
	private Login log;
	
	private Student st;
	
	private Profesor p;

	@FXML
	public void openTeacher(MouseEvent event) {
		
		
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("Profesor.fxml"));
		try {
			Parent root = fxml.load();
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			p = fxml.getController();
			//p.setScene(scene);
			stage.setTitle("PROFESOR");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
