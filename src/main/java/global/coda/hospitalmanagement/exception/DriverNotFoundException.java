package global.coda.hospitalmanagement.exception;

/**
 *
 * @author Vishal
 *
 */
public class DriverNotFoundException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new driver not found exception.
	 *
	 * @param msg the msg
	 */
	public DriverNotFoundException(String msg) {
		super(msg);
	}
}
