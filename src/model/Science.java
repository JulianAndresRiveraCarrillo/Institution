package model;

public class Science extends Subject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor that instantiates a science subject
	 * @param name name of the science subject
	 * @param id id of the subject
	 * @param nextSubject nextSubject attribute that identifies this data structure as a list of subjects
	**/
	public Science(String name, int id, Subject nextSubject) {
		super(name, id, nextSubject);
	}

}
