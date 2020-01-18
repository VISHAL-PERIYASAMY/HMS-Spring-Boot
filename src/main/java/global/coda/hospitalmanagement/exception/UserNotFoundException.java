package global.coda.hospitalmanagement.exception;

/**
 *
 * @author Vishal
 *
 */
public class UserNotFoundException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new user not found exception.
	 *
	 * @param errorMessage the error message
	 */
	public UserNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
