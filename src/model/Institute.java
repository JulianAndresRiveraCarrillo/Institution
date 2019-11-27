package model;

import java.util.ArrayList;

import exception.NotFoundException;

public class Institute implements SubjectInterface{
	
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
			throw new NotFoundException();
		}
		}catch(NotFoundException p) {
			System.out.println(p.getMessage());
		}
		return t;
	}
	
	public void addTeacherSubject(int id, Subject s) {
		
		SubjectInterface.addSubjectEnd(searchTeacher(id).getTeacherSubjects(), s);
	}
	
	public void addTeacher(Teacher t) {
		if(teachersInThisInstitute==null)
			teachersInThisInstitute = t;
		else
			teachersInThisInstitute.add(((Object)t));
	}
	
	//searches a student in a binary way
	public Student searchStudentById(int id) {
		
	}
	
	public void addGrade(int id,int s, int grade) {
		searchStudentById(id).getStudentSubjects().searchSubject(s).setGrade(grade);
	}
}
