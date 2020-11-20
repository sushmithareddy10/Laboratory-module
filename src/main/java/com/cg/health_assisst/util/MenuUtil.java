package com.cg.health_assisst.util;

/**
 * creating menu util class to create menu for the services provided for Laboratory Admin
 * @author SUSHMITHA
 *
 */
import java.util.*;

import org.hibernate.internal.build.AllowSysOut;

import com.cg.health_assisst.dao.MedicalTestDAO;
import com.cg.health_assisst.model.Doctor;
import com.cg.health_assisst.model.MedicalTest;
import com.cg.health_assisst.model.Patient;
import com.cg.health_assisst.service.DoctorService;
import com.cg.health_assisst.service.MedicalTestService;
import com.cg.health_assisst.serviceimpl.DoctorServiceImpl;
import com.cg.health_assisst.serviceimpl.MedicalTestServiceImpl;

public class MenuUtil {
	/**
	 * declaring Scanner object to scan the input from the user
	 */
	Scanner sc = new Scanner(System.in);
	/**
	 * declaring mainMenu String variable to check for do while loop
	 */
	String mainMenu = "Yes";

	/**
	 * declaring startApp method to show the Menu of Laboratory Admin
	 */
	public void startApp() {
		/**
		 * creating a do while loop to show the menu until user says NO
		 */
		do {
			/**
			 * calling showMainMenu method which shows the laboratory admin
			 */
			showMainMenu();
			/**
			 * asking the input from the user to choose either Doctor or MedicalTest
			 */
			System.out.println("Enter the choice from Main Menu");
			int mainMenuChoice = sc.nextInt();
			/**
			 * if choice is 1 it calls Doctor Menu
			 */
			if (mainMenuChoice == 1) {
				doctorMenu();
			}
			/**
			 * if choice is 2 it calls for Medical Test Menu
			 */
			else if (mainMenuChoice == 2) {
				medicalTestMenu();

			}
			/**
			 * if choice is not either 1 or 2
			 */
			else {

				System.out.println("Enter the correct choice");
			}
			/**
			 * asking to continue with Main Menu and scanning input from user
			 */
			System.out.println("Do you want to continue Main Menu [Yes/No]: ");
			mainMenu = sc.next();
		} while (mainMenu.equalsIgnoreCase("Yes"));

	}

	/**
	 * declaring the medicalTestMenu to display the Medical Test menu
	 */
	private void medicalTestMenu() {
		System.out.println("---------Medical Test Menu-----------");
		System.out.println("1. Add MedicalTest");
		System.out.println("2. Edit MedicalTest");
		System.out.println("3. Remove MedicalTest");
		System.out.println("4. View MedicalTest");
		System.out.println("5. Add Patient Test Results");
		System.out.println("6. View Medical Test by Id");
		/**
		 * asking to enter the choice and scanning the input from user
		 */
		System.out.println("Enter the choice from MedicalTest Menu");
		int medicalTestChoice = sc.nextInt();
		/**
		 * calling the medicalTestMenuOperations send choice as parameter
		 */
		medicalTestMenuOperations(medicalTestChoice);

	}

