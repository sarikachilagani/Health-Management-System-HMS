package Controller;

import java.sql.SQLException;
import java.util.Scanner;
import Model.UserModel;
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
		System.out.println("HMS-Choose entity to login:");
		System.out.println("1.Admin");
		System.out.println("2.Doctor");
		System.out.println("3.patient");
		int value1 = sc.nextInt();
		switch (value1) {
		case 1: {
			AdminController admin = new AdminController();
			admin.adminAction();
			break;
		}
		case 2: {

		}

		}
	}

	private static void login(Scanner sc) {
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
				process(sc);
			} else {
				System.out.println("Login failed");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {

		System.out.println("Health Managment System");
		System.out.println("1.Signup");
		System.out.println("2.Login");

		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();

		switch (value) {
		case 1: {
			signup(sc);
			break;
		}
		case 2: {
			login(sc);
			break;
		}
		}

	}

}
