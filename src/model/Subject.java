package model;

public abstract class Subject {

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
	
	
}
