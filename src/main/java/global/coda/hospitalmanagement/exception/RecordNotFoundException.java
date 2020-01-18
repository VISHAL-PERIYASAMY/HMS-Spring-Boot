package global.coda.hospitalmanagement.exception;

/**
 *
 * @author Vishal
 *
 */
public class RecordNotFoundException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new record not found exception.
	 *
	 * @param errorMessage the error message
	 */
	public RecordNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
