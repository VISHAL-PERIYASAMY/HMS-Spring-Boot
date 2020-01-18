package global.coda.hospitalmanagement.exception;

/**
 *
 * @author Vishal
 *
 */
public class DoctorNotFoundException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new doctor not found exception.
	 *
	 * @param msg the msg
	 */
	public DoctorNotFoundException(String msg) {
		super(msg);
	}
}
