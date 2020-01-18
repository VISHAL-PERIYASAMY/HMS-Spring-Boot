package global.coda.hospitalmanagement.delegate;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import global.coda.hospitalmanagement.constant.ApplicationConstant;
import global.coda.hospitalmanagement.constant.HttpStatusConstant;
import global.coda.hospitalmanagement.constant.NumericConstants;
import global.coda.hospitalmanagement.exception.BusinessException;
import global.coda.hospitalmanagement.exception.PatientNotFoundException;
import global.coda.hospitalmanagement.exception.SystemException;
import global.coda.hospitalmanagement.exception.UserNameAlreadyExistException;
import global.coda.hospitalmanagement.mapper.PatientMapper;
import global.coda.hospitalmanagement.mapper.UserMapper;
import global.coda.hospitalmanagement.model.Patient;

/**
 *
 * @author Vishal
 *
 */
@Service
public class PatientOperationDelegate {

	/** The patient mapper. */
	@Autowired
	private PatientMapper patientMapper;

	/** The user mapper. */
	@Autowired
	private UserMapper userMapper;

	/** The logger. */
	private final Logger logger = LogManager.getLogger(PatientOperationDelegate.class);

	/**
	 * Adds the patient.
	 *
	 * @param patient the patient
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public boolean addPatient(Patient patient) throws BusinessException, SystemException {
		try {
			logger.entry(patient);
			int rows = userMapper.createUser(patient);
			rows = patientMapper.createPatient(patient);
			logger.traceExit();
			if (rows != NumericConstants.ZERO) {
				return true;
			} else {
				throw new UserNameAlreadyExistException(
						HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE + ApplicationConstant.NAME_EXIST);
			}
		} catch (UserNameAlreadyExistException error) {
			throw new BusinessException(error.getMessage());
		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

	/**
	 * Read all patient.
	 *
	 * @return the list
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public List<Patient> readAllPatient() throws BusinessException, SystemException {
		try {
			logger.traceEntry();
			List<Patient> patient = patientMapper.readAllPatient();
			if (patient.size() == NumericConstants.ZERO) {
				throw new PatientNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.PATIENT_NOT_FOUND);
			}
			logger.traceExit(patient);
			return patient;
		} catch (PatientNotFoundException error) {
			throw new BusinessException(error.getMessage());
		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

	/**
	 * Read patient by id.
	 *
	 * @param id the id
	 * @return the patient
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public Patient readPatientById(int id) throws BusinessException, SystemException {
		try {
			logger.entry(id);
			Patient patient = patientMapper.readPatientById(id);
			logger.traceExit(patient);
			if (patient == null) {
				throw new PatientNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.PATIENT_NOT_FOUND);
			}
			logger.traceExit(patient);
			return patient;
		} catch (PatientNotFoundException error) {
			throw new BusinessException(error.getMessage());
		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

	/**
	 * Delete patient.
	 *
	 * @param patient the patient
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public boolean deletePatient(Patient patient) throws BusinessException, SystemException {
		try {
			logger.entry(patient);

			int result = userMapper.deleteUserById(patient.getId());
			if (result == 0) {
				throw new PatientNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.PATIENT_NOT_FOUND);
			}
			result = patientMapper.deletePatientById(patient.getId());
			if (result == 0) {
				throw new PatientNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.PATIENT_NOT_FOUND);
			}
			logger.traceExit();
			return true;
		} catch (PatientNotFoundException error) {
			throw new BusinessException(error.getMessage());
		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

	/**
	 * Update patient.
	 *
	 * @param patient the patient
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public boolean updatePatient(Patient patient) throws BusinessException, SystemException {
		try {
			logger.entry(patient);

			int result = userMapper.updateUser(patient);
			if (result == 0) {
				throw new PatientNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.PATIENT_NOT_FOUND);
			}
			result = patientMapper.updatePatient(patient);
			if (result == 0) {
				throw new PatientNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.PATIENT_NOT_FOUND);
			}
			logger.traceExit();
			return true;
		} catch (PatientNotFoundException error) {
			throw new BusinessException(error.getMessage());
		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}
}
