package com.cg.health_assisst.dao;

import com.cg.health_assisst.exception.EmptyListException;
import com.cg.health_assisst.exception.InvaliIdException;
import com.cg.health_assisst.exception.InvalidInputException;
import com.cg.health_assisst.exception.NullObjectExcpetion;
import com.cg.health_assisst.model.Doctor;
import java.util.*;

/**
 * creating class DoctorDAO for declaring abstract methods for Doctor class
 *
 */
public interface DoctorDAO {
	/**
	 * declaring persist method to save the object to the database
	 * 
	 * @param doctor
	 * @throws NullObjectExcpetion
	 */
	public void persist(Doctor doctor) throws NullObjectExcpetion;

	/**
	 * declaring removeDoctor method to remove the data form database using doctorID
	 * 
	 * @param doctorId
	 * @return
	 * @throws InvaliIdException
	 */
	public boolean removeDoctor(int doctorId) throws InvaliIdException;

	/**
	 * declaring findAll method to get all the details related to doctor table
	 * 
	 * @return
	 * @throws EmptyListException
	 */
	public List<Doctor> findAll() throws EmptyListException;

	/**
	 * declaring findByCategory to get the details of doctor from database based on
	 * Specialization
	 * 
	 * @param specialization
	 * @return
	 * @throws InvalidInputException
	 * @throws EmptyListException
	 */
	public List<Doctor> findByCategory(String specialization) throws InvalidInputException, EmptyListException;

	/**
	 * declaring updateByName method to update the name of doctor
	 * 
	 * @param nameId
	 * @param name
	 * @throws InvalidInputException
	 */
	public void updateByName(int nameId, String name) throws InvalidInputException;

	/**
	 * declaring updateBySpecialization method to update the specialization of
	 * doctor
	 * 
	 * @param specId
	 * @param spacialization
	 * @throws InvalidInputException
	 */
	public void updateBySpecialization(int specId, String spacialization) throws InvalidInputException;

	/**
	 * declaring updateByPhoneNumber method to update the phone number of doctor
	 * 
	 * @param phoneId
	 * @param phoneNumber
	 * @throws InvalidInputException
	 */
	public void updateByPhoneNumber(int phoneId, long phoneNumber) throws InvalidInputException;

	/**
	 * declaring updateBYEmail method to update the email of the doctor
	 * 
	 * @param emailId
	 * @param email
	 * @throws InvalidInputException
	 */
	public void updateByEmail(int emailId, String email) throws InvalidInputException;

}
