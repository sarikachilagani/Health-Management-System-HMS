package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.Util;
import Model.DoctorModel;
import Model.PatientModel;

public class DoctorService {

	public List<PatientModel> getPatientDetails(DoctorModel doctor) {
		
		String selectSql="select patients.patientID,patients.patientName,patients.patientAge,patients.email "
				+ "from patients inner join doctors "
				+ "on patients.diseaseId=doctors.diseaseId where doctorName='"+doctor.getDoctorName()+"'";
		
		Util util = new Util();
		ResultSet result = util.executeSelect(selectSql);
		
		List<PatientModel> list=new ArrayList<PatientModel>();
		
		try {
			while(result.next()) {
				
				int id=result.getInt(1);
				String name=result.getString(2);
				int age=result.getInt(3);
				String email=result.getString(4);
				PatientModel patient=new PatientModel();
				patient.setPatientId(id);
				patient.setPatientName(name);
				patient.setPatientAge(age);
				patient.setEmail(email);
				list.add(patient);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
}
