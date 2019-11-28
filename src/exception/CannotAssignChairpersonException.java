package exception;

public class CannotAssignChairpersonException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CannotAssignChairpersonException() {
		super("The chairperson that you're trying to add cannot be assigned because it's semester average is under 3");
	}

}
