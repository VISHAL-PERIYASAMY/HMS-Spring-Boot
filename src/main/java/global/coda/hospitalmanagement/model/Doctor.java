package global.coda.hospitalmanagement.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Vishal
 *
 */
public class Doctor extends UserDetails {

	/** The doctor id. */
	private int doctorId;

	/** The user id. */
	private int userId;

	/** The specilization. */
	private String specilization;

	/** The is active. */
	private int isActive;

	/** The created time. */
	private Date createdTime;

	/** The updated time. */
	private Date updatedTime;

	private List<Patient> listOfPatient;


	public List<Patient> getListOfPatient() {
		return listOfPatient;
	}

	public void setListOfPatient(List<Patient> listOfPatient) {
		this.listOfPatient = listOfPatient;
	}

	/**
	 * Gets the doctor id.
	 *
	 * @return the doctor id
	 */
	public int getDoctorId() {
		return doctorId;
	}

	/**
	 * Sets the doctor id.
	 *
	 * @param doctorId the new doctor id
	 */
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Gets the specilization.
	 *
	 * @return the specilization
	 */
	public String getSpecilization() {
		return specilization;
	}

	/**
	 * Sets the specilization.
	 *
	 * @param specilization the new specilization
	 */
	public void setSpecilization(String specilization) {
		this.specilization = specilization;
	}

	/**
	 * Gets the checks if is active.
	 *
	 * @return the checks if is active
	 */
	@Override
	public int getIsActive() {
		return isActive;
	}

	/**
	 * Sets the checks if is active.
	 *
	 * @param isActive the new checks if is active
	 */
	@Override
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	/**
	 * Gets the created time.
	 *
	 * @return the created time
	 */
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * Sets the created time.
	 *
	 * @param createdTime the new created time
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * Gets the updated time.
	 *
	 * @return the updated time
	 */
	public Date getUpdatedTime() {
		return updatedTime;
	}

	/**
	 * Sets the updated time.
	 *
	 * @param updatedTime the new updated time
	 */
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", userId=" + userId + ", specilization=" + specilization
				+ ", isActive=" + isActive + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + "]";
	}

}
