package model;

public abstract class Subject {
	
	private double grade;
	private String name;
	private int id;

	//relaciones
	private Subject nextSubject;

	//metodo constructor
	public Subject(Subject nextSubject) {
		nextSubject = null;
	}

	//metodos getters y setters
	public Subject getNextSubject() {
		return nextSubject;
	}

	public void setNextSubject(Subject nextSubject) {
		this.nextSubject = nextSubject;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
