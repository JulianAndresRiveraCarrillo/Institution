package model;

import java.util.ArrayList;

/**
 * @author Julian Rivera
 * @author Alejandra Diaz
 * Class ClassRoom
 *
 */
public class ClassRoom {
	
	//atributos
	private int location;
	
	//relaciones
	private ArrayList<Student> studentsInThisClass;

	//metodo constructor
	/**
	 * Constructor that instantiates a classroom
	 * @param location physical location of the classroom
	 */
	public ClassRoom(int location) {
		super();
		this.location = location;
	}
	
	//metodos getters y setters
	/**
	 * returns the location of the classroom
	 * @return location of the classroom
	 */
	public int getLocation() {
		return location;
	}

	/**
	 * Changes location of the classroom for the one in the parameters
	 * @param name new location
	 */
	public void setLocation(int location) {
		this.location = location;
	}

	/**
	 * returns list (arraylist) of students in this classroom
	 * @return arraylist of students
	 */
	public ArrayList<Student> getStudentsInThisClass() {
		return studentsInThisClass;
	}

	
	
	
	
}