	/**
	 * creating medicalTestMenuOperations method to do the operations based on
	 * choice given by user
	 * 
	 * @param medicalTestChoice
	 */
	private void medicalTestMenuOperations(int medicalTestChoice) {
		/**
		 * declaring object for MedicalTestServiceImpl class
		 */
		MedicalTestServiceImpl medicalTestService = new MedicalTestServiceImpl();
		/**
		 * Using switch case to move between the choices
		 */
		switch (medicalTestChoice) {
		case 1:
			/**
			 * scanning medicalTestId from user
			 */
			System.out.println("Enter the Medical Test Id: ");
			int medicalTestId = sc.nextInt();
			/**
			 * scanning Patient id form user
			 */
			System.out.println("Enter the Patient Id: ");
			int patientId = sc.nextInt();
			/**
			 * scanning Patient name form user
			 */
			System.out.println("Enter the Patient Name: ");
			String patientName = sc.next();
			sc.nextLine();
			/**
			 * scanning Patient age from user
			 */
			System.out.println("Enter the Patient Age: ");
			int patientAge = sc.nextInt();
			/**
			 * scanning Patient phone number form user
			 */
			System.out.println("Enter the Patient Phone Number: ");
			long patientPhoneNumber = sc.nextLong();
			/**
			 * scanning Patient address from the user
			 */
			System.out.println("Enter the Patient Address: ");
			String patientAddress = sc.next();
			sc.nextLine();
			/**
			 * scanning the Patient bloodGroup from the user
			 */
			System.out.println("Enter the Patient Blood Group");
			String bloodGroup = sc.next();
			sc.nextLine();
			/**
			 * scanning the Patient medicalTest name from user
			 */
			System.out.println("Enter the Medical Test Name: ");
			String medicalTestName = sc.next();
			sc.nextLine();
			/**
			 * creating object for Patient class and passing Patient values
			 */
			Patient patient = new Patient(patientId, patientName, patientAge, patientPhoneNumber, patientAddress);
			/**
			 * creating object for MEdicalTest class and passing Medical TEst value
			 */
			MedicalTest medicalTest = new MedicalTest(medicalTestId, patient, bloodGroup, medicalTestName);
			/**
			 * calling the addMedicalTest method
			 */
			medicalTestService.addMedicalTest(medicalTest);
			break;

		case 2:
			/**
			 * calling the editMedicalTest method
			 */
			editMedicalTest();
			break;

		case 3:
			/**
			 * scanning the id form user to remove the details from table
			 */
			System.out.println("Enter the Medical Test Id to remove: ");
			int removeMedicalTest = sc.nextInt();
			/**
			 * calling the removeMedicalTest which returns boolean value
			 */
			boolean truth = medicalTestService.removeMedicalTest(removeMedicalTest);
			/**
			 * checking for condition if it is successfully removed
			 */
			if (truth) {
				System.out.println("Successfully removed!");
			} else {
				System.out.println("Could not remove the Medical Test");
			}
			break;
		case 4:
			/**
			 * calling viewMedicalTest method which returns list of Medical Test details
			 * from the table
			 */
			List<MedicalTest> medicalTestList = medicalTestService.viewMedicalTest();
			System.out.println(medicalTestList);
			break;
		case 5:
			/**
			 * scanning the id from the user to add the status of Patient medical test
			 * results
			 */
			System.out.println("Enter the Id of the MedicalTest: ");
			int medicalTestIdStatus = sc.nextInt();
			/**
			 * scanning the status of medical test from the user
			 */
			System.out.println("Enter the status of the Medical Test: ");
			String statusOfPateintTest = sc.next();
			sc.nextLine();
			/**
			 * calling the addPatientMedicalTestResults method by passing the values
			 */
			medicalTestService.addPatientMedicalTestResults(medicalTestIdStatus, statusOfPateintTest);
			break;
		case 6:
			/**
			 * scanning the id form the user to view the medical test details from table
			 * based on id
			 */
			System.out.println("Enter the Id to serach for: ");
			int id = sc.nextInt();
			/**
			 * calling the viewMedicalTestById by passing the values
			 */
			MedicalTest medicalTestById = medicalTestService.viewMedicalTestById(id);
			System.out.println(medicalTestById);
			break;
		default:
			/**
			 * default choice print statement
			 */
			System.out.println("Enter the correct choice");

		}

	}

	/**
	 * creating editMedicaTest method to edit the details of the Medical Test table
	 */
	private void editMedicalTest() {
		/**
		 * creating object for medicalTestServiceImpl class
		 */
		MedicalTestServiceImpl medicalTestService = new MedicalTestServiceImpl();
		/**
		 * displaying the menu for editing the details
		 */
		System.out.println("1. Edit Patient");
		System.out.println("2. Edit Blood Group");
		System.out.println("3. Edit Medical Test Name");
		System.out.println("4. Edit Test Result");
		/**
		 * scanning the choice from the user
		 */
		System.out.println("Enter the choice from above edit Medical Test menu: ");
		int editMedicalChoice = sc.nextInt();
		/**
		 * using switch case to switch between choices
		 */
		switch (editMedicalChoice) {
		case 1:
			/**
			 * calling editPatientMenu method to edit the Patient details
			 */
			editPatientMenu();
			break;
		case 2:
			/**
			 * scanning the id from user
			 */
			System.out.println("Enter the Medical Test id: ");
			int medicalId = sc.nextInt();
			sc.nextLine();
			/**
			 * scanning the blood group from user
			 */
			System.out.println("Enter the Blood Group: ");
			String bloodGroup = sc.next();
			/**
			 * calling the editBloodGroup from method by passing values
			 */
			medicalTestService.editByBloodGroup(medicalId, bloodGroup);
			break;
		case 3:
			/**
			 * scanning the id from user
			 */
			System.out.println("Enter the Medical Test id: ");
			int testNameId = sc.nextInt();
			sc.nextLine();
			/**
			 * scanning the name form the user
			 */
			System.out.println("Enter the test name: ");
			String testName = sc.next();
			/**
			 * calling the editByName by passing the values
			 */
			medicalTestService.editByTestName(testNameId, testName);
			break;
		case 4:
			/**
			 * scanning the id from the user
			 */
			System.out.println("Enter the Medical Test Id: ");
			int resultId = sc.nextInt();
			sc.nextLine();
			/**
			 * scanning the test result form the user
			 */
			System.out.println("Enter the test result: ");
			String testResult = sc.next();
			/**
			 * calling the editByTestResult by passing the values
			 */
			medicalTestService.editByTestResult(resultId, testResult);
			break;
		default:
			/**
			 * if the user enters default input
			 */
			System.out.println("Enter the correct choice");
			break;

		}

	}

