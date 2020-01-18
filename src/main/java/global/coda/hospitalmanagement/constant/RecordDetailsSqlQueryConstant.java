package global.coda.hospitalmanagement.constant;

/**
 *
 * @author Vishal
 */
public final class RecordDetailsSqlQueryConstant {

	/**
	 * Instantiates a new record details sql query constant.
	 */
	private RecordDetailsSqlQueryConstant() {

	}

	public static final String READ_ALL_RECORD = "select username as doctor_name,"
			+ "doctor.patient_name,doctor.disease from hms.t_user_details  "
			+ "LEFT join (select fk_doctor_id ,patient.username as patient_name ,disease"
			+ " from t_record as record  LEFT join (select pk_user_id,"
			+ "		user.username from  hms.t_user_details as user " + " where  user.is_active = 1 and"
			+ "           fk_role_id = 4) as patient on patient.pk_user_id = fk_patient_id ) "
			+ "as doctor on doctor.fk_doctor_id = pk_user_id where is_active = 1 and" + " fk_role_id = 3 ";

	public static final String READ_RECORD_BY_DOCTOR_ID = "select username as doctor_name,doctor.patient_name,"
			+ "doctor.disease from hms.t_user_details  LEFT join (select fk_doctor_id ,patient.username as patient_name ,disease from t_record as record  LEFT join (select pk_user_id,"
			+ "		user.username from  hms.t_user_details as user  where  user.is_active = 1 and"
			+ "           fk_role_id = 4) as patient on patient.pk_user_id = fk_patient_id ) "
			+ "as doctor on doctor.fk_doctor_id = pk_user_id where is_active = 1 and"
			+ "           fk_role_id = 3 and pk_user_id=#{id}";

}
