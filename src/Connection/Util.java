package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Util {

	final String DB_URL="jdbc:mysql://localhost:3306/HMS";
	final String USER_NAME = "root";
    final String PASSWORD = "myroot@12345";
    
    public boolean execute(String createSql) {
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection conn=DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
    		Statement stmt=conn.createStatement();
    		return stmt.execute(createSql);
    	}catch(Exception e) {
    		System.out.println("Connection failed:" + e);
    	}
    	return true;
    }
    public int executeInsert(String insertSql) {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection cons=DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
    		Statement st=cons.createStatement();
    		return st.executeUpdate(insertSql);
    	}catch(Exception e) {
    		System.out.println("Connection failed:" + e);
    	}
    	return 0;
    }
    
    public ResultSet executeSelect(String selectSql) {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con=DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
    		Statement sts=con.createStatement();
    		return sts.executeQuery(selectSql);
    	}catch(Exception e) {
    		System.out.println("Connection failed:" + e);
    	}
    	return null;
    }
    
    public int executeDelete(String deleteSql) {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con=DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
    		Statement sts=con.createStatement();
    		return sts.executeUpdate(deleteSql);
    	}catch(Exception e) {
    		System.out.println("Connection failed:" + e);
    	}
        return 0;
    }
    public int executeUpdate(String updateSql) {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con=DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
    		Statement sts=con.createStatement();
    		return sts.executeUpdate(updateSql);
    	}catch(Exception e) {
    		System.out.println("Connection failed:" + e);
    	}
        return 0;
    }
    
    
}
