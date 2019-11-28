package model;

public class StudentChairPerson extends Student{
	
	//relaciones
	private StudentChairPerson nextChairPerson;
	
	//metodo constructor
	public StudentChairPerson(String firstName, String lastName, int id, int age, int stratum, String phone, String address) {
		super(firstName, lastName, id, age, stratum, phone, address);
		nextChairPerson = null;
	}

	//metodos getters y setters
	public StudentChairPerson getNextChairPerson() {
		return nextChairPerson;
	}

	public void setNextChairPerson(StudentChairPerson nextChairPerson) {
		this.nextChairPerson = nextChairPerson;
	}
	

}
