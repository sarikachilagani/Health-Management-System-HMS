package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.Util;
import Model.DiseaseModel;
import Model.DoctorModel;
import Model.PatientModel;

public class AdminService {

	public boolean patientSave(PatientModel patient) {

		String insertSql = "insert into patients values('" + patient.getPatientId() + "','" + patient.getPatientName()
				+ "'," + patient.getPatientAge() + ",'" + patient.getGender() + "','" + patient.getEmail() + "','"
				+ patient.getPhone() + "'," + patient.getDiseaseId() + ")";

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

	public boolean patientUpdate(PatientModel patient) {

		String updateSql = "update patients set patientName='" + patient.getPatientName() + "' where patientId="
				+ patient.getPatientId() + "";
		Util util2 = new Util();
		int results = util2.executeUpdate(updateSql);
		return results == 1 ? true : false;
	}

	public boolean doctorSave(DoctorModel doctor) {

		String insertSql = "insert into doctors values('" + doctor.getDoctorId() + "','" + doctor.getDoctorName() + "',"
				+ doctor.getPhone() + ", '" + doctor.getEmail() + "','" + doctor.getSpecialist() + "',"
				+ doctor.getExperience() + "," + doctor.getDiseaseId() + ")";

		Util util = new Util();
		int result = util.executeInsert(insertSql);
		return result == 1 ? true : false;
	}

	public boolean doctorRemove(DoctorModel doctor) {

		String deleteSql = "delete from doctors where doctorName='" + doctor.getDoctorName() + "'";

		Util util1 = new Util();
		int results = util1.executeDelete(deleteSql);
		return results == 1 ? true : false;
	}

	public boolean doctorUpdate(DoctorModel doctor) {

		String updateSql = "update doctors set doctorName='" + doctor.getDoctorName() + "' where doctorId="
				+ doctor.getDoctorId() + "";

		Util util1 = new Util();
		int results = util1.executeUpdate(updateSql);
		return results == 1 ? true : false;
	}

	public List<DiseaseModel> diseaseDetails() {
		String selectSql = "select * from diseases";

		Util util2 = new Util();
		ResultSet result = util2.executeSelect(selectSql);

		List<DiseaseModel> list = new ArrayList<DiseaseModel>();

		try {
			while (result.next()) {

				int id = result.getInt(1);
				String name = result.getString(2);
				String medicine = result.getString(3);
				DiseaseModel disease=new DiseaseModel();
				disease.setDiseaseId(id);
				disease.setDiseaseNmae(name);
				disease.setMedicine(medicine);
				list.add(disease);
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
