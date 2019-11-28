package model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Subject implements Serializable{
	
	/**
	 * @author Julian Rivera
	 * @author Alejandra Diaz
	 * Class Subject
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Double> grades;
	private String name;
	private int id;

	//relaciones
	private Subject nextSubject;

	//metodo constructor
	/**
	 * Constructor that instantiates a Subject
	 * @param n name of the subject
	 * @param id identification number of the subject
	 * @param nextSubject attribute that identifies this data structure as a list of subjects
	 */
	public Subject(String n, int id,Subject nextSubject) {
		name = n;
		this.id = id;
		this.nextSubject = nextSubject;
		grades = new ArrayList<Double>();
	}

	//metodos getters y setters
	/**
	 * returns the next subject in the list of subjects
	 * @return the next subject
	 */
	public Subject getNextSubject() {
		return nextSubject;
	}

	/**
	 * Changes the following subject in the list of subjects
	 * @param id new subject
	 */
	public void setNextSubject(Subject nextSubject) {
		this.nextSubject = nextSubject;
	}

	/**
	 * returns the list (arraylist) of grades that a student has in this subject
	 * @return arraylist of grades
	 */
	public ArrayList<Double> getGrade() {
		return grades;
	}

	/**
	 * returns the name of the subject
	 * @return name of the subject
	 */
	public String getName() {
		return name;
	}

	/**
	 * Changes name of the student for the one in the parameters
	 * @param name new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * returns the id of the subject
	 * @return identification number of the subject
	 */
	public int getId() {
		return id;
	}

	/**
	 * Changes id of the subject for the one in the parameters
	 * @param id new identification number
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Calculates the average grade of a student in this subject
	 * @return average grade
	 */
	public double average() {
		int counter = 0;
		int g = 0;
		try{for(int i = 0; i<grades.size();i++) {
			g+=grades.get(i);
			counter++;
		}
		if(counter==0 || (g==0&&counter==0)) {
			throw new ArithmeticException();
		}}catch(ArithmeticException a) {
			a.printStackTrace();
		}
		double av = g/counter;
		return av;
	}
	
	/**
	 * Erases a grade from the arraylist of grades
	 * @param grad grade that's going to be erased
	 */
	public void eraseGrade(double grad) {
		boolean done = false;
		for(int i = 0; i<grades.size() || !done;i++) {
			if(grades.get(i)==grad) {
				grades.remove(i);
				done = true;
			}
		}
	}
	
	/**
	 * Changes a grade of the arraylist of grades
	 * @param p position of the grade to be changed
	 * @param ng new grade
	 */
	public void modifyGrade(int p, double ng) {
		grades.set(p, ng);
	}
}
