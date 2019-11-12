package model;

public class Teacher {
	
	//atributos
	private String firstName;
	private String lastName; 
	private int id;
	
	//relaciones
	private Subject teacherSubjects;
	private Teacher left;
	private Teacher right;
	
	//metodo constructor
	public Teacher(String firstName, String lastName, int id, Teacher left, Teacher right) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		left = null;
		right = null;
	}

	//metodos getters y setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Subject getTeacherSubjects() {
		return teacherSubjects;
	}

	public void setTeacherSubjects(Subject teacherSubjects) {
		this.teacherSubjects = teacherSubjects;
	}

	public Teacher getLeft() {
		return left;
	}

	public void setLeft(Teacher left) {
		this.left = left;
	}

	public Teacher getRight() {
		return right;
	}

	public void setRight(Teacher right) {
		this.right = right;
	}
	
	
	
	
}
