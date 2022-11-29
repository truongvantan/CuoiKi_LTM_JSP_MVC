package dbconfig;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBConfig {
	private Connection conn = null;
	
	// hien thi loi ket noi CSDL
	public void displayError(SQLException ex)
	{
		System.out.println(" Error Message:" + ex.getMessage());
		System.out.println(" SQL State:" + ex.getSQLState());
		System.out.println(" Error Code:" + ex.getErrorCode());
	}
	
	// lay ket noi CSDL
	public Connection getConnection() throws ClassNotFoundException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ltm", "root", "");
		} catch (SQLException ex) {
			// TODO: handle exception
			displayError(ex);
		}
		return conn;
	}

}
