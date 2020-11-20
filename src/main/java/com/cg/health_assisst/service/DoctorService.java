package com.cg.health_assisst.service;

import com.cg.health_assisst.model.Doctor;
import java.util.*;

/**
 * creating Interface DoctorService to declare the abstract methods of services
 * provided by Doctor model
 *
 */
public interface DoctorService {
	/**
	 * declaring viewAvailable Doctors method to view all the available doctors from
	 * Doctor Table
	 * 
	 * @return
	 */
	public List<Doctor> viewAvailableDoctors();

	/**
	 * declaring viewAllAvailableDoctorsOnCatergory to view the list of doctors
	 * based on specialization
	 * 
	 * @param specialization
	 * @return
	 */
	public List<Doctor> viewAvailableDoctorsOnCategory(String specialization);

	/**
	 * declaring addDoctor method to add Doctor details into the Doctor table
	 * 
	 * @param doctor
	 */
	public void addDoctor(Doctor doctor);

	/**
	 * declaring removeDoctor method to remove the doctor based on id and returns
	 * boolean value
	 * 
	 * @param removeDoctorId
	 * @return
	 */
	public boolean removeDoctor(int removeDoctorId);

	/**
	 * declaring editName method to update the Doctor name based on id
	 * 
	 * @param nameId
	 * @param name
	 */
	public void editName(int nameId, String name);

	/**
	 * declaring editSpecialization to update the Doctor specialization based on id
	 * 
	 * @param specId
	 * @param specialization
	 */
	public void editSpecialization(int specId, String specialization);

	/**
	 * declaring editPhoneNumber to update the phone number of the Doctor based on
	 * id
	 * 
	 * @param phoneId
	 * @param phoneNumber
	 */
	public void editPhoneNumber(int phoneId, long phoneNumber);

	/**
	 * declaring editEmail to update the email of the Doctor based on id
	 * 
	 * @param emailId
	 * @param email
	 */
	public void editEmail(int emailId, String email);

}
