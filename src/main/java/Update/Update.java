package Update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Update {

	public static void main(String[] args) {
		try {
			String url = "jdbc:sqlserver://vNTDACWSSQLD002:1433;databaseName=DEV_TEST;";
			String password = "dev_test_dbo123";
			String user = "dev_test_dbo";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stm = con.createStatement();

			String update = "update T_Shahrin SET Salary = 19000 where Dept ='ECO' " ;
			 stm.executeUpdate(update);
			
			 System.out.println("Updated successfully");

			String select = "select * from T_Shahrin";
			ResultSet sel = stm.executeQuery(select);
			while (sel.next()) {
				System.out.println(sel.getString("Id") + " " + sel.getString("Name") + " " + sel.getString("Dept") + " "
						+ sel.getString("Course") + " " + sel.getString("Salary"));
			}
		} catch (Exception e) {
			System.out.println(e);

		}

	}

}
