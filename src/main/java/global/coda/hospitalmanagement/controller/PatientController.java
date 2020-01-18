package global.coda.hospitalmanagement.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import global.coda.hospitalmanagement.constant.ApplicationConstant;
import global.coda.hospitalmanagement.constant.HttpStatusConstant;
import global.coda.hospitalmanagement.delegate.PatientOperationDelegate;
import global.coda.hospitalmanagement.exception.BusinessException;
import global.coda.hospitalmanagement.exception.SystemException;
import global.coda.hospitalmanagement.model.CustomResponseBody;
import global.coda.hospitalmanagement.model.Patient;

/**
 *
 * @author Vishal
 *
 */
@RestController
@RequestMapping("/hms/patient")
public class PatientController {

	/** The logger. */
	private final Logger logger = LogManager.getLogger(PatientController.class);

	/** The patient operation delegate. */
	@Autowired
	private PatientOperationDelegate patientOperationDelegate;

	/**
	 * Read all patient.
	 *
	 * @return the response body
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	@GetMapping("/read")
	public CustomResponseBody<List<Patient>> readAllPatient() throws BusinessException, SystemException {
		logger.traceEntry();
		CustomResponseBody<List<Patient>> response = new CustomResponseBody<List<Patient>>();
		response.setStatus(HttpStatusConstant.OK);
		response.setMessage(patientOperationDelegate.readAllPatient());
		logger.traceExit(response);
		return response;
	}

	/**
	 * Read patient by id.
	 *
	 * @param id the id
	 * @return the response body
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	@GetMapping("/read/{id}")
	public CustomResponseBody<Patient> readPatientById(@PathVariable("id") int id)
			throws BusinessException, SystemException {
		logger.entry(id);
		CustomResponseBody<Patient> response = new CustomResponseBody<Patient>();
		response.setStatus(HttpStatusConstant.OK);
		response.setMessage(patientOperationDelegate.readPatientById(id));
		logger.traceExit(response);
		return response;
	}

	/**
	 * Creates the patient.
	 *
	 * @param patient the patient
	 * @return the response body
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	@PostMapping("/create")
	public CustomResponseBody<Patient> createPatient(@RequestBody Patient patient)
			throws BusinessException, SystemException {
		logger.entry(patient);
		patientOperationDelegate.addPatient(patient);
		CustomResponseBody<Patient> response = new CustomResponseBody<Patient>();
		response.setStatus(HttpStatusConstant.OK);
		response.setMessage(patient);
		logger.traceExit(response);
		return response;
	}

	/**
	 * Delete patient.
	 *
	 * @param patient the patient
	 * @return the response body
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	@DeleteMapping("/delete")
	public CustomResponseBody<String> deletePatient(@RequestBody Patient patient)
			throws BusinessException, SystemException {
		logger.entry(patient);
		patientOperationDelegate.deletePatient(patient);
		CustomResponseBody<String> response = new CustomResponseBody<String>();
		response.setStatus(HttpStatusConstant.OK_NO_CONTENT);
		response.setMessage(ApplicationConstant.USER_DELETED);
		logger.traceExit(response);
		return response;
	}

	/**
	 * Update patient.
	 *
	 * @param patient the patient
	 * @return the response body
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	@PutMapping("/update")
	public CustomResponseBody<String> updatePatient(@RequestBody Patient patient)
			throws BusinessException, SystemException {
		logger.entry(patient);
		patientOperationDelegate.updatePatient(patient);
		CustomResponseBody<String> response = new CustomResponseBody<String>();
		response.setStatus(HttpStatusConstant.OK);
		response.setMessage(ApplicationConstant.UPDATED);
		logger.traceExit(response);
		return response;
	}

}
