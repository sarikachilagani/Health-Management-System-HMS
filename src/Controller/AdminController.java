package Controller;

import java.util.Scanner;

import Model.DoctorModel;
import Model.PatientModel;
import Service.AdminService;

public class AdminController {

	private void patientAdd(Scanner sc) {
		System.out.println("Enter patientId:");
		int patientId = sc.nextInt();
		System.out.println("Enter patientName:");
		String patientname = sc.next();
		System.out.println("Enter phoneNumber:");
		int phone = sc.nextInt();
		System.out.println("Enter diseaseId:");
		int diseaseId = sc.nextInt();
		
		PatientModel patient = new PatientModel();
		patient.setPatientId(patientId);
		patient.setPatientName(patientname);
		patient.setPhone(phone);
		patient.setDiseaseId(diseaseId);
		
		AdminService admin=new AdminService();
		admin.patientSave(patient);
		System.out.println("details added sucessful:");
	}
	
	private static void patientDelete(Scanner sc) {
		System.out.println("please enter patientName you want delete:");
		String patientname = sc.next();
		
		PatientModel patient = new PatientModel();
		patient.setPatientName(patientname);
		
		AdminService admin=new AdminService();
		admin.patientRemove(patient);
		System.out.println("patient details deleted sucessful:");
	}
	
	private void doctorAdd(Scanner sc) {
		System.out.println("Enter doctorId:");
		int doctorId = sc.nextInt();
		System.out.println("Enter doctorName:");
		String doctorName = sc.next();
		System.out.println("Enter phoneNumber:");
		int phone = sc.nextInt();
		System.out.println("Enter diseaseId:");
		int diseaseId = sc.nextInt();
		
		DoctorModel doctor = new DoctorModel();
		doctor.setDoctorId(doctorId);
		doctor.setDoctorName(doctorName);
		doctor.setPhone(phone);
		doctor.setDiseaseId(diseaseId);
		
		AdminService admin=new AdminService();
		admin.doctorSave(doctor);
		System.out.println("details added sucessful:");
	}
	
	private void doctorDelete(Scanner sc) {
		System.out.println("please enter doctorName you want delete:");
		String doctorName = sc.next();
		
		DoctorModel doctors = new DoctorModel();
		doctors.setDoctorName(doctorName);
		
		AdminService admin=new AdminService();
		admin.doctorRemove(doctors);
		System.out.println("doctor details deleted sucessful:");
	}
	
	public void adminAction() {
	System.out.println("HMS-Enter which type would you like to add/remove:");
	System.out.println("1.Patient");
	System.out.println("2.Doctor");
	Scanner sc=new Scanner(System.in);
	String value2=sc.next();
	if(value2.equalsIgnoreCase("Patient")) {
		System.out.println("HMS-choose action:");
		System.out.println("1.Add");
		System.out.println("2.Remove");
		int value3=sc.nextInt();
		switch(value3) {
		case 1:{
			patientAdd(sc);
			break;
		}
		case 2:{
			patientDelete(sc);
			break;
		}
		}
	}else {
		System.out.println("HMS-choose action:");
		System.out.println("1.Add");
		System.out.println("2.Remove");
		int value4=sc.nextInt();
		switch(value4) {
		case 1:{
			doctorAdd(sc);
			break;
		}
		case 2:{
			doctorDelete(sc);
			break;
		}
	}
	}
	}
}
