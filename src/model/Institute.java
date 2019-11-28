package model;
import java.io.EOFException;
/**
 * Final Project of Algorithms and Programming.<br>
 * Julian Rivera, Ingenieria de Sistemas.<br>
 * Alejandra Diaz, Ingenieria Telematica.<br>
 * A program for the general administrative part of an educational institution.<br>
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import exception.CannotAssignChairpersonException;
import exception.GradeInputMismatchException;
import exception.NotFoundException;

/**
 * @author Julian Rivera
 * @author Alejandra Diaz
 * This is the principal class.<br>
 * implements two model interfaces called SubjecInterface and Persistence.<br>
 */
public class Institute implements SubjectInterface, Persistence{
	
	//atributos
	private String name;
	
	//relaciones
	private ArrayList<Student> studentsInThisInstitute;
	
	//relaciones
	private Teacher teachersInThisInstitute;
	
	//relaciones
	private StudentChairPerson chairpersonsInThisInstitute;
	//relaciones
	private GroupDirector groupDirectorsInThisInstitute;
	
	//relations
	private ArrayList<ClassRoom> classrooms;
	
	//constants
	public static String STUDENTS_DATA_PATH="resources/studentsdata.txt";
	//constants
	public static String TEACHERS_DATA_PATH="resources/teachersdata.txt";
	
	//metodo constructor 
	/**
	 * this is the constructor method of the class. Receive a single parameter.<br>
	 * @param name. It is the institute's name.<br>
	 */
	public Institute(String name) {
		super();
		this.name = name;
		studentsInThisInstitute = new ArrayList<Student>();
		classrooms = new ArrayList<ClassRoom>();
	}
	
	//metodos getters y setters
	/**
	 * returns name of the institute
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Changes the name of the institute for the one in the parameters
	 * @param name new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * returns list (arraylist) of the students in the institute
	 * @return arraylist of students
	 */
	public ArrayList<Student> getStudentsInThisInstitute() {
		return studentsInThisInstitute;
	}

	/**
	 * returns tree of the teachers in the institute
	 * @return tree of teachers
	 */
	public Teacher getTeachersInThisInstitute() {
		return teachersInThisInstitute;
	}

	/**
	 * Changes the root of the teachers tree
	 * @param teachersInThisInstitute new root
	 */
	public void setTeachersInThisInstitute(Teacher teachersInThisInstitute) {
		this.teachersInThisInstitute = teachersInThisInstitute;
	}
	
	/**
	 * Method to search a teacher in the tree of teachers
	 * @throws NotFoundException
	 * @param id identification number of the teacher that's being searched
	 * @return teacher searched
	 */
	public Teacher searchTeacher(int id) {
		Teacher t = null;
		try{if(teachersInThisInstitute!=null) {
			t = ((Teacher)teachersInThisInstitute.search(id));
		}
		else if(teachersInThisInstitute==null ||teachersInThisInstitute.search(id)==null) {
			throw new NotFoundException();
		}
		}catch(NotFoundException p) {
			System.out.println(p.getMessage());
		}
		return t;
	}
	
	/**
	 * This method adds a subject to a teacher that teaches it
	 * @param id identification number of the teacher
	 * @param s the subject to add
	 */
	public void addTeacherSubject(int id, Subject s) {
		
		SubjectInterface.addSubjectStart(searchTeacher(id).getTeacherSubjects(), s);
	}
	
	/**
	 * This method adds a teacher to the teachers tree
	 * @param t teacher to add
	 */
	public void addTeacher(Teacher t) {
		if(teachersInThisInstitute==null)
			teachersInThisInstitute = t;
		else
			teachersInThisInstitute.add(((Object)t));
	}
	
	/**
	 * this method adds a group director to the tree of group directors
	 * @param t group director to add
	 */
	public void addGroupDirector(GroupDirector t) {
		if(groupDirectorsInThisInstitute==null)
			groupDirectorsInThisInstitute = t;
		else
			groupDirectorsInThisInstitute.add(((Object)t));
	}
	
	/**
	 * This method sorts the student arraylist with bubble sort method
	 * @return arraylist of students sorted
	 */
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
	
	/**
	 * This method sorts the student arraylist with selection sort method
	 * @return arraylist of students sorted
	 */
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
	
