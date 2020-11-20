package com.cg.health_assisst;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.health_assisst.daoimpl.DoctorDAOImpl;
import com.cg.health_assisst.daoimpl.MedicalTestDAOImpl;
import com.cg.health_assisst.exception.EmptyListException;
import com.cg.health_assisst.exception.InvalidInputException;
import com.cg.health_assisst.exception.NullObjectExcpetion;
import com.cg.health_assisst.model.MedicalTest;
import com.cg.health_assisst.model.Patient;

public class MedicalTestDAOTest {

	public static MedicalTestDAOImpl dao;

	@BeforeClass
	public static void runBeforeEachTest() {
		dao = new MedicalTestDAOImpl();
	}
	
	/**
	 * creating persist testcase to check if the data is being added to database or not
	 * @throws NullObjectExcpetion
	 * @throws InvalidInputException
	 */
	@Test
	public void test_Persist_GivenMedicalTest() throws NullObjectExcpetion, InvalidInputException {
		Patient patient = new Patient(1002, "hari", 18, 77588, "22-33-44");
		MedicalTest medicalTest = new MedicalTest(102, patient, "A+", "body");
		dao.persist(medicalTest);
		MedicalTest medicalTestFound = dao.findById(103);
		assertEquals(medicalTest.getMedicalTestName(), medicalTestFound.getMedicalTestName());
	}
	
	/**
	 * creating viewMedicalTest test case to check if it is returning all the details form database in the form of list
	 * @throws EmptyListException
	 */
	@Test
	public void test_ViewMedicalTest_ShouldReturn_ListOfDoctors() throws EmptyListException {
		List<MedicalTest> medicalTestList = dao.findAll();
		assertFalse(medicalTestList.isEmpty());

	}
	
	/**
	 * creating addMedicalTestResults test case to check if test result is added
	 * @throws InvalidInputException
	 */
	@Test
	public void test_AddMedicalTestResults_GivenIdAndStatus() throws InvalidInputException {
		dao.findPatientTestResults(101, "yes");
		MedicalTest medicalTest = dao.findById(101);
		assertEquals("yes", medicalTest.getTestResult());
	}
	
	/**
	 * creating findById test case to check if it is returning data from database based on id
	 * @throws InvalidInputException
	 */
	@Test
	public void test_FindById_GiveMedicalTestId() throws InvalidInputException {
		MedicalTest medicalTest = dao.findById(102);
		assertEquals("skin", medicalTest.getMedicalTestName());

	}
	
	/**
	 * creating removeMedicalTest to check if the detail is removed from the database
	 * @throws InvalidInputException
	 */
	@Test
	public void test_RemoveMedicalTest_ShouldReturnBooleanValue() throws InvalidInputException {
		boolean truth = dao.removeMedicalTest(103);
		assertTrue(truth);

	}
	
	/**
	 * creating editByPatientName test case to check the Patient name is updated
	 * @throws InvalidInputException
	 */
	@Test
	public void test_EditByPatientName_GivenIdAndName() throws InvalidInputException {
		dao.editByPatientName(101, "sindhu");
		MedicalTest medicalTest = dao.findById(101);

		assertEquals("sindhu", medicalTest.getPatient().getPatientName());

	}
	
	/**
	 * creating  editByPatientAge test case to check if the Patient Age is updated
	 * @throws InvalidInputException
	 */
	@Test
	public void test_EditByPatientAge_GivenIdAndAge() throws InvalidInputException {
		dao.editByPatientAge(101, 40);
		MedicalTest medicalTest = dao.findById(101);
		assertEquals(40, medicalTest.getPatient().getPatientAge());
	}
	
	/**
	 * creating editByPatientPhoneNumber test case to check if the Patient phone number is updated
	 * @throws InvalidInputException
	 */
	@Test
	public void test_EditByPatientPhoneNumber_GivenIdAndPhoneNumber() throws InvalidInputException {
		dao.editByPatientPhoneNUmber(101, 1111);
		MedicalTest medicalTest = dao.findById(101);
		assertEquals(1111, medicalTest.getPatient().getPatientPhoneNumber());
	}
	
	/**
	 * creating editByPatientAddress test case to check if the the Patient Address is updated
	 * @throws InvalidInputException
	 */
	@Test
	public void test_EditByPatientAddress_GivenIdAndAddress() throws InvalidInputException {
		dao.editByPatientAddress(101, "1-1-2-8");
		MedicalTest medicalTest = dao.findById(101);
		assertEquals("1-1-2-8", medicalTest.getPatient().getPatientAddress());
	}
	
	/**
	 * creating editByBloodGroup test case to check if the blood group is updated
	 * @throws InvalidInputException
	 */
	@Test
	public void test_EditByBloodGroup_GivenIdAndBloodGroup() throws InvalidInputException {
		dao.edityByBloodGroup(101, "B+");
		MedicalTest medicalTest = dao.findById(101);
		assertEquals("B+", medicalTest.getBloodGroup());
	}

	/**
	 * creating editByTestName test case to check if the test name is updated
	 * @throws InvalidInputException
	 */
	@Test
	public void test_EditByTestName_GivenIdAndTestName() throws InvalidInputException {
		dao.editByTestName(101, "brain");
		MedicalTest medicalTest = dao.findById(101);
		assertEquals("brain", medicalTest.getMedicalTestName());
	}
	
	/**
	 * creating editByTestResults test case to check if the testResults is updated
	 * @throws InvalidInputException
	 */
	@Test
	public void test_EditByTestResultsGivenIdAndResult() throws InvalidInputException {
		dao.editByTestResults(101, "yesss");
		MedicalTest medicalTest = dao.findById(101);
		assertEquals("yesss", medicalTest.getTestResult());
	}
}