	/**
	 * creating editPatientMenu method to edit the Patient details in the table
	 */
	private void editPatientMenu() {
		/**
		 * creating object for medicalTestService for MedicalTestServiceImpl
		 */
		MedicalTestServiceImpl medicalTestService = new MedicalTestServiceImpl();
		/**
		 * displaying the Patient to edit
		 */
		System.out.println("1. Edit Name");
		System.out.println("2. Edit Age");
		System.out.println("3. Edit Phone Number");
		System.out.println("4. Edit Address");
		/**
		 * scanning the choice from the user
		 */
		System.out.println("Enter the choice from above Pateint Menu: ");
		int editPatientChoice = sc.nextInt();
		/**
		 * using scanner to switch between choices
		 */
		switch (editPatientChoice) {
		case 1:
			/**
			 * scanning id from user
			 */
			System.out.println("Enter the MedicalTest Id: ");
			int nameId = sc.nextInt();
			sc.nextLine();
			/**
			 * scanning name from user
			 */
			System.out.println("Ente the name: ");
			String name = sc.next();
			/**
			 * calling editByPatientName by passing values
			 */
			medicalTestService.editByPatientName(nameId, name);
			break;

		case 2:
			/**
			 * scanning the id from user
			 */
			System.out.println("Enter the Medical Test Id: ");
			int ageId = sc.nextInt();
			/**
			 * scanning the age from user
			 */
			System.out.println("Enter the age: ");
			int age = sc.nextInt();
			/**
			 * calling the editByPatientAge by passing the values
			 */
			medicalTestService.editByPatientAge(ageId, age);
			break;
		case 3:
			/**
			 * scanning the id from user
			 */
			System.out.println("Enter the Medical Test Id: ");
			int phoneId = sc.nextInt();
			/**
			 * scanning the phone number form user
			 */
			System.out.println("Enter the Phone Number: ");
			long phoneNumber = sc.nextLong();
			/**
			 * calling the editByPhoneNumber method by passing the values
			 */
			medicalTestService.editByPhoneNumber(phoneId, phoneNumber);
			break;
		case 4:
			/**
			 * scanning the id from the user
			 */
			System.out.println("Ente the Medical Test Id: ");
			int addressId = sc.nextInt();
			sc.nextLine();
			/**
			 * scanning the address from the user
			 */
			System.out.println("Enter the Address: ");
			String address = sc.next();
			/**
			 * calling the editByAddress method by passing the values
			 */
			medicalTestService.editByAddress(addressId, address);
			break;
		default:
			/**
			 * if default choice is entered
			 */
			System.out.println("Enter the correct choice");
			break;
		}

	}

	/**
	 * creating doctorMenuOperations menu to perform the operations of Doctor model
	 * 
	 * @param doctorChoice
	 */
	private void doctorMenuOperations(int doctorChoice) {
		/**
		 * creating object doctorService for DoctorServiceImpl class
		 */
		DoctorServiceImpl doctorService = new DoctorServiceImpl();
		/**
		 * using switch case to switch between the choices
		 */
		switch (doctorChoice) {
		case 1:
			/**
			 * scanning the id from user
			 */
			System.out.println("Enter the Doctor Id: ");
			int doctorId = sc.nextInt();
			/**
			 * scanning the name from the user
			 */
			System.out.println("Enter the Doctor Name: ");
			String doctorName = sc.next();
			sc.nextLine();
			/**
			 * scanning the specialization from the user
			 */
			System.out.println("Enter the Doctor Specialization: ");
			String doctorSpecialization = sc.nextLine();
			/**
			 * scanning the phone number from the user
			 */
			System.out.println("Ente the Doctor Phone Number: ");
			long doctorPhoneNumber = sc.nextLong();
			sc.nextLine();
			/**
			 * scanning the email from the user
			 */
			System.out.println("Enter the Doctor Email: ");
			String doctorEmail = sc.nextLine();
			/**
			 * creating object for doctor class and passing values
			 */
			Doctor doctor = new Doctor(doctorId, doctorName, doctorSpecialization, doctorPhoneNumber, doctorEmail);
			/**
			 * calling the addDoctor method by passing the object
			 */
			doctorService.addDoctor(doctor);
			break;

		case 2:
			/**
			 * calling the doctorEdit menu to edit the details of Doctor
			 */
			doctorEditMenu();
			break;
		case 3:
			/**
			 * scanning the id from user
			 */
			System.out.println("Ente the Doctor id you want to remove: ");
			int removeDoctorId = sc.nextInt();
			/**
			 * calling the removeDoctor method to remove the details from the table which
			 * returns boolean value
			 */
			boolean truth = doctorService.removeDoctor(removeDoctorId);
			/**
			 * it checks for condition whether it is successfully removed
			 */
			if (truth) {
				System.out.println("The data has been removed successfully!");
			} else {
				System.out.println("The data is not removed successfully");
			}
			break;
		case 4:
			/**
			 * calling the viewAvailableDoctors method which returns the list of doctors
			 * present in the table
			 */
			List<Doctor> doctorList = doctorService.viewAvailableDoctors();
			/**
			 * displaying the doctors list
			 */
			System.out.println("These are the available doctors:");
			System.out.println(doctorList);
			break;
		case 5:
			/**
			 * scanning the specialization form the user
			 */
			System.out.println("Ente the Specialization of doctor: ");
			String specialization = sc.next();
			/**
			 * calling the viewAvaulableDoctorsOnCategory method which returns list of
			 * doctor details based on category
			 */
			List<Doctor> specializationList = doctorService.viewAvailableDoctorsOnCategory(specialization);
			System.out.println(specializationList);
			break;
		default:
			/**
			 * if the choice is default
			 */
			System.out.println("Enter the correct choice :");
			break;

		}

	}

