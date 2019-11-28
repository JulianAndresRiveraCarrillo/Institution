package model;

public class SocialScience extends Subject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor that instantiates a social science subject
	 * @param name name of the social science subject
	 * @param id id of the subject
	 * @param nextSubject nextSubject attribute that identifies this data structure as a list of subjects
	**/
	public SocialScience(String name, int id, Subject nextSubject) {
		super(name, id, nextSubject);
	}

}
