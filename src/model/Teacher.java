package model;


import exception.NotFoundException;

public class Teacher implements SubjectInterface,CRUD{
	
	//atributos
	private String firstName;
	private String lastName; 
	private int id;
	
	//relaciones
	private Subject teacherSubjects;
	private Teacher left;
	private Teacher right;
	
	//metodo constructor
	public Teacher(String firstName, String lastName, int id, Teacher left, Teacher right) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		left = null;
		right = null;
	}

	//metodos getters y setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Subject getTeacherSubjects() {
		return teacherSubjects;
	}

	public void setTeacherSubjects(Subject teacherSubjects) {
		this.teacherSubjects = teacherSubjects;
	}

	public Teacher getLeft() {
		return left;
	}

	public void setLeft(Teacher left) {
		this.left = left;
	}

	public Teacher getRight() {
		return right;
	}

	public void setRight(Teacher right) {
		this.right = right;
	}
	
	
	//erases a Subject
	public void eraseSubject(int id) {
		
	}

	@Override
	public Object search(int id) {
		Teacher o = null;
		try{if(id==this.id) 
			o = this;
		if(id>this.id && right==null) {
			throw new NotFoundException();
		}
		if(id<this.id && left==null) {
			throw new NotFoundException();
		}
		if(id>this.id && right!=null) {
			right.search(id);
		}
		if(id<this.id && left!=null) {
			left.search(id);
		}
		}catch(NotFoundException n) {
			System.out.println(n.getMessage());
		}
		return o;
	}	
	
	//adds a teacher in a recursive way
	@Override
	public void add(Object o) {
		Teacher t = ((Teacher)o);
		if(t.getId()>this.id && right==null) {
			right = t;
		}
		if(t.getId()<this.id && left==null) {
			left = t;
		}
		if(t.getId()>this.id && right!=null) {
			right.add(o);
		}
		if(t.getId()<this.id && left!=null) {
			left.add(o);
		}
	}
	

	
	//
	//
	//Nota: falta este metodo que borra un profesor
	//
	@Override
	public void erase(int id) {
		
	}
}
