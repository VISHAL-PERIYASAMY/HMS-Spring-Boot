package global.coda.hospitalmanagement.constant;

/**
 *
 * @author Vishal
 */
public final class HttpStatusConstant {

	/**
	 * Instantiates a new http status constant.
	 */
	private HttpStatusConstant() {

	}

	public static final int OK = 200;

	public static final int INTERNAL_SERVER_ERROR = 500;

	public static final int FILE_NOT_FOUND = 404;

	public static final int FORBIDDEN = 403;

	public static final int BAD_REQUEST = 400;

	public static final int OK_NO_CONTENT = 204;
}
