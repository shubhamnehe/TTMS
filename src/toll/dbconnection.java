package toll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class dbconnection {
	 public static Connection getDBconnection()
	 {
		Connection con;
						
					try
					{
						Class.forName("org.postgresql.Driver");
						Connection conn=DriverManager.getConnection("jdbc:postgresql://localhost/ttms","postgres","");

						return conn;
					}
					catch(Exception e)
					{
						return null;
					}
	 }
}
