package controller;

import java.awt.JobAttributes;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import exception.NotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.GroupDirector;
import model.Institute;
import model.Student;
import thread.ClockThread;
import thread.VisibleThread;

public class Director implements Initializable{
	
	int op = 0;
	
	private ClockThread c;
	private VisibleThread v; 
	
	@FXML
	private ImageView carita;
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
	
	private Institute inst;

	private Scene scene;
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		doVisibleThread();
	}
	
	@FXML
	void Teacher(MouseEvent evet) {
		op = 1;
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
		
		Stage stage = new Stage();
		replaceSceneContent(stage);
		
	}

	@FXML
	void groupDirector(MouseEvent evet) {
		op = 2;
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
		
		Stage stage = new Stage();
		replaceSceneContent(stage);
		
	}
	
	@FXML
	void student(MouseEvent evet) {
		op = 3;
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
		
		Stage stage = new Stage();
		replaceSceneContent(stage);
		
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
	
	private void replaceSceneContent(Stage st) {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root);
		
		Button agregar = new Button();
		agregar.setText("AGREGAR");
		Button eliminar = new Button();
		eliminar.setText("ELIMINAR");
		agregar.addEventHandler(MouseEvent.MOUSE_CLICKED,(e)->{switch (op) {
		case 1:
			String FirstName = JOptionPane.showInputDialog("Ingrese el nombre del profesor: ");
			String LastName = JOptionPane.showInputDialog("Ingrese el apellido del profesor: ");
			int id = (int)(Math.random()*((100-1)+1))+1;
			model.Teacher t = new model.Teacher(FirstName, LastName, id, null, null);
			inst.addTeacher(t);
			break;

		case 2:
			String firstName = JOptionPane.showInputDialog("Escribe el nombre del nuevo director de grupo: ");
			String lastName = JOptionPane.showInputDialog("Escribe el apellido del director de grupo: ");
			int Id = (int)(Math.random()*((100-1)+1))+1;
			String tx = JOptionPane.showInputDialog("Ingresa el salon: ");
			int s = Integer.parseInt(tx);
			GroupDirector gp = new GroupDirector(firstName, lastName, Id, null, null, s);
			inst.addGroupDirector(gp);
			break;
			
		case 3:
			String name = JOptionPane.showInputDialog("Escribe el nombre del nuevo director de grupo: ");
			String last = JOptionPane.showInputDialog("Escribe el apellido del director de grupo: ");
			int ID = (int)(Math.random()*((100-1)+1))+1;
			String txt = JOptionPane.showInputDialog("Ingresa la edad: ");
			int age = Integer.parseInt(txt);
			String text = JOptionPane.showInputDialog("Ingresa el estrato: ");
			int stratum = Integer.parseInt(text);
			String phone = JOptionPane.showInputDialog("Ingrese el telefono de contacto: ");
			String address = JOptionPane.showInputDialog("Escribe la direccion del domicilio del estudiante: ");
			Student stdent = new Student(name, last, ID, age, stratum, phone, address);
			inst.addStudent(stdent);
			break;
			
		default:
			break;
		}});
		
		eliminar.addEventHandler(MouseEvent.MOUSE_CLICKED,(e)->{switch (op) {
		case 1:
			String text = JOptionPane.showInputDialog("Ingrese el id del profesor a despedir: ");
			int id = Integer.parseInt(text);
			inst.eraseTeacher(id);
			break;

			
		case 3:
			String txt = JOptionPane.showInputDialog("Ingrese el id del estudiante a expulsar");
			int ID = Integer.parseInt(txt);
			try {
				inst.eraseStudent(ID);
			} catch (NotFoundException e1) {
				e1.printStackTrace();
			}
			break;
			
		default:
			break;
		}});
		VBox vbox = new VBox();
		vbox.getChildren().add(agregar);
		vbox.getChildren().add(eliminar);
		
		root.getChildren().add(vbox);
		st.setScene(scene);
		st.setMaximized(true);
		st.show();
	}
		
}
