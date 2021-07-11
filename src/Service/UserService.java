package Service;

import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.Util;
import Model.UserModel;

public class UserService {
	
	public boolean signupSave(UserModel userN) {
		
		//String createSql="create table HMS.signup(username varchar(20),password varchar(40),email varchar(20),phonenumber integer)";
		String insertSql="insert into signup values('"+userN.getUserName()+"','"+userN.getPassword()+"','"+userN.getEmail()+"',"+userN.getPhone()+")";
		//System.out.println(insertSql);
		Util util=new Util();
		int result=util.executeInsert(insertSql);
		return result==1 ? true : false;
	}
	
	public boolean loginSave(UserModel user1) throws SQLException {
		String selectSql="select * from signup where username= '"+user1.getUserName()+"' and password='"+user1.getPassword()+"'";
		Util utili=new Util();
		ResultSet rs=utili.executeSelect(selectSql);
		
		while(rs.next()) {
			if(rs.getString(1).equals(user1.getUserName()) && rs.getString(2).equals(user1.getPassword())) {
				return true;
			}
		}
		return false;
		
		
	}
}
