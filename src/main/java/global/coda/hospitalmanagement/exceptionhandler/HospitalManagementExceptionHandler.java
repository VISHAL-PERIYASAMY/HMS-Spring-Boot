package global.coda.hospitalmanagement.exceptionhandler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import global.coda.hospitalmanagement.constant.ApplicationConstant;
import global.coda.hospitalmanagement.constant.HttpStatusConstant;
import global.coda.hospitalmanagement.exception.BusinessException;
import global.coda.hospitalmanagement.exception.SystemException;
import global.coda.hospitalmanagement.model.CustomResponseBody;

/**
 *
 * @author Vishal
 *
 */
@ControllerAdvice
public class HospitalManagementExceptionHandler {
	/** The logger. */
	private final Logger logger = LogManager.getLogger(HospitalManagementExceptionHandler.class);

	/**
	 * Business exception.
	 *
	 * @param error the error
	 * @return the response entity
	 */
	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<CustomResponseBody<String>> businessException(BusinessException error) {
		logger.traceEntry();
		logger.error(error.getMessage());
		CustomResponseBody<String> response = new CustomResponseBody<String>();
		response.setStatus(HttpStatusConstant.BAD_REQUEST);
		response.setMessage(error.getMessage());
		logger.traceExit();
		return new ResponseEntity<CustomResponseBody<String>>(response, HttpStatus.NOT_FOUND);
	}

	/**
	 * System exception.
	 *
	 * @param error the error
	 * @return the response entity
	 */
	@ExceptionHandler(value = SystemException.class)
	public ResponseEntity<CustomResponseBody<String>> systemException(SystemException error) {
		logger.traceEntry();
		logger.error(error.getMessage());
		CustomResponseBody<String> response = new CustomResponseBody<String>();
		response.setStatus(HttpStatusConstant.INTERNAL_SERVER_ERROR);
		response.setMessage(ApplicationConstant.SERVER_ERROR);
		logger.traceExit();
		return new ResponseEntity<CustomResponseBody<String>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
