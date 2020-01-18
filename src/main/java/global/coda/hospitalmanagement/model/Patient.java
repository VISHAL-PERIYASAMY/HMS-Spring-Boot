package global.coda.hospitalmanagement.model;

import java.sql.Date;

/**
 *
 * @author Vishal
 *
 */
public class Patient extends UserDetails {

	/** The patient id. */
	private int patientId;

	/** The user id. */
	private int userId;

	/** The blood group. */
	private String bloodGroup;

	/** The weight. */
	private int weight;

	/** The is active. */
	private int isActive;

	/** The created date. */
	private Date createdDate;

	/** The updated date. */
	private Date updatedDate;

	/**
	 * Gets the patient id.
	 *
	 * @return the patient id
	 */
	public int getPatientId() {
		return patientId;
	}

	/**
	 * Sets the patient id.
	 *
	 * @param patientId the new patient id
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
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
	 * Gets the blood group.
	 *
	 * @return the blood group
	 */
	public String getBloodGroup() {
		return bloodGroup;
	}

	/**
	 * Sets the blood group.
	 *
	 * @param bloodGroup the new blood group
	 */
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	/**
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Sets the weight.
	 *
	 * @param weight the new weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
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
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	@Override
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate the new created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the updated date.
	 *
	 * @return the updated date
	 */
	@Override
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * Sets the updated date.
	 *
	 * @param updatedDate the new updated date
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
