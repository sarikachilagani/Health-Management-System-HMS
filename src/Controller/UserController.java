package Controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import Model.DoctorModel;
import Model.PatientModel;
import Model.UserModel;
import Service.DoctorService;
import Service.PatientService;
import Service.UserService;

public class UserController {

	private static void signup(Scanner sc) {
		System.out.println("Enter your userName:");
		String name = sc.next();
		System.out.println("Enter your password:");
		String pass = sc.next();
		System.out.println("Enter your Email:");
		String email = sc.next();
		System.out.println("Enter your phoneNumber:");
		int phone = sc.nextInt();

		UserModel userModel = new UserModel();
		userModel.setUserName(name);
		userModel.setEmail(email);
		userModel.setPassword(pass);
		userModel.setPhone(phone);

		UserService userService = new UserService();
		userService.signupSave(userModel);

		System.out.println("Signup completed sucessful:");
	}

	private static void process(Scanner sc) {
		System.out.println("HMS-Choose role to login:");
		System.out.println("1.Admin");
		System.out.println("2.Doctor");
		System.out.println("3.patient");
		int value1 = sc.nextInt();
		switch (value1) {
		case 1: {
			System.out.println("1.Signup");
			System.out.println("2.Login");
			int value = sc.nextInt();

			switch (value) {
			case 1: {
				signup(sc);
				break;
			}
			case 2: {
				boolean isLoginSucessful = login(sc);
				if (isLoginSucessful) {
					AdminController admin = new AdminController();
					admin.adminAction();
					break;
				}
			}
			}

			break;
		}
		case 2: {
			System.out.println("1.Signup");
			System.out.println("2.Login");
			int value = sc.nextInt();

			switch (value) {
			case 1: {
				signup(sc);
				break;
			}
			case 2: {
				if (login(sc)) {
					System.out.println("--------------------------------------");
					System.out.println("enter doctorName:");
					String name = sc.next();

					DoctorModel doctor = new DoctorModel();
					doctor.setDoctorName(name);

					DoctorService doctorservice = new DoctorService();
					List<PatientModel> patientList = doctorservice.getPatientDetails(doctor);

					for (int i = 0; i < patientList.size(); i++) {
						PatientModel details = patientList.get(i);
						System.out.println(details.getPatientId() + " " + details.getPatientName() + " "
								+ details.getPatientAge() + " " + details.getEmail());
					}
					
				}
				break;
			}

				
			}
			break;
		}

		case 3: {

			System.out.println("1.Signup");
			System.out.println("2.Login");
			int value = sc.nextInt();

			switch (value) {
			case 1: {
				signup(sc);
				break;
			}
			case 2: {
				if (login(sc)) {
					System.out.println("--------------------------------------");
					System.out.println("Enter patientName to get prescription/medicine:");
					String name = sc.next();

					PatientModel patient = new PatientModel();
					patient.setPatientName(name);

					PatientService patientservice = new PatientService();
					String medicines = patientservice.getMedicines(patient);
					System.out.println("Prescription/medicine:");
					System.out.println(medicines);
					break;
				}
			}
			}
			break;
		}
		}
	}

	private static boolean login(Scanner sc) {
		System.out.println("Enter your userName:");
		String name = sc.next();
		System.out.println("Enter your password:");
		String pass = sc.next();

		UserModel userModel = new UserModel();
		userModel.setUserName(name);
		userModel.setPassword(pass);

		UserService userService = new UserService();
		boolean result;
		try {
			result = userService.loginSave(userModel);
			if (result) {
				System.out.println("Login is successful");
				// process(sc);
				return true;
			} else {
				System.out.println("Login failed");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) throws SQLException {

		System.out.println("Health Managment System");
//		System.out.println("1.Signup");
//		System.out.println("2.Login");

		Scanner sc = new Scanner(System.in);

		process(sc);

//		switch (value) {
//		case 1: {
//			signup(sc);
//			break;
//		}
//		case 2: {
//			login(sc);
//			break;
//		}
//		}

	}

}
