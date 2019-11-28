package model;

public class Math extends Subject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor that instantiates a math subject
	 * @param name name of the math subject
	 * @param id identification number of the math subject
	 * @param nextSubject attribute that identifies this data structure as a list of subjects
	 */
	public Math(String name, int id, Subject nextSubject) {
		super(name, id, nextSubject);
	}

}
