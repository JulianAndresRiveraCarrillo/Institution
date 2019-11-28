package model;


import java.io.Serializable;

import exception.NotFoundException;

public class Teacher implements SubjectInterface,CRUD,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//atributos
	private String firstName;
	private String lastName; 
	private int id;
	
	//relaciones
	private Subject teacherSubjects;
	private Teacher left;
	private Teacher right;
	
	//metodo constructor
	/**
	 * Constructor that instantiates a teacher
	 * @param firstName the first name of the teacher
	 * @param lastName the last name of the teacher
	 * @param id the identification number of the teacher
	 * @param left left attribute that identifies this data structure as a binary tree
	 * @param right right attribute that identifies this data structure as a binary tree
	 **/
	public Teacher(String firstName, String lastName, int id, Teacher left, Teacher right) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.left = left;
		this.right = right;
	}

	//metodos getters y setters
	/**
	 * returns first name of the teacher
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Changes the first name of the teacher for the one in the parameters
	 * @param firstName new name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * returns last name of the teacher
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Changes the last name of the teacher for the one in the parameters
	 * @param lastName new name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * returns the identification number of the teacher
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Changes the identification number of the teacher for the one in the parameters
	 * @param id new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * returns the list of subjects that the teacher teaches
	 * @return list of subjects
	 */
	public Subject getTeacherSubjects() {
		return teacherSubjects;
	}

	/**
	 * returns the teacher on the left branch
	 * @return teacher
	 */
	public Teacher getLeft() {
		return left;
	}

	/**
	 * Changes teacher on the left branch for the one in the parameters
	 * @param left new teacher
	 */
	public void setLeft(Teacher left) {
		this.left = left;
	}

	/**
	 * returns the teacher on the right branch
	 * @return teacher
	 */
	public Teacher getRight() {
		return right;
	}

	/**
	 * Changes teacher on the right branch for the one in the parameters
	 * @param right new teacher
	 */
	public void setRight(Teacher right) {
		this.right = right;
	}
	
	/**
	 * This is a recursive method to search a teacher
	 * @param id the id of the teacher searched
	 */
	@Override
	public Object search(int id) {
		Teacher o = null;
		try{if(id==this.id) 
			o = this;
		else if(id>this.id && right==null) {
			throw new NotFoundException();
		}
		else if(id<this.id && left==null) {
			throw new NotFoundException();
		}
		else if(id>this.id && right!=null) {
			right.search(id);
		}
		else if(id<this.id && left!=null) {
			left.search(id);
		}
		}catch(NotFoundException n) {
			System.out.println(n.getMessage());
		}
		return o;
	}	
	
	/**
	 * This is a recursive method to add a teacher
	 * @param o new teacher to add
	 */
	@Override
	public void add(Object o) {
		Teacher t = ((Teacher)o);
		if(t.getId()>this.id && right==null) {
			right = t;
		}
		else if(t.getId()<this.id && left==null) {
			left = t;
		}
		else if(t.getId()>this.id && right!=null) {
			right.add(o);
		}
		else if(t.getId()<this.id && left!=null) {
			left.add(o);
		}
	}
	


	
	
	

	@Override
	public void erase(int id) {
		
	}
	
	
}
