package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.Institute;
import model.Student;
import thread.ClockThread;

public class Estudiante implements Initializable{
private ClockThread c;
	
	@FXML
	private Label time;
	
	private Scene scene;
	
	private Student student;
	
	private Institute inst;
	
	@FXML
	private TextField tf;
	
	@FXML
	private VBox vbox;
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public void setInstitute(Institute i) {
		inst = i;
	}
	
	@FXML
	public void seeGrade() {
		int code = Integer.parseInt(tf.getText());
		double x = inst.getAverageSubject(student.getId(), code);
		Label l = new Label(student.searchSubject(code).getName()+ " -> " + x);
		vbox.getChildren().add(l);
	}
	@FXML
	public void doThread() {
		c.start();
		time.setText(c.getD());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
