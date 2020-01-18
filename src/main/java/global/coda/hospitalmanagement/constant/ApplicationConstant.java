package global.coda.hospitalmanagement.constant;

/**
 *
 * @author Vishal
 */
public final class ApplicationConstant {

	/**
	 * Instantiates a new application constant.
	 */
	private ApplicationConstant() {
	}

	public static final String DOCTOR_ID = "fk_doctor_id";

	public static final String PATIENT_NAME = "patient_name";

	public static final String DOCTOR_NAME = "doctor_name";

	public static final String SPACE = " ";

	public static final String USER_NOT_CREATED = "User Name already Exist";

	public static final String NAME_EXIST = "User Name already Exist";

	public static final String SERVER_ERROR = "Something Went Wrong Please Try Again";

	public static final String RESOURCE_FILE = "user/userMessages";

	public static final String USER_DELETED = "Deleted !!!";

	public static final String USER_NOT_FOUND = "USER NOT FOUND!!!";

	public static final String RECORD_NOT_FOUND = "Record NOT FOUND!!!";

	public static final String PATIENT_NOT_FOUND = "PATIENT NOT FOUND!!!";

	public static final String DOCTOR_NOT_FOUND = "DOCTOR_NOT_FOUND!!!";

	public static final String EXPECTED_INTEGER = "Expected Integer Input only";

	public static final String OPTION_NOT_FOUND = "Selected Option Not available try another";

	public static final String HOSPITAL_NOT_FOUND = "HOSPITAL NOT FOUND!!!";

	public static final String LOGIN_AGAIN = "Login failed, try again!!";

	public static final String USERNAME = "username";

	public static final String FIRSTNAME = "firstname";

	public static final String LASTNAME = "lastname";

	public static final String DOCTORSPECIALIZATION = "doctor_specialization";

	public static final String CITY = "city";

	public static final String STATE = "state";

	public static final String PHONENUMBER = "phone_number";

	public static final String BLOODGROUP = "blood_group";

	public static final String WEIGHT = "weight";

	public static final String DISEASE = "disease";

	public static final String UPDATED = "Updated successfully !!";

	/**
	 * The Enum ROLE.
	 */
	public enum ROLE {

		/** The admin. */
		ADMIN,

		/** The global admin. */
		GLOBAL_ADMIN,

		/** The patient. */
		PATIENT,

		/** The doctor. */
		DOCTOR
	}
}
