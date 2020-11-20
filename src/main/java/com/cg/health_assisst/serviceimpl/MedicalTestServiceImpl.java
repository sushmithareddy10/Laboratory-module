package com.cg.health_assisst.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.cg.health_assisst.dao.MedicalTestDAO;
import com.cg.health_assisst.daoimpl.MedicalTestDAOImpl;
import com.cg.health_assisst.exception.EmptyListException;
import com.cg.health_assisst.exception.InvalidInputException;
import com.cg.health_assisst.exception.NullObjectExcpetion;
import com.cg.health_assisst.model.MedicalTest;
import com.cg.health_assisst.service.MedicalTestService;

/**
 * creating class MedicalTestServiceImpl to implement the MedicalTestService
 * Interface to implement the methods
 *
 */
public class MedicalTestServiceImpl implements MedicalTestService {
	/**
	 * declaring private variable medicalTestDAO using MedicalTestDAO reerence
	 */
	private MedicalTestDAO medicalTestDAO;

	/**
	 * declaring constructor for MedicalTestServiceImpl to create object for
	 * MedicalTestDAOImpl
	 */
	public MedicalTestServiceImpl() {
		medicalTestDAO = new MedicalTestDAOImpl();
	}

	/**
	 * declaring addMedicalTest method to add the medical test details into the
	 * Medical Test table
	 * 
	 * @param medicalTest
	 */
	@Override
	public void addMedicalTest(MedicalTest medicalTest) {
		try {
			medicalTestDAO.persist(medicalTest);
		} catch (NullObjectExcpetion e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * declaring viewMedicalTest method to view the list of all the doctors present
	 * in the MedicalTest table
	 * 
	 * @return
	 */
	@Override
	public List<MedicalTest> viewMedicalTest() {
		List<MedicalTest> medicalTestList = new ArrayList<>();
		try {
			medicalTestList = medicalTestDAO.findAll();
		} catch (EmptyListException e) {
			System.out.println(e.getMessage());
		}
		return medicalTestList;
	}

	/**
	 * declaring addPatientTestTResults method to add the status of test results
	 * about the patient
	 * 
	 * @param medicalTestIdResults
	 * @param status
	 */
	@Override
	public void addPatientMedicalTestResults(int medicalTestIdResults, String status) {
		try {
			medicalTestDAO.findPatientTestResults(medicalTestIdResults, status);
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * declaring the removeMedicalTest table from the Medical Test table base on id
	 * 
	 * @param removeMedicalTest
	 * @return
	 */
	@Override
	public boolean removeMedicalTest(int removeMedicalTest) {
		boolean truth = false;
		try {
			truth = medicalTestDAO.removeMedicalTest(removeMedicalTest);
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}
		return truth;
	}

	/**
	 * declaring viewMedicalTestById method is used to view the details of medical
	 * test from table based on id
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public MedicalTest viewMedicalTestById(int id) {
		MedicalTest medicalTest = null;
		try {
			medicalTest = medicalTestDAO.findById(id);
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}
		return medicalTest;
	}

	/**
	 * declaring editByPatientName method to update the Patient name based on id
	 * 
	 * @param id
	 * @param name
	 */
	@Override
	public void editByPatientName(int id, String name) {
		try {
			medicalTestDAO.editByPatientName(id, name);
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * declaring editByPAtientAge method to update the Patient age based on id
	 * 
	 * @param id
	 * @param age
	 */
	@Override
	public void editByPatientAge(int id, int age) {
		try {
			medicalTestDAO.editByPatientAge(id, age);
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * declaring editByPhoneNumber method to update the Patient phone number based
	 * on id
	 * 
	 * @param id
	 * @param phoneNumber
	 */
	@Override
	public void editByPhoneNumber(int id, long phoneNumber) {
		try {
			medicalTestDAO.editByPatientPhoneNUmber(id, phoneNumber);
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * declaring editByAddress method to update the Patient Address based on id
	 * 
	 * @param id
	 * @param address
	 */
	@Override
	public void editByAddress(int id, String address) {
		try {
			medicalTestDAO.editByPatientAddress(id, address);
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * declaring editByBloodGroup method to update the blood group based on id
	 * 
	 * @param id
	 * @param bloodGroup
	 */
	@Override
	public void editByBloodGroup(int id, String bloodGroup) {
		try {
			medicalTestDAO.edityByBloodGroup(id, bloodGroup);
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * declaring editByTestName method to update the test name based on id
	 * 
	 * @param id
	 * @param testName
	 */
	@Override
	public void editByTestName(int id, String testName) {
		try {
			medicalTestDAO.editByTestName(id, testName);
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * declaring editByTestResult to update the test result based on id
	 * 
	 * @param id
	 * @param testResult
	 */
	@Override
	public void editByTestResult(int id, String testResult) {
		try {
			medicalTestDAO.editByTestResults(id, testResult);
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}

	}

}
