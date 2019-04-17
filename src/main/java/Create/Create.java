package Create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Create {

	public static void main(String[] args) {
		try {
			String url = "jdbc:sqlserver://vNTDACWSSQLD002:1433;databaseName=DEV_TEST;";
			String password = "dev_test_dbo123";
			String user = "dev_test_dbo";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt =  con.createStatement();
			
	String Create_table="CREATE TABLE T_Shahrin22 (EmpID INT NOT NULL IDENTITY(1,1) PRIMARY KEY (EmpID), EmpName VARCHAR(50) NOT NULL,EmpDesignation VARCHAR(50) NOT NULL,EmpSalary INT NOT NULL)" ;
			
			stmt.executeUpdate(Create_table);

	}
		catch (Exception e) {
			System.out.println(e);

		}
		

	}

}
