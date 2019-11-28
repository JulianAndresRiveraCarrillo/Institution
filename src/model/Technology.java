package model;

public class Technology extends Subject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor that instantiates a technology subject
	 * @param name name of the technology subject
	 * @param id id of the subject
	 * @param nextSubject nextSubject attribute that identifies this data structure as a list of subjects
	 */
	public Technology(String name, int id, Subject nextSubject) {
		super(name, id, nextSubject);
	}

}
