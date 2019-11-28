package exception;

public class GradeInputMismatchException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GradeInputMismatchException() {
		super("Error: the grade must be between 0.0 and 5.0");
	}

}
