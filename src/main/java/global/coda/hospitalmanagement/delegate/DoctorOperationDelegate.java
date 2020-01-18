package global.coda.hospitalmanagement.delegate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import global.coda.hospitalmanagement.constant.ApplicationConstant;
import global.coda.hospitalmanagement.constant.HttpStatusConstant;
import global.coda.hospitalmanagement.constant.NumericConstants;
import global.coda.hospitalmanagement.exception.BusinessException;
import global.coda.hospitalmanagement.exception.DoctorNotFoundException;
import global.coda.hospitalmanagement.exception.RecordNotFoundException;
import global.coda.hospitalmanagement.exception.SystemException;
import global.coda.hospitalmanagement.exception.UserNameAlreadyExistException;
import global.coda.hospitalmanagement.mapper.DoctorMapper;
import global.coda.hospitalmanagement.mapper.UserMapper;
import global.coda.hospitalmanagement.model.Doctor;
import global.coda.hospitalmanagement.model.DoctorPatientMapping;
import global.coda.hospitalmanagement.model.PatientRecordDetails;
import global.coda.hospitalmanagement.model.RecordData;

/**
 *
 * @author Vishal
 *
 */
@Service
public class DoctorOperationDelegate {

	/** The doctor mapper. */
	@Autowired
	private DoctorMapper doctorMapper;

	/** The user mapper. */
	@Autowired
	private UserMapper userMapper;

	/** The logger. */
	private final Logger logger = LogManager.getLogger(DoctorOperationDelegate.class);

	/**
	 * Read all doctor.
	 *
	 * @return the list
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public List<Doctor> readAllDoctor() throws BusinessException, SystemException {
		try {
			logger.traceEntry();
			List<Doctor> doctor = doctorMapper.readAllDoctor();
			if (doctor.size() == NumericConstants.ZERO) {
				throw new DoctorNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.DOCTOR_NOT_FOUND);
			}
			logger.traceExit(doctor);
			return doctor;
		} catch (DoctorNotFoundException error) {
			throw new BusinessException(error.getMessage());
		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

	/**
	 * Read doctor by id.
	 *
	 * @param id the id
	 * @return the doctor
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public Doctor readDoctorById(int id) throws BusinessException, SystemException {
		try {
			logger.entry(id);
			Doctor doctor = doctorMapper.readDoctorById(id);
			logger.traceExit(doctor);
			if (doctor == null) {
				throw new DoctorNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.DOCTOR_NOT_FOUND);
			}
			logger.traceExit(doctor);
			return doctor;
		} catch (DoctorNotFoundException error) {
			throw new BusinessException(error.getMessage());
		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

	/**
	 * Delete doctor.
	 *
	 * @param doctor the doctor
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public boolean deleteDoctor(Doctor doctor) throws BusinessException, SystemException {
		try {
			logger.entry(doctor);
			int result = userMapper.deleteUserById(doctor.getId());
			if (result == 0) {
				throw new DoctorNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.DOCTOR_NOT_FOUND);
			}
			result = doctorMapper.deleteDoctorById(doctor.getId());
			if (result == 0) {
				throw new DoctorNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.DOCTOR_NOT_FOUND);
			}
			logger.traceExit();
			return true;
		} catch (DoctorNotFoundException error) {
			throw new BusinessException(error.getMessage());
		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

	/**
	 * Update doctor.
	 *
	 * @param doctor the doctor
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public boolean updateDoctor(Doctor doctor) throws BusinessException, SystemException {
		try {
			logger.entry(doctor);
			int result = userMapper.updateUser(doctor);
			if (result == 0) {
				throw new DoctorNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.DOCTOR_NOT_FOUND);
			}
			result = doctorMapper.updateDoctor(doctor);
			if (result == 0) {
				throw new DoctorNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.DOCTOR_NOT_FOUND);
			}
			logger.traceExit();
			return true;
		} catch (DoctorNotFoundException error) {
			throw new BusinessException(error.getMessage());
		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

	/**
	 * Adds the doctor.
	 *
	 * @param doctor the doctor
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public boolean addDoctor(Doctor doctor) throws BusinessException, SystemException {
		try {
			logger.entry(doctor);
			int rows = userMapper.createUser(doctor);
			rows = doctorMapper.createDoctor(doctor);
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
	 * Read record by id.
	 *
	 * @param id the id
	 * @return the doctor patient mapping
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public DoctorPatientMapping readRecordById(int id) throws BusinessException, SystemException {
		logger.entry(id);
		try {
			DoctorPatientMapping doctorPatientMapping = new DoctorPatientMapping();
			List<RecordData> recordData = doctorMapper.readRecordById(id);
			List<PatientRecordDetails> patientList = new ArrayList<PatientRecordDetails>();
			String doctorName = null;
			for (RecordData record : recordData) {
				doctorName = record.getDoctorName();
				PatientRecordDetails recordDetails = new PatientRecordDetails();
				recordDetails.setPatientName(record.getPatientName());
				recordDetails.setDisease(record.getDisease());
				patientList.add(recordDetails);
			}
			doctorPatientMapping.setDoctorName(doctorName);
			doctorPatientMapping.setListOfPatients(patientList);
			if (doctorName == null) {
				throw new RecordNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.RECORD_NOT_FOUND);
			}
			logger.traceExit(doctorPatientMapping);
			return doctorPatientMapping;

		} catch (RecordNotFoundException error) {
			throw new BusinessException(error.getMessage());
		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

	/**
	 * Read all record.
	 *
	 * @return the list
	 * @throws BusinessException the business exception
	 * @throws SystemException   the system exception
	 */
	public List<DoctorPatientMapping> readAllRecord() throws BusinessException, SystemException {
		logger.traceEntry();
		try {
			List<RecordData> recordData = doctorMapper.readAllRecord();
			Map<String, List<PatientRecordDetails>> recordMap = new HashMap<String, List<PatientRecordDetails>>();
			for (RecordData record : recordData) {
				PatientRecordDetails recordDetails = new PatientRecordDetails();
				recordDetails.setPatientName(record.getPatientName());
				recordDetails.setDisease(record.getDisease());
				String doctorName = record.getDoctorName();
				if (recordMap.containsKey(doctorName)) {
					List<PatientRecordDetails> listOfPatient = recordMap.get(doctorName);
					listOfPatient.add(recordDetails);
					recordMap.put(doctorName, listOfPatient);
				} else {
					List<PatientRecordDetails> listOfPatient = new ArrayList<PatientRecordDetails>();
					listOfPatient.add(recordDetails);
					recordMap.put(doctorName, listOfPatient);
				}
			}
			List<DoctorPatientMapping> listDoctorPatientMapping = new ArrayList<DoctorPatientMapping>();
			for (String key : recordMap.keySet()) {
				DoctorPatientMapping doctorPatientMapping = new DoctorPatientMapping();
				doctorPatientMapping.setDoctorName(key);
				doctorPatientMapping.setListOfPatients(recordMap.get(key));
				listDoctorPatientMapping.add(doctorPatientMapping);
			}
			if (listDoctorPatientMapping.size() == NumericConstants.ZERO) {
				throw new RecordNotFoundException(HttpStatusConstant.BAD_REQUEST + ApplicationConstant.SPACE
						+ ApplicationConstant.RECORD_NOT_FOUND);
			}
			logger.traceExit(listDoctorPatientMapping);
			return listDoctorPatientMapping;
		} catch (RecordNotFoundException error) {
			throw new BusinessException(error.getMessage());
		} catch (Exception error) {
			throw new SystemException(error.getMessage());
		}
	}

}
