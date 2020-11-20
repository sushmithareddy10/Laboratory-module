package com.cg.health_assisst.dao;

import com.cg.health_assisst.exception.EmptyListException;
import com.cg.health_assisst.exception.InvalidInputException;
import com.cg.health_assisst.exception.NullObjectExcpetion;
import com.cg.health_assisst.model.MedicalTest;
/**
 * creating MedicalTestDAO to declare the abstract methods for MedicalTest class
 */
import java.util.*;

public interface MedicalTestDAO {
	/**
	 * declaring persist method to save the details of the MedicalTest
	 * 
	 * @param medicalTest
	 * @throws NullObjectExcpetion
	 */
	public void persist(MedicalTest medicalTest) throws NullObjectExcpetion;

	/**
	 * declaring findAll method which return list to get details from database
	 * 
	 * @return
	 * @throws EmptyListException
	 */
	public List<MedicalTest> findAll() throws EmptyListException;

	/**
	 * declaring findPatientTestResults method to add the status of Patient test
	 * results
	 * 
	 * @param medicalTestId
	 * @param status
	 * @throws InvalidInputException
	 */
	public void findPatientTestResults(int medicalTestId, String status) throws InvalidInputException;

	/**
	 * declaring findById method to find details of MedicalTest based on id
	 * 
	 * @param id
	 * @return
	 * @throws InvalidInputException
	 */
	public MedicalTest findById(int id) throws InvalidInputException;

	/**
	 * declaring removeMedicalTest to remove the data form the MedicalTest table
	 * form MedicalTest table
	 * 
	 * @param id
	 * @return
	 * @throws InvalidInputException
	 */
	public boolean removeMedicalTest(int id) throws InvalidInputException;

	/**
	 * declaring editByPatientName method to update the details of patient name
	 * 
	 * @param id
	 * @param name
	 * @throws InvalidInputException
	 */
	public void editByPatientName(int id, String name) throws InvalidInputException;

	/**
	 * declaring editByPatientAge method to update the details of patient age
	 * 
	 * @param id
	 * @param age
	 * @throws InvalidInputException
	 */
	public void editByPatientAge(int id, int age) throws InvalidInputException;

	/**
	 * declaring editByPatientPhoneNUmber method to update the details of Patient
	 * number
	 * 
	 * @param id
	 * @param phoneNumber
	 * @throws InvalidInputException
	 */
	public void editByPatientPhoneNUmber(int id, long phoneNumber) throws InvalidInputException;

	/**
	 * declaring editByPatientAddress method to update the details of Patient
	 * address
	 * 
	 * @param id
	 * @param address
	 * @throws InvalidInputException
	 */
	public void editByPatientAddress(int id, String address) throws InvalidInputException;

	/**
	 * declaring editByBloodGroup method to update the details of Patient blood
	 * group
	 * 
	 * @param id
	 * @param bloodGroup
	 * @throws InvalidInputException
	 */
	public void edityByBloodGroup(int id, String bloodGroup) throws InvalidInputException;

	/**
	 * declaring editByTestName method to update the details of Patient test name
	 * 
	 * @param id
	 * @param testName
	 * @throws InvalidInputException
	 */
	public void editByTestName(int id, String testName) throws InvalidInputException;

	/**
	 * declaring editByTestResults method to update the details of Patient test
	 * results
	 * 
	 * @param id
	 * @param testResult
	 * @throws InvalidInputException
	 */
	public void editByTestResults(int id, String testResult) throws InvalidInputException;
}
