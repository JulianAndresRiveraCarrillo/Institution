package exception;

public class PersonNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonNotFoundException() {
		super("The person that you were searching couldn't be found");
	}

}
