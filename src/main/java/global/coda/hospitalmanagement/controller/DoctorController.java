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
import global.coda.hospitalmanagement.delegate.DoctorOperationDelegate;
import global.coda.hospitalmanagement.exception.BusinessException;
import global.coda.hospitalmanagement.exception.SystemException;
import global.coda.hospitalmanagement.model.CustomResponseBody;
import global.coda.hospitalmanagement.model.Doctor;
import global.coda.hospitalmanagement.model.DoctorPatientMapping;

/**
 *
 * @author Vishal
 *
 */
@RestController
@RequestMapping("/hms/doctor")
public class DoctorController {

	/** The logger. */
	private final Logger logger = LogManager.getLogger(DoctorController.class);

	/** The doctor operation delegate. */
	@Autowired
	private DoctorOperationDelegate doctorOperationDelegate;

	/**
	 * Read all doctor.
	 *
	 * @return the custom response body
	 * @throws BusinessException the business exception
	 * @throws SystemException the system exception
	 */
	@GetMapping("/read")
	public CustomResponseBody<List<Doctor>> readAllDoctor() throws BusinessException, SystemException {
		logger.traceEntry();
		CustomResponseBody<List<Doctor>> response = new CustomResponseBody<List<Doctor>>();
		response.setStatus(HttpStatusConstant.OK);
		response.setMessage(doctorOperationDelegate.readAllDoctor());
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
	public CustomResponseBody<Doctor> readDoctorById(@PathVariable("id") int id)
			throws BusinessException, SystemException {
		logger.entry(id);
		CustomResponseBody<Doctor> response = new CustomResponseBody<Doctor>();
		response.setStatus(HttpStatusConstant.OK);
		response.setMessage(doctorOperationDelegate.readDoctorById(id));
		logger.traceExit(response);
		return response;
	}

	/**
	 * Delete patient.
	 *
	 * @param doctor the doctor
	 * @return the custom response body
	 * @throws BusinessException the business exception
	 * @throws SystemException the system exception
	 */
	@DeleteMapping("/delete")
	public CustomResponseBody<String> deletePatient(@RequestBody Doctor doctor)
			throws BusinessException, SystemException {
		logger.entry(doctor);
		doctorOperationDelegate.deleteDoctor(doctor);
		CustomResponseBody<String> response = new CustomResponseBody<String>();
		response.setStatus(HttpStatusConstant.OK_NO_CONTENT);
		response.setMessage(ApplicationConstant.USER_DELETED);
		logger.traceExit(response);
		return response;
	}

	/**
	 * Update doctor.
	 *
	 * @param doctor the doctor
	 * @return the custom response body
	 * @throws BusinessException the business exception
	 * @throws SystemException the system exception
	 */
	@PutMapping("/update")
	public CustomResponseBody<String> updateDoctor(@RequestBody Doctor doctor)
			throws BusinessException, SystemException {
		logger.entry(doctor);
		doctorOperationDelegate.updateDoctor(doctor);
		CustomResponseBody<String> response = new CustomResponseBody<String>();
		response.setStatus(HttpStatusConstant.OK);
		response.setMessage(ApplicationConstant.UPDATED);
		logger.traceExit(response);
		return response;
	}

	/**
	 * Creates the doctor.
	 *
	 * @param doctor the doctor
	 * @return the custom response body
	 * @throws BusinessException the business exception
	 * @throws SystemException the system exception
	 */
	@PostMapping("/create")
	public CustomResponseBody<Doctor> createDoctor(@RequestBody Doctor doctor)
			throws BusinessException, SystemException {
		logger.entry(doctor);
		doctorOperationDelegate.addDoctor(doctor);
		CustomResponseBody<Doctor> response = new CustomResponseBody<Doctor>();
		response.setStatus(HttpStatusConstant.OK);
		response.setMessage(doctor);
		logger.traceExit(response);
		return response;
	}

	/**
	 * Read record by id.
	 *
	 * @param id the id
	 * @return the custom response body
	 * @throws BusinessException the business exception
	 * @throws SystemException the system exception
	 */
	@GetMapping("/{param}/patient")
	public CustomResponseBody<DoctorPatientMapping> readRecordById(@PathVariable("param") int id)
			throws BusinessException, SystemException {
		logger.entry(id);
		CustomResponseBody<DoctorPatientMapping> response = new CustomResponseBody<DoctorPatientMapping>();
		response.setStatus(HttpStatusConstant.OK);
		response.setMessage(doctorOperationDelegate.readRecordById(id));
		logger.traceExit(response);
		return response;
	}

	/**
	 * Read all record.
	 *
	 * @return the custom response body
	 * @throws BusinessException the business exception
	 * @throws SystemException the system exception
	 */
	@GetMapping("/getallpatients")
	public CustomResponseBody<List<DoctorPatientMapping>> readAllRecord() throws BusinessException, SystemException {
		logger.traceEntry();
		CustomResponseBody<List<DoctorPatientMapping>> response = new CustomResponseBody<List<DoctorPatientMapping>>();
		response.setStatus(HttpStatusConstant.OK);
		response.setMessage(doctorOperationDelegate.readAllRecord());
		logger.traceExit(response);
		return response;
	}

}
