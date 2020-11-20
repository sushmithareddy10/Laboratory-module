package com.cg.health_assisst.daoimpl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.postgresql.jdbc2.ArrayAssistantRegistry;
import com.cg.health_assisst.dao.DoctorDAO;
import com.cg.health_assisst.exception.EmptyListException;
import com.cg.health_assisst.exception.InvaliIdException;
import com.cg.health_assisst.exception.InvalidInputException;
import com.cg.health_assisst.exception.NullObjectExcpetion;
import com.cg.health_assisst.model.Doctor;
import com.cg.health_assisst.util.JPAUtil;
import net.bytebuddy.asm.Advice.Return;

/**
 * creating DoctorDAOImpl class which extends JPAUtil and implements DoctorDAO
 * to implement the methods of DoctorDAO
 *
 */
public class DoctorDAOImpl extends JPAUtil implements DoctorDAO {
	/**
	 * declaring persist method to save the doctor details to Doctor table
	 * 
	 * @param doctor
	 * @throws NullObjectExcpetion
	 */
	@Override
	public void persist(Doctor doctor) throws NullObjectExcpetion {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		if (doctor == null) {
			throw new NullObjectExcpetion("The object has no values");
		}
		em.persist(doctor);
		em.getTransaction().commit();
		em.close();

	}

	/**
	 * declaring findById method to get doctor details based on id
	 * 
	 * @param id
	 * @return
	 * @throws InvaliIdException
	 */
	public Doctor findById(int id) throws InvaliIdException {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		if (id == 0) {
			throw new InvaliIdException("The DoctorId is not valid");
		}
		Doctor doctor = em.find(Doctor.class, id);
		em.getTransaction().commit();
		em.close();
		return doctor;
	}

	/**
	 * declaring removeDoctor form Doctor table using doctorId
	 * 
	 * @param doctorId
	 * @return
	 * @throws InvaliIdException
	 */
	@Override
	public boolean removeDoctor(int doctorId) throws InvaliIdException {
		boolean truth = false;
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		if (doctorId == 0) {
			throw new InvaliIdException("The DoctorId is not Valid");
		}
		Doctor doctor = em.find(Doctor.class, doctorId);
		em.remove(doctor);
		Doctor checkDoctor = em.find(Doctor.class, doctorId);
		if (checkDoctor == null) {
			truth = true;
		}
		em.getTransaction().commit();
		em.close();
		return truth;
	}

	/**
	 * declaring findAll method to get details from the Doctor table
	 * 
	 * @throws EmptyListException
	 */
	@Override
	public List<Doctor> findAll() throws EmptyListException {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select d from Doctor d");
		List<Doctor> doctorList = query.getResultList();
		if (doctorList.isEmpty()) {
			throw new EmptyListException("The list is Empty");
		}
		em.getTransaction().commit();
		em.close();
		return doctorList;
	}

	/**
	 * declaring findByCategory to find the doctor details based on specialization
	 * 
	 * @param specialization
	 * @return
	 * @throws InvalidInputException
	 * @throws EmptyListException
	 */
	@Override
	public List<Doctor> findByCategory(String specialization) throws InvalidInputException, EmptyListException {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		if (specialization == null) {
			throw new InvalidInputException("Invalid Specialization");
		}
		Query query = em.createQuery("select d from Doctor d where d.doctorSpecialization= '" + specialization + "'");
		List<Doctor> categoryList = query.getResultList();
		if (categoryList.isEmpty()) {
			throw new EmptyListException("The list is empty");
		}
		em.getTransaction().commit();
		em.close();
		return categoryList;
	}

	/**
	 * declaring updateByName method to update the Doctor name
	 * 
	 * @param int
	 * @param name
	 * @throws InvalidInputException
	 * 
	 */
	@Override
	public void updateByName(int nameId, String name) throws InvalidInputException {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		if (nameId == 0 || name == null) {
			throw new InvalidInputException("Inavlid input");
		}
		Doctor doctor = em.find(Doctor.class, nameId);
		doctor.setDoctorName(name);
		em.getTransaction().commit();
		em.close();

	}

	/**
	 * declaring UpdateBySpecialization method to update the doctor specialization
	 * 
	 * @param specId
	 * @param specialization
	 * @throws InvalidInputException
	 */
	@Override
	public void updateBySpecialization(int specId, String specialization) throws InvalidInputException {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		if (specId == 0 || specialization == null) {
			throw new InvalidInputException("Inavlid Input");
		}
		Doctor doctor = em.find(Doctor.class, specId);
		doctor.setDoctorSpecialization(specialization);
		em.getTransaction().commit();
		em.close();

	}

	/**
	 * declaring updateByPhoneNUmber method to update Doctor phoneNUmber
	 * 
	 * @param phoneId
	 * @param phoneNumber
	 * @throws InvalidInputException
	 */
	@Override
	public void updateByPhoneNumber(int phoneId, long phoneNumber) throws InvalidInputException {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		if (phoneId == 0 || phoneNumber == 0) {
			throw new InvalidInputException("Invalid Input");
		}
		Doctor doctor = em.find(Doctor.class, phoneId);
		doctor.setDoctoPhoneNumber(phoneNumber);
		em.getTransaction().commit();
		em.close();

	}

	/**
	 * declaring updateByEmail method to update Doctor email
	 * 
	 * @param emailId
	 * @param email
	 * @throws InvalidInputException
	 */
	@Override
	public void updateByEmail(int emailId, String email) throws InvalidInputException {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		if (emailId == 0 || email == null) {
			throw new InvalidInputException("Invalid Input");
		}
		Doctor doctor = em.find(Doctor.class, emailId);
		doctor.setDoctorEmail(email);
		em.getTransaction().commit();
		em.close();

	}

}