	/**
	 * This method searches a student in the arraylist of students in a binary way
	 * @param id identification numberof the student searched
	 * @return the student searched
	 */
	public Student searchStudentById(int id) {
		Student b = null;
		
		boolean found = false;
		int start = 0;
		int fin = studentsInThisInstitute.size()-1;
		
		while(start<=fin && found==false) {
			int middle = (start+fin)/2;
			
			if(sortStudentsByIDB().get(middle).getId()==id) {
				b = sortStudentsByIDB().get(middle);
				found = true;
			}
			else if(sortStudentsByIDB().get(middle).getId()>id) {
				fin = middle-1;
				
			}
			else if(sortStudentsByIDB().get(middle).getId()<id) {
				start = middle+1;
			}
		}
		return b;
	}
	
	/**
	 * This method searches a chairperson in the list of chairperson
	 * @param id identification number of the chairperson searched
	 * @return the chairperson searched
	 */
	public StudentChairPerson searchChairPerson(int id) {
		StudentChairPerson aux = chairpersonsInThisInstitute;
		boolean found = false;
		try{while(aux!=null || !found) {
			if(aux.getId()==id)
				found = true;
		}
		if(found = false)
			throw new NotFoundException();
		}catch(NotFoundException n) {
			System.out.println(n.getMessage());
		}
		return aux;
	}
	
	/**
	 * This method updates a chairperson's information
	 * @param id identification number of the chairperson searched
	 * @param newName new name 
	 * @param newLastName new last name
	 */
	public void updateChairPerson(int id, String newName, String newLastName) {
		searchChairPerson(id).setFirstName(newName);
		searchChairPerson(id).setLastName(newLastName);
	}
	
	/**
	 * This method sorts the student arraylist with insertion sort method
	 * @return arraylist of students sorted
	 */
	public ArrayList<Student> sortClubByLastNameI(){//by insertion
		
		for(int i = 1;i<studentsInThisInstitute.size();i++) {
			for(int j = i;j>0 && studentsInThisInstitute.get(j-1).getLastName().compareTo(studentsInThisInstitute.get(j).getLastName())<0;j--) {
				Student temp = studentsInThisInstitute.get(j);
				studentsInThisInstitute.set(j, studentsInThisInstitute.get(j-1));
				studentsInThisInstitute.set(j-1, temp);
			}
		}
	return studentsInThisInstitute;
	}
	
