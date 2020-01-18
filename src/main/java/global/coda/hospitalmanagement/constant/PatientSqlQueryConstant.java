package global.coda.hospitalmanagement.constant;

/**
 *
 * @author Vishal
 */
public final class PatientSqlQueryConstant {

	/**
	 * Instantiates a new patient sql query constant.
	 */
	private PatientSqlQueryConstant() {

	}

	public static final String USER_DETAIL_INSERT = "INSERT INTO `t_user_details` (`username`, `password`, `fk_role_id`,"
			+ " `firstname`, `lastname`, `city`, `state`,`phone_number`) VALUES (#{username}, #{password}, 4, #{firstName}, #{lastName}, #{city}, #{state},#{phoneNumber});";

	public static final String PATIENT_INSERT = "INSERT INTO `t_patient` (`fk_user_id`, `blood_group`, `weight`) VALUES (#{id}, #{bloodGroup}, #{weight})";

	public static final String PATIENT_SELECT_ALL = "select * from hms.t_user_details as user LEFT JOIN hms.t_patient"
			+ " as patient ON user.pk_user_id = patient.fk_user_id where user.is_active = 1 and user.fk_role_id = 4";

	public static final String PATIENT_SELECT_BY_ID = "select * from hms.t_user_details as user LEFT JOIN hms.t_patient"
			+ " as patient ON user.pk_user_id = patient.fk_user_id where user.pk_user_id=#{id} and user.is_active = 1 and user.fk_role_id = 4";

	public static final String PATIENT_DELETE_BY_ID = "update t_patient set is_active = 0 where fk_user_id = #{id} and is_active = 1";

	public static final String PATIENT_UPDATE_BY_ID = "UPDATE `t_patient` SET `blood_group` = #{bloodGroup}, "
			+ "`weight` = #{weight} WHERE (`fk_user_id` = #{id} and is_active = 1)";

}
