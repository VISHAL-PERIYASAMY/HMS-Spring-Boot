package global.coda.hospitalmanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import global.coda.hospitalmanagement.constant.DoctorSqlQueryConstant;
import global.coda.hospitalmanagement.model.Doctor;
import global.coda.hospitalmanagement.model.Patient;

/**
 *
 * @author Vishal
 *
 */
@Mapper
public interface DoctorMapper {

	/**
	 * Read doctor by id.
	 *
	 * @param id the id
	 * @return the doctor
	 */
	@Select(DoctorSqlQueryConstant.DOCTOR_SELECT_BY_ID)
	@Results({ @Result(property = "id", column = "pk_user_id"), @Result(property = "userId", column = "fk_user_id"),
		@Result(property = "doctorId", column = "pk_doctor_id"),
		@Result(property = "roleId", column = "fk_role_id"),
		@Result(property = "specilization", column = "doctor_specialization") })
	Doctor readDoctorById(int id);

	/**
	 * Read all doctor.
	 *
	 * @return the list
	 */
	@Select(DoctorSqlQueryConstant.DOCTOR_SELECT_ALL)
	@Results({ @Result(property = "id", column = "pk_user_id"), @Result(property = "userId", column = "fk_user_id"),
		@Result(property = "patientId", column = "pk_patient_id"),
		@Result(property = "roleId", column = "fk_role_id"),
		@Result(property = "specilization", column = "doctor_specialization") })
	List<Doctor> readAllDoctor();

	/**
	 * Creates the doctor.
	 *
	 * @param doctor the doctor
	 * @return the int
	 */
	@Insert(DoctorSqlQueryConstant.DOCTOR_INSERT)
	int createDoctor(Doctor doctor);

	/**
	 * Delete doctor by id.
	 *
	 * @param id the id
	 * @return the int
	 */
	@Update(DoctorSqlQueryConstant.DOCTOR_DELETE_BY_ID)
	int deleteDoctorById(int id);

	/**
	 * Update doctor.
	 *
	 * @param doctor the doctor
	 * @return the int
	 */
	@Update(DoctorSqlQueryConstant.DOCTOR_UPDATE_BY_ID)
	int updateDoctor(Doctor doctor);

	@Select(DoctorSqlQueryConstant.DOCTOR_SELECT_BY_ID)
	@Results({ @Result(property = "id", column = "pk_user_id"), @Result(property = "userId", column = "fk_user_id"),
		@Result(property = "doctorId", column = "pk_doctor_id"),
		@Result(property = "roleId", column = "fk_role_id"),
		@Result(property = "specilization", column = "doctor_specialization"),
		@Result(property = "listOfPatient", column = "pk_user_id", javaType = List.class, many = @Many(select = "getAllPatient")) })
	List<Doctor> readRecordById(int id);

	@Select("select * from hms.t_user_details as user LEFT JOIN hms.t_patient as patient ON user.pk_user_id = patient.fk_user_id where user.pk_user_id in (SELECT `t_record`.`fk_patient_id` FROM `hms`.`t_record` where fk_doctor_id=#{id}) and user.is_active = 1 and user.fk_role_id = 4")
	@Results({ @Result(property = "id", column = "pk_user_id"), @Result(property = "userId", column = "fk_user_id"),
		@Result(property = "patientId", column = "pk_patient_id"),
		@Result(property = "roleId", column = "fk_role_id") })
	List<Patient> getAllPatient(int id);

}
