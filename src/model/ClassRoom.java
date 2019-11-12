package model;

public class ClassRoom {
	
	//atributos
	private int location;
	
	//relaciones
	private Student studentsInThisClassroom;

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

	public Student getStudentsInThisClassroom() {
		return studentsInThisClassroom;
	}

	public void setStudentsInThisClassroom(Student studentsInThisClassroom) {
		this.studentsInThisClassroom = studentsInThisClassroom;
	}
	
	
	
}
