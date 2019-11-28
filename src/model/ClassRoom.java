package model;

import java.util.ArrayList;

public class ClassRoom {
	
	//atributos
	private int location;
	
	//relaciones
	private ArrayList<Student> studentsInThisClass;

	//metodo constructor
	public ClassRoom(int location) {
		super();
		this.location = location;
	}
	
	//metodos getters y setters
	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public ArrayList<Student> getStudentsInThisClass() {
		return studentsInThisClass;
	}

	
	
	
	
}
