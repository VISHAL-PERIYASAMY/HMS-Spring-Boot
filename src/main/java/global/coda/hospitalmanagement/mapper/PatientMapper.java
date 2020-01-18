package global.coda.hospitalmanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import global.coda.hospitalmanagement.constant.PatientSqlQueryConstant;
import global.coda.hospitalmanagement.model.Patient;

/**
 *
 * @author Vishal
 *
 */
@Mapper
public interface PatientMapper {

	/**
	 * Read patient by id.
	 *
	 * @param id the id
	 * @return the patient
	 */
	@Select(PatientSqlQueryConstant.PATIENT_SELECT_BY_ID)
	@Results({ @Result(property = "id", column = "pk_user_id"), @Result(property = "userId", column = "fk_user_id"),
		@Result(property = "patientId", column = "pk_patient_id"),
		@Result(property = "roleId", column = "fk_role_id") })
	Patient readPatientById(int id);

	/**
	 * Read all patient.
	 *
	 * @return the list
	 */
	@Select(PatientSqlQueryConstant.PATIENT_SELECT_ALL)
	@Results({ @Result(property = "id", column = "pk_user_id"), @Result(property = "userId", column = "fk_user_id"),
		@Result(property = "patientId", column = "pk_patient_id"),
		@Result(property = "roleId", column = "fk_role_id") })
	List<Patient> readAllPatient();

	/**
	 * Creates the patient.
	 *
	 * @param patient the patient
	 * @return the int
	 */
	@Insert(PatientSqlQueryConstant.PATIENT_INSERT)
	int createPatient(Patient patient);

	/**
	 * Delete patient by id.
	 *
	 * @param id the id
	 * @return the int
	 */
	@Update(PatientSqlQueryConstant.PATIENT_DELETE_BY_ID)
	int deletePatientById(int id);

	/**
	 * Update patient.
	 *
	 * @param patient the patient
	 * @return the int
	 */
	@Update(PatientSqlQueryConstant.PATIENT_UPDATE_BY_ID)
	int updatePatient(Patient patient);

}