	/**
	 * creating doctorEditMenu to edit the details of doctor in Doctor table
	 */
	private void doctorEditMenu() {
		/**
		 * creating doctorService object for DoctorServiceImpl class
		 */
		DoctorServiceImpl doctorService = new DoctorServiceImpl();
		/**
		 * displaying the menu for Edit Doctor
		 */
		System.out.println("1. Edit Doctor Name");
		System.out.println("2. Edit Doctor Specialization");
		System.out.println("3. Edit Doctor Phone Number");
		System.out.println("4. Edit Doctor Email");
		/**
		 * scanning the choice from the user
		 */
		System.out.println("Enter the choice from above edit menu: ");
		int editChoice = sc.nextInt();
		/**
		 * using switch case to move between choice
		 */
		switch (editChoice) {
		case 1:
			/**
			 * scanning the id from the user
			 */
			System.out.println("Enter the id you want to id: ");
			int nameId = sc.nextInt();
			sc.nextLine();
			/**
			 * scanning the name from the user
			 */
			System.out.println("Ente the name: ");
			String name = sc.next();
			/**
			 * calling the editName method by passing the values
			 */
			doctorService.editName(nameId, name);
			break;
		case 2:
			/**
			 * scanning the id from the user
			 */
			System.out.println("Enter the id you want to id: ");
			int specId = sc.nextInt();
			sc.nextLine();
			/**
			 * scanning the specialization from the user
			 */
			System.out.println("Entert the specialization: ");
			String specialization = sc.next();
			/**
			 * calling the editSpecialization method by passing the values
			 */
			doctorService.editSpecialization(specId, specialization);
			break;
		case 3:
			/**
			 * scanning the id from the user
			 */
			System.out.println("Enter the id you want to id: ");
			int phoneId = sc.nextInt();
			/**
			 * scanning the phone number from the user
			 */
			System.out.println("Enter the phone number: ");
			long phoneNumber = sc.nextLong();
			/**
			 * calling the editPhoneNumber method by passing the values
			 */
			doctorService.editPhoneNumber(phoneId, phoneNumber);
			break;
		case 4:
			/**
			 * scanning the id from the user
			 */
			System.out.println("Enter the id you want to id: ");
			int emailId = sc.nextInt();
			sc.nextLine();
			/**
			 * scanning the email from the user
			 */
			System.out.println("Enter the email: ");
			String email = sc.next();
			/**
			 * calling the editEmail method by passing the values
			 */
			doctorService.editEmail(emailId, email);
			break;
		default:
			System.out.println("Enter the correct choice");
			break;
		}

	}

	/**
	 * creating doctorMenu method to display the menu for Doctor model
	 */
	private void doctorMenu() {
		/**
		 * displaying the doctor menu
		 */
		System.out.println("-------Doctor Menu------");
		System.out.println("1. Add Doctor");
		System.out.println("2. Edit Doctor");
		System.out.println("3. Remove Doctor");
		System.out.println("4. View list of available Doctors");
		System.out.println("5. View list of available Doctors based on category");
		/**
		 * scanning the choice from the user
		 */
		System.out.println("Enter the choice from Doctor Menu :");
		int doctorChoice = sc.nextInt();
		/**
		 * calling the doctorMenuOperations
		 */
		doctorMenuOperations(doctorChoice);

	}

	/**
	 * displaying the Main Menu options
	 */
	private void showMainMenu() {
		System.out.println("-----------Laboratory Admin-----------");
		System.out.println("1.Doctor Menu");
		System.out.println("2. MedicalTest Menu");

	}

}
