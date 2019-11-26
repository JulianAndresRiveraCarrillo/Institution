package model;

import exception.NotFoundException;

public class Student implements SubjectInterface{
	
	//atributos 
	private String firstName;
	private String lastName;
	private int id;
	private int age;
	private int stratum;
	private int phone;
	private int address;
	
	//relaciones 
	private Subject studentSubjects;
	
	//metodo constructor
	public Student(String firstName, String lastName, int id, int age, int stratum, int phone, int address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.age = age;
		this.stratum = stratum;
		this.phone = phone;
		this.address = address;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getStratum() {
		return stratum;
	}

	public void setStratum(int stratum) {
		this.stratum = stratum;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public Subject getStudentSubjects() {
		return studentSubjects;
	}

	public void setStudentSubjects(Subject studentSubjects) {
		this.studentSubjects = studentSubjects;
	}
	
	//searches a Subject
		public Object searchSubject(int id) {
			Subject aux = null;
			if(studentSubjects!=null) {
				aux = studentSubjects;
				boolean end = false;
				
				while(aux.getNextSubject()!=null && end==false) {
					if(aux.getId()==id) {
						end = true;
					}
					else {
						aux = aux.getNextSubject();
					}
				}
			}
			return aux;
		}
	
		public Subject searchPrevSubject(int id) {
			Subject prev = null;
			Subject actual = studentSubjects;
			
			while(actual!=null && actual.getId()!=id) {
				prev = actual;
				actual = actual.getNextSubject();
			}
			return actual !=null?prev:null;
		}
		
		
		//erases a Subject
		public void eraseSubject(int id) {
			Subject aux = studentSubjects;
			try {
				if(aux == null || (aux.getId()!=id&&aux.getNextSubject()==null))
					throw new NotFoundException();
				else if(studentSubjects.getId()==id)
					studentSubjects = studentSubjects.getNextSubject();
				else {
					Subject prev = searchPrevSubject(id);
					if(prev==null)
						throw new NotFoundException();
					prev.setNextSubject(prev.getNextSubject().getNextSubject());
				}
			}
			catch(NotFoundException o) {
				System.out.println(o.getMessage());
			}
		}
		
		
}
