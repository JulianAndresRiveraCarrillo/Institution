package model;

public class Languages extends Subject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor that instantiates a language subject
	 * @param name name of the language subject
	 * @param id id of the subject
	 * @param nextSubject nextSubject attribute that identifies this data structure as a list of subjects
	**/
	public Languages(String name, int id, Subject nextSubject) {
		super(name, id, nextSubject);
	}

}
