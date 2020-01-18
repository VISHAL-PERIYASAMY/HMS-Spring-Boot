package global.coda.hospitalmanagement.exception;

/**
 *
 * @author Vishal
 *
 */
public class BusinessException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new business exception.
	 *
	 * @param msg the msg
	 */
	public BusinessException(String msg) {
		super(msg);
	}
}
