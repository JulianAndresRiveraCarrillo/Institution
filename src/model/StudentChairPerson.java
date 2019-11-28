package model;

public class StudentChairPerson extends Student{
	
	//relaciones
	private StudentChairPerson nextChairPerson;
	
	//metodo constructor
	/**
	 * Constructor that instantiates a chairperson
	 * @param firstName first name of the chairperson
	 * @param lastName last name of the chairperson
	 * @param id identification number of the chairperson
	 * @param age age of the chairperson
	 * @param stratum economic stratum of the chairperson
	 * @param phone phone number of the chairperson
	 * @param address direction where the chairperson lives
	 */
	public StudentChairPerson(String firstName, String lastName, int id, int age, int stratum, String phone, String address) {
		super(firstName, lastName, id, age, stratum, phone, address);
		nextChairPerson = null;
	}

	//metodos getters y setters
		/**
		 * returns the next chairperson in the list of chairpersons
		 * @return the next chairperson
		 */
	public StudentChairPerson getNextChairPerson() {
		return nextChairPerson;
	}

	/**
	 * Changes the following chairperson in the list of chairpersons
	 * @param nextChairPerson new chairPerson
	 */
		public void setNextChairPerson(StudentChairPerson nextChairPerson) {
			this.nextChairPerson = nextChairPerson;
		}

	
	

}
