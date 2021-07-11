package Service;

import Connection.Util;
import Model.DoctorModel;
import Model.PatientModel;

public class AdminService {

	public boolean patientSave(PatientModel patient) {

		String insertSql = "insert into patients values('" + patient.getPatientId() + "','" + patient.getPatientName()
				+ "','" + patient.getPhone() + "'," + patient.getDiseaseId() + ")";

		Util util = new Util();
		int result = util.executeInsert(insertSql);
		return result == 1 ? true : false;
	}

	public boolean patientRemove(PatientModel patient) {

		String deleteSql = "delete from patients where patientName='" + patient.getPatientName() + "'";

		Util util1 = new Util();
		int results = util1.executeDelete(deleteSql);
		return results == 1 ? true : false;
	}

	public boolean doctorSave(DoctorModel doctor) {

		String insertSql = "insert into doctors values('" +doctor.getDoctorId()+ "','" + doctor.getDoctorName()
				+ "','" +doctor.getPhone()+ "'," +doctor.getDiseaseId()+ ")";

		Util util = new Util();
		int result = util.executeInsert(insertSql);
		return result == 1 ? true : false;
	}
	
	public boolean doctorRemove(DoctorModel doctor) {

		String deleteSql = "delete from doctors where doctorName='" +doctor.getDoctorName()+ "'";

		Util util1 = new Util();
		int results = util1.executeDelete(deleteSql);
		return results == 1 ? true : false;
	}

}
