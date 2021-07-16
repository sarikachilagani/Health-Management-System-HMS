package Service;

import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.Util;
import Model.PatientModel;

public class PatientService {

	public String getMedicines(PatientModel patient) {
		
		String selectSql="select patients.patientID,patients.patientName,diseases.medicine "
				+ "from patients inner join diseases "
				+ "on patients.diseaseId=diseases.diseaseId where patientName='"+patient.getPatientName()+"'";
		
		Util util = new Util();
		ResultSet result = util.executeSelect(selectSql);
		
		try {
			while(result.next()) {
				if(result.getString(2).equals(patient.getPatientName())) {
					return result.getString(3);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
