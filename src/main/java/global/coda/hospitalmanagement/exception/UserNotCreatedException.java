package global.coda.hospitalmanagement.exception;

/**
 *
 * @author Vishal
 *
 */
public class UserNotCreatedException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new user name already exist exception.
	 *
	 * @param msg the msg
	 */
	public UserNotCreatedException(String msg) {
		super(msg);
	}
}
