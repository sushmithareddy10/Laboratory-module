package com.cg.health_assisst.model;

import javax.persistence.Embeddable;
import javax.persistence.Id;

/**
 * creating Patient class to have patient details
 *
 */
@Embeddable
public class Patient {
	/**
	 * creating integer variable patientId to store id of patient
	 */
	private int patientId;
	/**
	 * creating String patientName to store name of the patient
	 */
	private String patientName;
	/**
	 * creating integer variable patientAge to store age of the patient
	 */
	private int patientAge;
	/**
	 * creating long variable patientPhoneNumber to store patient phone number
	 */
	private long patientPhoneNumber;
	/**
	 * creating String variable patientAddress to store the patient address
	 */
	private String patientAddress;

	/**
	 * creating getPatientId method to get the id of the patient
	 * 
	 * @return
	 */
	public int getPatientId() {
		return patientId;
	}

	/**
	 * creating setPatientId method to set the value of the parameter
	 * 
	 * @param patientId
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	/**
	 * creating getPatientName method to get the name of the patient
	 * 
	 * @return
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * creating setPatientName to set the value of the parameter
	 * 
	 * @param patientName
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	/**
	 * creating getPatientAge method to get the age of the patient
	 * 
	 * @return
	 */
	public int getPatientAge() {
		return patientAge;
	}

	/**
	 * creating setPatientAge to set the value of the parameter
	 * 
	 * @param patientAge
	 */
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	/**
	 * creating getPatientPhoneNumber to get the phone number of the patient
	 * 
	 * @return
	 */
	public long getPatientPhoneNumber() {
		return patientPhoneNumber;
	}

	/**
	 * creating setPatientPhoneNumber to set the value of the parameter
	 * 
	 * @param patientPhoneNumber
	 */
	public void setPatientPhoneNumber(long patientPhoneNumber) {
		this.patientPhoneNumber = patientPhoneNumber;
	}

	/**
	 * creating getPatientAddress to get the patient address of the patient
	 * 
	 * @return
	 */
	public String getPatientAddress() {
		return patientAddress;
	}

	/**
	 * creating setPatientAddress to set the value of the parameter
	 * 
	 * @param patientAddress
	 */
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	/**
	 * creating parameterized constructor to set the values to the instance variable
	 * 
	 * @param patientId
	 * @param patientName
	 * @param patientAge
	 * @param patientPhoneNumber
	 * @param patientAddress
	 */
	public Patient(int patientId, String patientName, int patientAge, long patientPhoneNumber, String patientAddress) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientPhoneNumber = patientPhoneNumber;
		this.patientAddress = patientAddress;
	}

	/**
	 * creating non-parameterized constructor
	 */
	public Patient() {

	}

	/**
	 * declaring a toString method to override the print statement to print the
	 * Patient object
	 */
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientAge=" + patientAge
				+ ", patientPhoneNumber=" + patientPhoneNumber + ", patientAddress=" + patientAddress + "]";
	}

}
