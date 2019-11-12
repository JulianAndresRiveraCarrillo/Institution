package model;

public class Institute {
	
	//atributos
	private String name;
	
	//relaciones
	private Student studentsInThisInstitute;
	
	//metodo constructor 
	public Institute(String name) {
		super();
		this.name = name;
	}
	
	//metodos getters y setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student getStudentsInThisInstitute() {
		return studentsInThisInstitute;
	}

	public void setStudentsInThisInstitute(Student studentsInThisInstitute) {
		this.studentsInThisInstitute = studentsInThisInstitute;
	}
	
	
}
