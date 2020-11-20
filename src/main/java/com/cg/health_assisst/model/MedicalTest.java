package com.cg.health_assisst.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * creating MedicaTest class to have the medical test details
 *
 */
@Entity
public class MedicalTest {
	/**
	 * creating Integer variable medicalTestId to store the id of the medical test
	 */
	@Id
	private int medicalTestId;
	/**
	 * creating Patient variable patient to store the details of patient
	 */
	@Embedded
	private Patient patient;
	/**
	 * creating String variable bloodGroup to store the blood group of patient
	 */
	private String bloodGroup;
	/**
	 * creating String variable medicalTestName to store the medical test name
	 */
	private String medicalTestName;
	/**
	 * creating String variable testResult to store the status of the medical test
	 */
	private String testResult;

	/**
	 * creating getTestResult method to get the test result
	 * 
	 * @return
	 */
	public String getTestResult() {
		return testResult;
	}

	/**
	 * creating setTestResult to set the parameter value
	 * 
	 * @param testResult
	 */
	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	/**
	 * creating getMedicalTestId to get the medical test id
	 * 
	 * @return
	 */
	public int getMedicalTestId() {
		return medicalTestId;
	}

	/**
	 * creating setMedicalTestId to set the medical test id with parameter value
	 * 
	 * @param medicalTestId
	 */
	public void setMedicalTestId(int medicalTestId) {
		this.medicalTestId = medicalTestId;
	}

	/**
	 * creating getPatient to get the details of the patient
	 * 
	 * @return
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * creating setPatient method to set the values of patient with parameter value
	 * 
	 * @param patient
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * creating getBloodGroup method to get the blood group of the patient
	 * 
	 * @return
	 */
	public String getBloodGroup() {
		return bloodGroup;
	}

	/**
	 * creating setBloodGroup method to set the blood group with parameter value
	 * 
	 * @param bloodGroup
	 */
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	/**
	 * creating getMedicalTestName to get the medical test name of patient
	 * 
	 * @return
	 */
	public String getMedicalTestName() {
		return medicalTestName;
	}

	/**
	 * creating setMedicalTestName to set the medical test name with the parameter
	 * value
	 * 
	 * @param medicalTestName
	 */
	public void setMedicalTestName(String medicalTestName) {
		this.medicalTestName = medicalTestName;
	}

	/**
	 * declaring parameterized constructor to set the values taken form the user
	 * 
	 * @param medicalTestId
	 * @param patient
	 * @param bloodGroup
	 * @param medicalTestName
	 */
	public MedicalTest(int medicalTestId, Patient patient, String bloodGroup, String medicalTestName) {
		super();
		this.medicalTestId = medicalTestId;
		this.patient = patient;
		this.bloodGroup = bloodGroup;
		this.medicalTestName = medicalTestName;
	}

	/**
	 * declaring non-parameterized constructor
	 */
	public MedicalTest() {

	}

	/**
	 * creating toString method to override the print statement to print the object
	 * of the Medical Test
	 */
	@Override
	public String toString() {
		return "MedicalTest [medicalTestId=" + medicalTestId + ", patient=" + patient + ", bloodGroup=" + bloodGroup
				+ ", medicalTestName=" + medicalTestName + ", testResult=" + testResult + "]";
	}

}
