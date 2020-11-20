package com.cg.health_assisst;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.health_assisst.daoimpl.DoctorDAOImpl;
import com.cg.health_assisst.exception.EmptyListException;
import com.cg.health_assisst.exception.InvaliIdException;
import com.cg.health_assisst.exception.InvalidInputException;
import com.cg.health_assisst.exception.NullObjectExcpetion;
import com.cg.health_assisst.model.Doctor;

public class DoctorDAOImplTest {

	public static DoctorDAOImpl dao;

	@BeforeClass
	public static void runBeforeEachTest() {
		dao = new DoctorDAOImpl();
	}
	
	/**
	 * creating persist test case to test whether the object is being added to database
	 * @throws NullObjectExcpetion
	 * @throws InvaliIdException
	 */
	@Test
	public void test_Persist_GivenDoctor() throws NullObjectExcpetion, InvaliIdException {
		Doctor doctor = new Doctor(108, "Sindhu", "eye", 55599888, "Sindhu@gmail.com");
		dao.persist(doctor);
		Doctor doctorFound = dao.findById(doctor.getDoctorId());
		assertEquals(doctor.getDoctorName(), doctorFound.getDoctorName());
	}
	
	/**
	 * creating findById test to check we are getting details based on id
	 * @throws InvaliIdException
	 */
	@Test
	public void test_FindById_GivenDoctorId_ShouldReturnDoctor() throws InvaliIdException {
		Doctor doctor = dao.findById(101);
		assertEquals("sush", doctor.getDoctorName());
	}
	
	/**
	 * creating findAll test to check whether it is returning all the list of doctors
	 * @throws EmptyListException
	 */
	@Test
	public void test_FindAll_ShouldReturnListOfDoctors() throws EmptyListException {
		List<Doctor> doctorList = dao.findAll();
		assertFalse(doctorList.isEmpty());

	}
	
	/**
	 * creating findBycategory test case to check whether it is returning list based on specialization
	 * @throws InvalidInputException
	 * @throws EmptyListException
	 */
	@Test
	public void test_FindByCategory_ShouldReturnListOfDoctors() throws InvalidInputException, EmptyListException {
		List<Doctor> categoryList = dao.findByCategory("skin");
		assertNotNull(categoryList);
	}
	
	/**
	 * creating updateBySpecialization test case to check whether the specialization is updated with the given value
	 * @throws InvalidInputException
	 * @throws InvaliIdException
	 */
	@Test
	public void test_UpdateBySpecialization_GivenIdAndSpecialization() throws InvalidInputException, InvaliIdException {
		dao.updateBySpecialization(105, "skin");
		Doctor doctor = dao.findById(105);
		assertEquals("skin", doctor.getDoctorSpecialization());
	}
	
	/**
	 * creating updateByPhoneNumber test case to check whether the phone number is updated with the given value
	 * @throws InvalidInputException
	 * @throws InvaliIdException
	 */
	@Test
	public void test_UpdateByPhoneNumber_GivenIdAndPhoneNumber() throws InvalidInputException, InvaliIdException {
	    dao.updateByPhoneNumber(105, 9959558);
	    Doctor doctor = dao.findById(105);
		assertEquals(9959558, doctor.getDoctoPhoneNumber());
	}
	
	/**
	 * creating updateByEmail test case to check whether the email is updated by given value
	 * @throws InvalidInputException
	 * @throws InvaliIdException
	 */
	@Test
	public void test_UpdateByEmail_GivenIdAndEmail() throws InvalidInputException, InvaliIdException {
		dao.updateByEmail(105, "Aishu10@gmail.com");
		Doctor doctor = dao.findById(105);
		assertEquals("Aishu10@gmail.com", doctor.getDoctorEmail());
	}
	
	/**
	 * creating removeDoctor test case to check whether the doctor detail is removed based on given id
	 * @throws InvaliIdException
	 */
	@Test
	public void test_RemoveDoctor_GivenDoctorId_shouldReturnBooelanValue() throws InvaliIdException {
		boolean returnValue = dao.removeDoctor(106);
		assertTrue(returnValue);

	}
	
}
