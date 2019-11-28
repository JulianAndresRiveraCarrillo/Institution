package model;

import java.io.Serializable;

import exception.NotFoundException;

/** 
 *@author: Julian Rivera
 *@author: Alejandra Diaz
 *Class Student
 */
public class Student implements SubjectInterface,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//atributos 
	private String firstName;
	private String lastName;
	private int id;
	private int age;
	private int stratum;
	private String phone;
	private String address;
	
	//relaciones 
	private Subject studentSubjects;
	
	/**
	 * Constructor that instantiates a Student
	 * @param First name of the student
	 * @param lastName Last name of the student
	 * @param id Identification number of the student
	 * @param age Age of the student
	 * @param stratum Economic stratum of the student
	 * @param phone Phone number of the student
	 * @param address Direction where the student lives
	 */
	public Student(String firstName, String lastName, int id, int age, int stratum, String phone, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.age = age;
		this.stratum = stratum;
		this.phone = phone;
		this.address = address;
	}

	//metodos getters y setters
	/**
	 * returns the name of the student
	 * @return first name of the student
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Changes the first name of the student for the one in the parameters
	 * @param firstName new name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * returns the last name of the student
	 * @return last name of the student
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Changes the last name of the student for the one in the parameters
	 * @param lastName new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * returns the id of the student
	 * @return identification number of the student
	 */
	public int getId() {
		return id;
	}

	/**
	 * Changes id of the student for the one in the parameters
	 * @param id new identification number
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * returns the age of the student
	 * @return age of the student
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Changes the age of the student for the one in the parameters
	 * @param age new age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * returns the stratum of the student
	 * @return economic stratum of the student
	 */
	public int getStratum() {
		return stratum;
	}

	/**
	 * Changes the stratum of the student for the one in the parameters
	 * @param stratum new economic stratum
	 */
	public void setStratum(int stratum) {
		this.stratum = stratum;
	}

	/**
	 * returns the phone of the student
	 * @return phone number of the student
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Changes the phone of the student for the one in the parameters
	 * @param phone new phone number
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * returns the address of the student
	 * @return address of the student
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Changes the direction of the student for the one in the parameters
	 * @param address new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * returns the list of subjects that the student is studying
	 * @return list of subjects
	 */
	public Subject getStudentSubjects() {
		return studentSubjects;
	}

	/**
	 * Calculates the average grade of the semester
	 * @return average grade
	 */
	public double semesterAverage() {
		int c = 0;
		int grades = 0;
		int a = 0;
		if(studentSubjects!=null) {
		Subject aux = studentSubjects;
		while(aux !=null) {
			grades += aux.average();
			c++;
			aux = aux.getNextSubject();
		}try{
			a = grades/c;
		}catch(ArithmeticException ae) {
			ae.printStackTrace();
		}
		}
		return a;
	}
	
	/**
	 * Searches a subject in the list of subjects of the student
	 * @param code code of the subject searched
	 * @return subject searched
	 */
	public Subject searchSubject(int code) {
		return SubjectInterface.searchSubject(studentSubjects, code);
	}
}
