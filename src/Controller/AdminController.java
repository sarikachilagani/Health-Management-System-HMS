package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.DiseaseModel;
import Model.DoctorModel;
import Model.PatientModel;
import Service.AdminService;

public class AdminController {

	private void patientAdd(Scanner sc) {
		System.out.println("Enter patientId:");
		int patientId = sc.nextInt();
		System.out.println("Enter patientName:");
		String patientname = sc.next();
		System.out.println("Enter patientAge:");
		int age = sc.nextInt();
		System.out.println("Enter Gender:");
		String gender = sc.next();
		System.out.println("Enter Email:");
		String email = sc.next();
		System.out.println("Enter phoneNumber:");
		int phone = sc.nextInt();
		System.out.println("Enter diseaseId:");

		System.out.println("--------------------------------------");
		AdminService disease = new AdminService();
		List<DiseaseModel> list = disease.diseaseDetails();

		for (DiseaseModel myvalue:list) {
			System.out.println(myvalue.getDiseaseId() +"->"+myvalue.getDiseaseNmae()+"->"+myvalue.getMedicine());
		}
		System.out.println("--------------------------------------");

		int diseaseId = sc.nextInt();

		PatientModel patient = new PatientModel();
		patient.setPatientId(patientId);
		patient.setPatientName(patientname);
		patient.setPatientAge(age);
		patient.setGender(gender);
		patient.setEmail(email);
		patient.setPhone(phone);
		patient.setDiseaseId(diseaseId);

		AdminService admin = new AdminService();
		admin.patientSave(patient);
		System.out.println("details added sucessful:");
	}

	private static void patientDelete(Scanner sc) {
		System.out.println("please enter patientName you want delete:");
		String patientname = sc.next();

		PatientModel patient = new PatientModel();
		patient.setPatientName(patientname);

		AdminService admin = new AdminService();
		admin.patientRemove(patient);
		System.out.println("patient details deleted sucessful:");
	}

	private static void patientUpdate(Scanner sc) {
		System.out.println("please enter patientId you want update:");
		int patientId = sc.nextInt();

		System.out.println("please enter patientName you want update:");
		String patientName = sc.next();

		PatientModel patient = new PatientModel();
		patient.setPatientId(patientId);
		patient.setPatientName(patientName);

		AdminService admin = new AdminService();
		admin.patientUpdate(patient);
		System.out.println("patient details updated sucessful:");
	}

	private void doctorAdd(Scanner sc) {
		System.out.println("Enter doctorId:");
		int doctorId = sc.nextInt();
		System.out.println("Enter doctorName:");
		String doctorName = sc.next();
		System.out.println("Enter phoneNumber:");
		int phone = sc.nextInt();
		System.out.println("Enter email:");
		String email = sc.next();
		System.out.println("Enter specialist:");
		String specialist = sc.next();
		System.out.println("Enter yearOfExperience:");
		int experience = sc.nextInt();

		System.out.println("Enter diseaseId:");
		int diseaseId = sc.nextInt();

		DoctorModel doctor = new DoctorModel();
		doctor.setDoctorId(doctorId);
		doctor.setDoctorName(doctorName);
		doctor.setPhone(phone);
		doctor.setEmail(email);
		doctor.setSpecialist(specialist);
		doctor.setExperience(experience);
		doctor.setDiseaseId(diseaseId);

		AdminService admin = new AdminService();
		admin.doctorSave(doctor);
		System.out.println("details added sucessful:");
	}

	private void doctorDelete(Scanner sc) {
		System.out.println("please enter doctorName you want delete:");
		String doctorName = sc.next();

		DoctorModel doctors = new DoctorModel();
		doctors.setDoctorName(doctorName);

		AdminService admin = new AdminService();
		admin.doctorRemove(doctors);
		System.out.println("doctor details deleted sucessful:");
	}

	private void doctorUpdate(Scanner sc) {
		System.out.println("please enter doctorId:");
		int doctorId = sc.nextInt();

		System.out.println("please enter doctorName you want update:");
		String doctorName = sc.next();

		DoctorModel doctors = new DoctorModel();
		doctors.setDoctorId(doctorId);
		doctors.setDoctorName(doctorName);

		AdminService admin = new AdminService();
		admin.doctorUpdate(doctors);
		System.out.println("doctor details updated sucessful:");
	}

	public void adminAction() {
		System.out.println("HMS-Enter which type would you like to add/remove/update:");
		System.out.println("1.Patient");
		System.out.println("2.Doctor");
		Scanner sc = new Scanner(System.in);
		int value2 = sc.nextInt();
		if (value2 == 1) {
			System.out.println("HMS-choose action:");
			System.out.println("1.Add");
			System.out.println("2.Remove");
			System.out.println("3.update");
			int value3 = sc.nextInt();
			switch (value3) {
			case 1: {
				patientAdd(sc);
				break;
			}
			case 2: {
				patientDelete(sc);
				break;
			}
			case 3: {
				patientUpdate(sc);
				break;
			}
			}
		} else {
			System.out.println("HMS-choose action:");
			System.out.println("1.Add");
			System.out.println("2.Remove");
			System.out.println("3.update");
			int value4 = sc.nextInt();
			switch (value4) {
			case 1: {
				doctorAdd(sc);
				break;
			}
			case 2: {
				doctorDelete(sc);
				break;
			}
			case 3: {
				doctorUpdate(sc);
				break;
			}
			}
		}
	}
}
