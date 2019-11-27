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
	
	public ArrayList<Student> sortStudentsByIDB(){//bubble sort
		
		for(int i=studentsInThisInstitute.size();i>0;i--) {
			for(int j = 0;j<i-1;j++) {
				if(studentsInThisInstitute.get(j).getId()>studentsInThisInstitute.get(j+1).getId()) {
					Student temp = studentsInThisInstitute.get(j);
					studentsInThisInstitute.set(j, studentsInThisInstitute.get(j+1));
					studentsInThisInstitute.set(j+1, temp);
				}
			}
		}
		return studentsInThisInstitute;
	}
	
	public ArrayList<Student> sortStudentsByIdS(){//using selection
		
		for(int i =0;i<studentsInThisInstitute.size();i++) {
			Student minor = studentsInThisInstitute.get(i);
			int which = i;
			for(int j=i+1;j<studentsInThisInstitute.size();j++) {
				if(studentsInThisInstitute.get(j).getId()<minor.getId()) {
					minor = studentsInThisInstitute.get(j);
					 which = j;
				}
			}
			Student temp = studentsInThisInstitute.get(i);
			studentsInThisInstitute.set(i, minor);
			studentsInThisInstitute.set(which, temp); 
		}
		return studentsInThisInstitute;
	}
	
	//searches a student in a binary way
	public Student searchStudentById(int id) {
		Student b = null;
		
		boolean found = false;
		int start = 0;
		int fin = studentsInThisInstitute.size()-1;
		
		while(start<=fin && found==false) {
			int middle = (start+fin)/2;
			
			if(sortClubByID().get(middle).getId()==id) {
				b = sortClubByID().get(middle);
				found = true;
			}
			else if(sortClubByID().get(middle).getId()>id) {
				fin = middle-1;
				
			}
			else if(sortClubByID().get(middle).getId()<id) {
				start = middle+1;
			}
		}
		return b;
	}
	
	public void addGrade(int id,int s, int grade) {
		if(teachersInThisInstitute!=null)
		SubjectInterface.searchSubject(searchTeacher(id).getTeacherSubjects(),id).setGrade(grade);
	}
}
