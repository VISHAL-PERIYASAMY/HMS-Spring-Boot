package global.coda.hospitalmanagement.model;

import java.util.List;

/**
 *
 * @author Vishal
 *
 */
public class DoctorPatientMapping {

	/** The doctor name. */
	private String doctorName;

	/** The list of patients. */
	private List<PatientRecordDetails> listOfPatients;

	/**
	 * Gets the doctor name.
	 *
	 * @return the doctor name
	 */
	public String getDoctorName() {
		return doctorName;
	}

	/**
	 * Sets the doctor name.
	 *
	 * @param doctorName the new doctor name
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	/**
	 * Gets the list of patients.
	 *
	 * @return the list of patients
	 */
	public List<PatientRecordDetails> getListOfPatients() {
		return listOfPatients;
	}

	/**
	 * Sets the list of patients.
	 *
	 * @param listOfPatients the new list of patients
	 */
	public void setListOfPatients(List<PatientRecordDetails> listOfPatients) {
		this.listOfPatients = listOfPatients;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "DoctorPatientMapping [doctorName=" + doctorName + ", listOfPatients=" + listOfPatients + "]";
	}

}
