package model;

import java.util.ArrayList;

import exception.PersonNotFoundException;

public class Institute {
	
	//atributos
	private String name;
	
	//relaciones
	private ArrayList<Student> studentsInThisInstitute;
	
	//relaciones
	private Teacher teachersInThisInstitute;
	
	//metodo constructor 
	public Institute(String name) {
		super();
		this.name = name;
		studentsInThisInstitute = new ArrayList<Student>();
	}
	
	//metodos getters y setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Student> getStudentsInThisInstitute() {
		return studentsInThisInstitute;
	}

	public Teacher getTeachersInThisInstitute() {
		return teachersInThisInstitute;
	}

	public void setTeachersInThisInstitute(Teacher teachersInThisInstitute) {
		this.teachersInThisInstitute = teachersInThisInstitute;
	}
	
	public Teacher searchTeacher(int id) {
		Teacher t = null;
		try{if(teachersInThisInstitute!=null) {
			t = ((Teacher)teachersInThisInstitute.search(id));
		}
		else if(teachersInThisInstitute.search(id)==null) {
			throw new PersonNotFoundException();
		}
		}catch(PersonNotFoundException p) {
			System.out.println(p.getMessage());
		}
		return t;
	}
	
	public void addTeacherSubject(int id, Subject s) {
		searchTeacher(id).addSubject(s);
	}
	
	public void addTeacher(Teacher t) {
		if(teachersInThisInstitute==null)
			teachersInThisInstitute = t;
		else
			teachersInThisInstitute.add(((Object)t));
	}
}
