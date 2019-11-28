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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import thread.ClockThread;
import thread.VisibleThread;

public class Principal implements Initializable{
	
	@FXML
	private Button director;
	@FXML
	private Button teacher;
	@FXML
	private Button student;
	@FXML
	private BorderPane bp;
	
	@FXML
	private ImageView carita;
	
	private Scene scene;
	
	private Login l;
	
	private ClockThread c;
	private VisibleThread v;
	@FXML
	private Label time;
	
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
			l.getType('D');
			s.setScene(sc);
			s.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	public void profesor(MouseEvent event) {
		((Stage)scene.getWindow()).close();
		
		FXMLLoader f = new FXMLLoader(getClass().getResource("Login.fxml"));
		try {
			Parent root = f.load();
			Stage s = new Stage();
			l = f.getController();
			Scene sc = new Scene(root);
			l.setScene(sc);
			l.getType('P');
			s.setScene(sc);
			s.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	public void student(MouseEvent event) {
		((Stage)scene.getWindow()).close();
		
		FXMLLoader f = new FXMLLoader(getClass().getResource("Login.fxml"));
		try {
			Parent root = f.load();
			Stage s = new Stage();
			l = f.getController();
			Scene sc = new Scene(root);
			l.setScene(sc);
			l.getType('S');
			s.setScene(sc);
			s.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public void initialize(URL arg0, ResourceBundle arg1) {
		time = new Label();
		doVisibleThread();
		
		
	}

}
