package com.cg.health_assisst.model;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import net.bytebuddy.implementation.bytecode.assign.reference.GenericTypeAwareAssigner;

/**
 * 
 * Creating Doctor class as an entity
 *
 */
@Entity
public class Doctor {
	/**
	 * creating integer variable doctorId
	 */
	@Id
	private int doctorId;
	/**
	 * creating String variable doctorName
	 */
	private String doctorName;
	/**
	 * creating String variable doctorSpecialization
	 */
	private String doctorSpecialization;
	/**
	 * creating long variable doctorPhoneNUmber
	 */
	private long doctoPhoneNumber;
	/**
	 * creating String variable doctorEmail
	 */
	private String doctorEmail;

	/**
	 * creating getDoctorId method to get id of doctor
	 * 
	 * @return
	 */
	public int getDoctorId() {
		return doctorId;
	}

	/**
	 * creating setDoctorId method to the value with the parameter
	 * 
	 * @param doctorId
	 */
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * creating getDoctorName method to get the name of the doctor
	 * 
	 * @return
	 */
	public String getDoctorName() {
		return doctorName;
	}

	/**
	 * creating steDoctorName method to set the value with the parameter
	 * 
	 * @param doctorName
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	/**
	 * creating getDoctorSpecialization method to get the specialization of the
	 * doctor
	 * 
	 * @return
	 */
	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}

	/**
	 * creating setDoctorSpecialization method to set the value with the parameter
	 * 
	 * @param doctorSpecialization
	 */
	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}

	/**
	 * creating getDoctorPhoneNumber method to get the phone number of doctor
	 * 
	 * @return
	 */
	public long getDoctoPhoneNumber() {
		return doctoPhoneNumber;
	}

	/**
	 * creating setDoctorPhoneNumber method to set the value with the parameter
	 * 
	 * @param doctoPhoneNumber
	 */
	public void setDoctoPhoneNumber(long doctoPhoneNumber) {
		this.doctoPhoneNumber = doctoPhoneNumber;
	}

	/**
	 * creating getDoctorEmail method to get the email of the doctor
	 * 
	 * @return
	 */
	public String getDoctorEmail() {
		return doctorEmail;
	}

	/**
	 * creating setDoctorEmail method to set the value with the parameter
	 * 
	 * @param doctorEmail
	 */
	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}

	/**
	 * creating parameterized constructor to set the value for the declared instance
	 * variables
	 * 
	 * @param doctorId
	 * @param doctorName
	 * @param doctorSpecialization
	 * @param doctoPhoneNumber
	 * @param doctorEmail
	 */
	public Doctor(int doctorId, String doctorName, String doctorSpecialization, long doctoPhoneNumber,
			String doctorEmail) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorSpecialization = doctorSpecialization;
		this.doctoPhoneNumber = doctoPhoneNumber;
		this.doctorEmail = doctorEmail;
	}

	/**
	 * creating toString to override the output statement to display Doctor Object
	 */
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorSpecialization="
				+ doctorSpecialization + ", doctoPhoneNumber=" + doctoPhoneNumber + ", doctorEmail=" + doctorEmail
				+ "]";
	}

	/**
	 * creating non-parameterized constructor
	 */
	public Doctor() {

	}

}
