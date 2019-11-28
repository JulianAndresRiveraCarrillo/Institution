package model;

public class Literature extends Subject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Constructor that instantiates a literature subject
	 * @param name name of the literature subject
	 * @param id id of the subject
	 * @param nextSubject nextSubject attribute that identifies this data structure as a list of subjects
	**/
	public Literature(String name, int id, Subject nextSubject) {
		super(name, id, nextSubject);
	}

}
