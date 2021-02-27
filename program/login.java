package app;
import java.sql.*;

import javax.swing.JOptionPane;

public class login {
	public static Connection dbconnect()
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","MANAGER","1234");
			return conn;
		} catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
