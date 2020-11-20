package com.cg.health_assisst.daoimpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.cg.health_assisst.dao.MedicalTestDAO;
import com.cg.health_assisst.exception.EmptyListException;
import com.cg.health_assisst.exception.InvalidInputException;
import com.cg.health_assisst.exception.NullObjectExcpetion;
import com.cg.health_assisst.model.MedicalTest;
import com.cg.health_assisst.model.Patient;
import com.cg.health_assisst.util.JPAUtil;

/**
 * Creating MedicalTestDAOImpl which implements MedicalTestDAO which implements
 * all the methods
 *
 */
public class MedicalTestDAOImpl implements MedicalTestDAO {
	/**
	 * declaring persist method to save the details to the MedicalTest table
	 * 
	 * @param medicalTest
	 * @throws NullObjectExcpetion
	 */
	@Override
	public void persist(MedicalTest medicalTest) throws NullObjectExcpetion {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		if (medicalTest == null) {
			throw new NullObjectExcpetion("The object has no value");
		}
		em.persist(medicalTest);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * creating FindAll method which returns list of all the details from the
	 * MEdicalTest table
	 */
	@Override
	public List<MedicalTest> findAll() throws EmptyListException {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select m from MedicalTest m");
		List<MedicalTest> medicalTestList = query.getResultList();
		if (medicalTestList.isEmpty()) {
			throw new EmptyListException("The list is empty");
		}
		em.getTransaction().commit();
		em.close();
		return medicalTestList;
	}

	/**
	 * declaring findPatientTestResults method to add the status of test result
	 * 
	 * @param medicalTestIdResults
	 * @param status
	 * @throws InvalidInputException
	 */
	@Override
	public void findPatientTestResults(int medicalTestIdResults, String status) throws InvalidInputException {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		if (medicalTestIdResults == 0 || status == null) {
			throw new InvalidInputException("Invalid Input");
		}
		MedicalTest medicalTest = em.find(MedicalTest.class, medicalTestIdResults);
		medicalTest.setTestResult(status);
		em.getTransaction().commit();
		em.close();

	}

	/**
	 * declaring findById to get the details based on id
	 * 
	 * @param id
	 * @throws InvalidInputException
	 */
	@Override
	public MedicalTest findById(int id) throws InvalidInputException {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		if (id == 0) {
			throw new InvalidInputException("Invalid Id");
		}
		MedicalTest medicalTest = em.find(MedicalTest.class, id);
		em.getTransaction().commit();
		em.close();
		return medicalTest;
	}

	/**
	 * declaring removeMedicalTestId method to remove the medical test details from
	 * detail based on id
	 * 
	 * @param id
	 * @throws InvalidInputException
	 */
	@Override
	public boolean removeMedicalTest(int id) throws InvalidInputException {
		boolean truth = true;
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		if (id == 0) {
			throw new InvalidInputException("Invalid Id");
		}
		MedicalTest medicalTest = em.find(MedicalTest.class, id);
		em.remove(medicalTest);
		MedicalTest test = em.find(MedicalTest.class, id);
		if (test == null) {
			truth = false;
		}
		em.getTransaction().commit();
		em.close();
		return truth;
	}

	/**
	 * declaring editByPatientName method to update Patient name
	 * 
	 * @param id
	 * @param name
	 * @throws InvalidInputException
	 */
	@Override
	public void editByPatientName(int id, String name) throws InvalidInputException {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		if (id == 0 || name == null) {
			throw new InvalidInputException("Invalid Input");
		}
		MedicalTest medicalTest = em.find(MedicalTest.class, id);
		Patient patient = medicalTest.getPatient();
		patient.setPatientName(name);
		em.getTransaction().commit();
		em.close();

	}

	/**
	 * declaring editByPatientAge method to update the Patient age
	 * 
	 * @param id
	 * @param age
	 * @throws InvalidInputException
	 */
	@Override
	public void editByPatientAge(int id, int age) throws InvalidInputException {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		if (id == 0 || age == 0) {
			throw new InvalidInputException("Invalid Input");
		}
		MedicalTest medicalTest = em.find(MedicalTest.class, id);
		Patient patient = medicalTest.getPatient();
		patient.setPatientAge(age);
		em.getTransaction().commit();
		em.close();

	}

	/**
	 * declaring editByPatientPhoneNUmber method to update the phoneNUmber
	 * 
	 * @param id
	 * @param phoneNumber
	 * @throws InvalidInputException
	 */

	@Override
	public void editByPatientPhoneNUmber(int id, long phoneNumber) throws InvalidInputException {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		if (id == 0 || phoneNumber == 0) {
			throw new InvalidInputException("Invalid Input");
		}
		MedicalTest medicalTest = em.find(MedicalTest.class, id);
		Patient patient = medicalTest.getPatient();
		patient.setPatientPhoneNumber(phoneNumber);
		em.getTransaction().commit();
		em.close();

	}

	/**
	 * declaring editPatientAddress method to update the Patient address
	 * 
	 * @param id
	 * @param address
	 * @throws InvalidInputException
	 */
	@Override
	public void editByPatientAddress(int id, String address) throws InvalidInputException {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		if (id == 0 || address == null) {
			throw new InvalidInputException("Invalid Input");
		}
		MedicalTest medicalTest = em.find(MedicalTest.class, id);
		Patient patient = medicalTest.getPatient();
		patient.setPatientAddress(address);
		em.getTransaction().commit();
		em.close();

	}

	/**
	 * declaring editByBloodGroup method to update the bloodgroup
	 * 
	 * @param id
	 * @param bloodGroup
	 * @throws InvalidInputException
	 */
	@Override
	public void edityByBloodGroup(int id, String bloodGroup) throws InvalidInputException {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		if (id == 0 || bloodGroup == null) {
			throw new InvalidInputException("Invalid Input");
		}
		MedicalTest medicalTest = em.find(MedicalTest.class, id);
		medicalTest.setBloodGroup(bloodGroup);
		em.getTransaction().commit();
		em.close();

	}

	/**
	 * declaring editByTestName method to update the test name
	 * 
	 * @param id
	 * @param testName
	 * @throws InvalidInputException
	 */
	@Override
	public void editByTestName(int id, String testName) throws InvalidInputException {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		if (id == 0 || testName == null) {
			throw new InvalidInputException("Invalid Input");
		}
		MedicalTest medicalTest = em.find(MedicalTest.class, id);
		medicalTest.setMedicalTestName(testName);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * declaring editByTestResults method to update the test results
	 * 
	 * @param id
	 * @param testResult
	 * @throws InvalidInputException
	 */
	@Override
	public void editByTestResults(int id, String testResult) throws InvalidInputException {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		if (id == 0 || testResult == null) {
			throw new InvalidInputException("Invalid Input");
		}
		MedicalTest medicalTest = em.find(MedicalTest.class, id);
		medicalTest.setTestResult(testResult);
		em.getTransaction().commit();
		em.close();
	}

}