	/**
	 * This method sorts the student arraylist with selection sort method
	 * @return arraylist of students sorted
	 */
public ArrayList<Student> sortClubByLastNameS(){//using selection
		
		for(int i =0;i<studentsInThisInstitute.size();i++) {
			Student minor = studentsInThisInstitute.get(i);
			int which = i;
			for(int j=i+1;j<studentsInThisInstitute.size();j++) {
				if(studentsInThisInstitute.get(j).getLastName().compareTo(minor.getLastName())<0) {
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
	
/**
 * This method sorts the student arraylist with insertion sort method
 * @return arraylist of students sorted
 */
public ArrayList<Student> sortStudentsByFirstNameI(){//by insertion
		
		for(int i = 1;i<studentsInThisInstitute.size();i++) {
			for(int j = i;j>0 && studentsInThisInstitute.get(j-1).getFirstName().compareTo(studentsInThisInstitute.get(j).getFirstName())<0;j--) {
				Student temp = studentsInThisInstitute.get(j);
				studentsInThisInstitute.set(j, studentsInThisInstitute.get(j-1));
				studentsInThisInstitute.set(j-1, temp);
			}
		}
	return studentsInThisInstitute;
	}

/**
 * This method sorts the student arraylist with bubble sort method
 * @return arraylist of students sorted
 */
public ArrayList<Student> sortStudentByFirstNameB(){//by bubble
	
	for(int i=studentsInThisInstitute.size();i>0;i--) {
		for(int j = 0;j<i-1;j++) {
			if(studentsInThisInstitute.get(j).getFirstName().compareTo(studentsInThisInstitute.get(j+1).getFirstName())>0){
				Student temp = studentsInThisInstitute.get(j);
				studentsInThisInstitute.set(j, studentsInThisInstitute.get(j+1));
				studentsInThisInstitute.set(j+1, temp);
			}
		}
	}
	return studentsInThisInstitute;
}
	
/**
 * This method searches a student in the arraylist of students in a binary way
 * @param n first name the student searched
 * @return the student searched
 */
		public Student searchStudentByFirstName(String n) {
			Student b = null;
			
			boolean found = false;
			int start = 0;
			int fin = studentsInThisInstitute.size()-1;
			
			while(start<=fin && found==false) {
				int middle = (start+fin)/2;
				
				if(sortStudentsByFirstNameI().get(middle).getFirstName().equals(n)) {
					b = sortStudentsByFirstNameI().get(middle);
					found = true;
				}
				else if(sortStudentsByFirstNameI().get(middle).getFirstName().compareTo(n)<0) {
					fin = middle-1;
					
				}
				else if(sortStudentsByFirstNameI().get(middle).getFirstName().compareTo(n)>0) {
					start = middle+1;
				}
			}
			return b;
		}
	
		/**
		 * This method adds a grade to a subject coursed by a student
		 * @throws GradeInputMismatchException
		 * @param id identification number of the student
		 * @param s identification number of the subject
		 * @param grade grade to be added
		 */
	public void addGrade(int id,int s, double grade) {
		try {
			if(grade<0 || grade>5)
				throw new GradeInputMismatchException();
		}catch(GradeInputMismatchException g) {
			System.out.println(g.getMessage());
		}
		if(teachersInThisInstitute!=null)
		SubjectInterface.searchSubject(searchStudentById(id).getStudentSubjects(),s).getGrade().add(grade);
	}
	
	/**
	 * This is an auxiliary method to eraseTeacher
	 * @param toChange teacher that's going to be changed
	 * @return change teacher of the teacher that's going to be changed
	 */
	public Teacher getTeacherChange(Teacher toChange) {
		Teacher changeFather = toChange;
		Teacher change = toChange;
		Teacher aux = toChange.getRight();
		while(aux!=null) {
			changeFather = change;
			change = aux;
			aux = aux.getLeft();
		}
		if(change!=toChange.getRight()) {
			changeFather.setLeft(change.getRight());
			change.setRight(toChange.getRight());
		}
		return change;
	}
	
	/**
	 * This method erases a teacher from the teachers tree
	 * @param id identification number of the teacher that's going to be erased
	 */
	public void eraseTeacher(int id) {
		if(teachersInThisInstitute!=null) {
			if(searchTeacher(id)!=null) {
				Teacher aux = teachersInThisInstitute;
				Teacher father = teachersInThisInstitute;
				boolean isLeftSon = true;
				while(aux.getId()!=id) {
					father = aux;
					if(aux.getId()>id) {
						isLeftSon = true;
						aux = aux.getLeft();
					}
					else {
						isLeftSon=false;
						aux = aux.getRight();
					}
				}
				
				if(aux.getRight()==null && aux.getLeft()==null) {//if aux is root or leaf
					if(aux == teachersInThisInstitute) {
						teachersInThisInstitute = null;
					}
					else if(isLeftSon==true){
						father.setLeft(null);
					}
					else
						father.setRight(null);
				}
				
				else if(aux.getRight()!=null && aux.getLeft()==null) {
					if(aux == teachersInThisInstitute) {
						teachersInThisInstitute = aux.getRight();
					}
					else if(isLeftSon==true){
						father.setLeft(aux.getRight());
					}
					else
						father.setRight(aux.getRight());
				}
				
				else if(aux.getLeft()!=null && aux.getRight()==null) {
					if(aux == teachersInThisInstitute) {
						teachersInThisInstitute = aux.getLeft();
					}
					else if(isLeftSon==true){
						father.setLeft(aux.getLeft());
					}
					else
						father.setRight(aux.getLeft());
				}
				else {//when aux has both sons
					Teacher change = getTeacherChange(aux);
					if(aux == teachersInThisInstitute)
						teachersInThisInstitute = change;
					else if(isLeftSon==true){
						father.setLeft(change);
					}
					else
						father.setRight(change);
					change.setLeft(aux.getLeft());
				}
			}
		}
	}

	/**
	 * This method calculates the average grade of a subject coursed by a student.
	 * @param student identification number of the student
	 * @param subject identification number of the subject
	 * @return average grade of the subject
	 */
	public double getAverageSubject(int student, int subject) {
		return SubjectInterface.searchSubject(searchStudentById(student).getStudentSubjects(),subject).average();
	}

	/**
	 * This method calculates the average grade of a the semester coursed by a student.
	 * @param student identification number of the student
	 * @return average grade of the semester of the student
	 */
	public double getAverageSemester(int student) {
		return searchStudentById(student).semesterAverage();
	}

	/**
	 * This method returns the list of chairpersons
	 * @return list of chairpersons
	 */
	public StudentChairPerson getChaipersonsInThisInstitute() {
		return chairpersonsInThisInstitute;
	}
	
	/**
	 * This method adds a chairperson to the list of chairpersons
	 * @param cp chairperson that's that going to be added
	 * @throws CannotAssignChairpersonException
	 */
	public void addChairPerson(StudentChairPerson cp) throws CannotAssignChairpersonException {
		try{if(cp.semesterAverage()<3) {
			StudentChairPerson aux = chairpersonsInThisInstitute;
			if(aux == null)
				chairpersonsInThisInstitute = cp;
			else {
				while(aux.getNextChairPerson()!=null)
					aux = aux.getNextChairPerson();
			}
			aux.setNextChairPerson(cp);
		}
		else
			throw new CannotAssignChairpersonException();
	}catch(CannotAssignChairpersonException c) {
		System.out.println(c.getMessage());
	}}

	/**
	 * Method that returns the arraylist of classrooms
	 * @return classrooms
	 */
	public ArrayList<ClassRoom> getClassrooms() {
		return classrooms;
	}
	
	/**
	 * This method erases a student from the arraylist of students
	 * @param c identification number of the student that's going to be erased
	 * @throws NotFoundException
	 */
	public void eraseStudent(int c) throws NotFoundException {
		boolean x = false;
		try{for(int i = 0;i<studentsInThisInstitute.size() || !x;i++) {
			if(studentsInThisInstitute.get(i).getId()==c) {
				studentsInThisInstitute.remove(i);
				x = true;
			}
		}
			if(x==false) {
				throw new NotFoundException();
			}
		}
		catch(NotFoundException n) {
			System.out.println(n.getMessage());
		}
	}
	
	/**
	 * This method adds a student to the arraylist of students
	 * @param s student that's going to be added
	 */
	public void addStudent(Student s) {
		studentsInThisInstitute.add(s);
	}
	
	/**
	 * This method erases a grade of a subject coursed by a student.
	 * @param id identification number of the student
	 * @param subject identification number of the subject
	 * @param grade grade that's going to be erased
	 */
	public void eraseGrade(int id, int subject, double grade) {
		try {
			if(grade<0 || grade>5)
				throw new GradeInputMismatchException();
		}catch(GradeInputMismatchException g) {
			System.out.println(g.getMessage());
		}
		SubjectInterface.searchSubject(searchStudentById(id).getStudentSubjects(), subject).eraseGrade(grade);
	}
	
	/**
	 * This method modifies a grade of a subject coursed by a student
	 * @param student identification number of the student
	 * @param subject identification number of the subject
	 * @param p position of the grade
	 * @param grade new grade
	 */
	public void modifyGrade(int student, int subject,int p, double grade) {
		SubjectInterface.searchSubject(searchStudentById(student).getStudentSubjects(), subject).modifyGrade(p, grade);
	}

	/**
	 * This method desearializes the elements of the institute
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Override
	public void readObject() throws FileNotFoundException, IOException {
		File f = new File(STUDENTS_DATA_PATH);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(studentsInThisInstitute);
		oos.close();

		File f2 = new File(TEACHERS_DATA_PATH);
		ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(f2));
		oos2.writeObject(teachersInThisInstitute);
		oos2.close();
	}
	
	/**
	 * This method serializes the elements in the institute
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws EOFException
	 */
	@Override
	public void writeObject() throws FileNotFoundException, IOException, ClassNotFoundException, EOFException{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(STUDENTS_DATA_PATH));
		studentsInThisInstitute = (ArrayList<Student>)ois.readObject();
		ois.close();
		
		ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(TEACHERS_DATA_PATH));
		teachersInThisInstitute = (Teacher) ois2.readObject();
		ois2.close();
	}
}
