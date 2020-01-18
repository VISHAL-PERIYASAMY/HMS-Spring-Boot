package global.coda.hospitalmanagement.model;

/**
 *
 * @author Vishal
 *
 */
public class PatientRecordDetails {

	/** The disease. */
	private String disease;

	/** The patient name. */
	private String patientName;

	/**
	 * Gets the disease.
	 *
	 * @return the disease
	 */
	public String getDisease() {
		return disease;
	}

	/**
	 * Sets the disease.
	 *
	 * @param disease the new disease
	 */
	public void setDisease(String disease) {
		this.disease = disease;
	}

	/**
	 * Gets the patient name.
	 *
	 * @return the patient name
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * Sets the patient name.
	 *
	 * @param patientName the new patient name
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PatientRecordDetails [disease=" + disease + ", patientName=" + patientName + "]";
	}

}
