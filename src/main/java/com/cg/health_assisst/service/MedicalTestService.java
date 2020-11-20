package com.cg.health_assisst.service;

import java.util.*;
import com.cg.health_assisst.model.MedicalTest;

/**
 * creating class MedicalService to declare abstract methods of services
 * provided by MedicalTestService
 *
 */
public interface MedicalTestService {
	/**
	 * declaring addMedicalTest method to add the medical test details into the
	 * Medical Test table
	 * 
	 * @param medicalTest
	 */
	public void addMedicalTest(MedicalTest medicalTest);

	/**
	 * declaring viewMedicalTest method to view the list of all the doctors present
	 * in the MedicalTest table
	 * 
	 * @return
	 */
	public List<MedicalTest> viewMedicalTest();

	/**
	 * declaring the removeMedicalTest table from the Medical Test table base on id
	 * 
	 * @param removeMedicalTest
	 * @return
	 */
	public boolean removeMedicalTest(int removeMedicalTest);

	/**
	 * declaring addPatientTestTResults method to add the status of test results
	 * about the patient
	 * 
	 * @param medicalTestIdResults
	 * @param status
	 */
	public void addPatientMedicalTestResults(int medicalTestIdResults, String status);

	/**
	 * declaring viewMedicalTestById method is used to view the details of medical
	 * test from table based on id
	 * 
	 * @param id
	 * @return
	 */
	public MedicalTest viewMedicalTestById(int id);

	/**
	 * declaring editByPatientName method to update the Patient name based on id
	 * 
	 * @param id
	 * @param name
	 */
	public void editByPatientName(int id, String name);

	/**
	 * declaring editByPAtientAge method to update the Patient age based on id
	 * 
	 * @param id
	 * @param age
	 */
	public void editByPatientAge(int id, int age);

	/**
	 * declaring editByPhoneNumber method to update the Patient phone number based
	 * on id
	 * 
	 * @param id
	 * @param phoneNumber
	 */
	public void editByPhoneNumber(int id, long phoneNumber);

	/**
	 * declaring editByAddress method to update the Patient Address based on id
	 * 
	 * @param id
	 * @param address
	 */
	public void editByAddress(int id, String address);

	/**
	 * declaring editByBloodGroup method to update the blood group based on id
	 * 
	 * @param id
	 * @param bloodGroup
	 */
	public void editByBloodGroup(int id, String bloodGroup);

	/**
	 * declaring editByTestName method to update the test name based on id
	 * 
	 * @param id
	 * @param testName
	 */
	public void editByTestName(int id, String testName);

	/**
	 * declaring editByTestResult to update the test result based on id
	 * 
	 * @param id
	 * @param testResult
	 */
	public void editByTestResult(int id, String testResult);

}
