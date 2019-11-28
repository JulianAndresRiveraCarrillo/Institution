package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Institute;
import model.Student;
import thread.ClockThread;

public class Login implements Initializable{
private ClockThread c;
	
	@FXML
	private Label time;

	private Scene scene;
	
	private char type;
	
	private Institute inst;
	
	@FXML
	private TextField tf;
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	public void getType(char type) {
		this.type=type;
	}
	
	@FXML
	public void doThread() {
		c.start();
		time.setText(c.getD());
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
				Student st = inst.searchStudentById(Integer.parseInt(tf.getText()));
				e.setStudent(st);
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
