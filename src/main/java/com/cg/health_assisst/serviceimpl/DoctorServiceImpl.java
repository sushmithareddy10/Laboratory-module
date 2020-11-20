package com.cg.health_assisst.serviceimpl;

import java.util.*;
import com.cg.health_assisst.dao.DoctorDAO;
import com.cg.health_assisst.daoimpl.DoctorDAOImpl;
import com.cg.health_assisst.exception.EmptyListException;
import com.cg.health_assisst.exception.InvaliIdException;
import com.cg.health_assisst.exception.InvalidInputException;
import com.cg.health_assisst.exception.NullObjectExcpetion;
import com.cg.health_assisst.model.Doctor;
import com.cg.health_assisst.service.DoctorService;

/**
 * creating DoctorServiceImpl class which implements DoctorService Interface to
 * implement the methods
 *
 */
public class DoctorServiceImpl implements DoctorService {
	/**
	 * declaring a private variable doctoDAO;
	 */
	private DoctorDAO doctorDAO;

	/**
	 * declaring constructor of the DoctorServiceImpl class to create object for
	 * DoctorDAOImpl
	 */
	public DoctorServiceImpl() {
		doctorDAO = new DoctorDAOImpl();
	}

	/**
	 * declaring addDoctor method to add Doctor details into the Doctor table
	 * 
	 * @param doctor
	 */
	@Override
	public void addDoctor(Doctor doctor) {
		try {
			doctorDAO.persist(doctor);
		} catch (NullObjectExcpetion e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * declaring viewAvailable Doctors method to view all the available doctors from
	 * Doctor Table
	 * 
	 * @return
	 */
	@Override
	public List<Doctor> viewAvailableDoctors() {
		List<Doctor> doctorList = new ArrayList<>();
		try {
			doctorList = doctorDAO.findAll();
		} catch (EmptyListException e) {
			System.out.println(e.getMessage());

		}
		return doctorList;
	}

	/**
	 * declaring viewAllAvailableDoctorsOnCatergory to view the list of doctors
	 * based on specialization
	 * 
	 * @param specialization
	 * @return
	 */
	@Override
	public List<Doctor> viewAvailableDoctorsOnCategory(String specialization) {
		List<Doctor> categoryList = new ArrayList<>();
		try {
			categoryList = doctorDAO.findByCategory(specialization);
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		} catch (EmptyListException e) {
			System.out.println(e.getMessage());
		}
		return categoryList;
	}

	/**
	 * declaring removeDoctor method to remove the doctor based on id and returns
	 * boolean value
	 * 
	 * @param removeDoctorId
	 * @return
	 */
	@Override
	public boolean removeDoctor(int removeDoctorId) {
		boolean truth = false;
		try {
			truth = doctorDAO.removeDoctor(removeDoctorId);
		} catch (InvaliIdException e) {
			System.out.println(e.getMessage());
		}
		return truth;
	}

	/**
	 * declaring editName method to update the Doctor name based on id
	 * 
	 * @param nameId
	 * @param name
	 */
	@Override
	public void editName(int nameId, String name) {
		try {
			doctorDAO.updateByName(nameId, name);
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * declaring editSpecialization to update the Doctor specialization based on id
	 * 
	 * @param specId
	 * @param specialization
	 */
	@Override
	public void editSpecialization(int specId, String specialization) {
		try {
			doctorDAO.updateBySpecialization(specId, specialization);
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * declaring editPhoneNumber to update the phone number of the Doctor based on
	 * id
	 * 
	 * @param phoneId
	 * @param phoneNumber
	 */
	@Override
	public void editPhoneNumber(int phoneId, long phoneNumber) {
		try {
			doctorDAO.updateByPhoneNumber(phoneId, phoneNumber);
		} catch (InvalidInputException e) {
			System.out.println("Invalid Input");
		}

	}

	/**
	 * declaring editEmail to update the email of the Doctor based on id
	 * 
	 * @param emailId
	 * @param email
	 */
	@Override
	public void editEmail(int emailId, String email) {
		try {
			doctorDAO.updateByEmail(emailId, email);
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}

	}

}
