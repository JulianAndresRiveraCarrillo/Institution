package model;

import java.util.ArrayList;

public abstract class Subject {
	
	private ArrayList<Double> grades;
	private String name;
	private int id;

	//relaciones
	private Subject nextSubject;

	//metodo constructor
	public Subject(Subject nextSubject) {
		nextSubject = null;
		grades = new ArrayList<Double>();
	}

	//metodos getters y setters
	public Subject getNextSubject() {
		return nextSubject;
	}

	public void setNextSubject(Subject nextSubject) {
		this.nextSubject = nextSubject;
	}

	public ArrayList<Double> getGrade() {
		return grades;
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
	
	public double average() {
		int counter = 0;
		int g = 0;
		for(int i = 0; i<grades.size();i++) {
			g+=grades.get(i);
			counter++;
		}
		double av = g/counter;
		return av;
	}
	
	public void eraseGrade(double grad) {
		boolean done = false;
		for(int i = 0; i<grades.size() || !done;i++) {
			if(grades.get(i)==grad) {
				grades.remove(i);
				done = true;
			}
		}
	}
}
