package model;

public class PlasticArts extends Subject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor that instantiates a plastic arts subject
	 * @param name name of the plastic arts subject
	 * @param id id of the subject
	 * @param nextSubject nextSubject attribute that identifies this data structure as a list of subjects
	**/
	public PlasticArts(String name, int id, Subject nextSubject) {
		super(name, id, nextSubject);
	}

}
