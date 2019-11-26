package model;

import java.util.ArrayList;

public class Teacher implements CRUD{
	
	//atributos
	private String firstName;
	private String lastName; 
	private int id;
	
	//relaciones
	private ArrayList<Subject> teacherSubjects;
	private Teacher left;
	private Teacher right;
	
	//metodo constructor
	public Teacher(String firstName, String lastName, int id, Teacher left, Teacher right) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		left = null;
		right = null;
		teacherSubjects = new ArrayList<Subject>();
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

	public ArrayList<Subject> getTeacherSubjects() {
		return teacherSubjects;
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
	@Override
	public void erase(int id) {
		for(int i = 0; i<teacherSubjects.size();i++) {
			if(teacherSubjects.get(i).getId()==id) {
				teacherSubjects.remove(i);
			}
		}
	}

	//searches a Subject
	public Object searchSubject(int id) {
		Subject s = null;
		for(int i = 0; i<teacherSubjects.size();i++) {
			if(teacherSubjects.get(i).getId()==id) {
				s = teacherSubjects.get(i);
			}
		}
		return s;
	}
	
	//searches a Teacher in a recursive way
	@Override
	public Object search(int id) {
		Object x = null;
		if(id==this.id) {
			x = ((Object)this);
		}
		else if(id>this.id) {
			return right.search(id);
		}
		else if(id<this.id) {
			return left.search(id);
		}
		return x;
	}

	//adds a Subject
	public void addSubject(Subject g) {
		teacherSubjects.add(g);
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
	
}
