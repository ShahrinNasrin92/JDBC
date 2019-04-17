package Read;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Read {

	public static void main(String[] args) {
		try {
			String url = "jdbc:sqlserver://vNTDACWSSQLD002:1433;databaseName=DEV_TEST;";
			String password = "dev_test_dbo123";
			String user = "dev_test_dbo";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stm = con.createStatement();

			//Inserted a value 
			String ins = "INSERT INTO T_Shahrin(name,dept,course,salary) output inserted.id,inserted.name ,inserted.dept,inserted.course,inserted.salary VALUES('Simon','SOC','SOC452', 25000)";
			ResultSet insr = stm.executeQuery(ins);
			while (insr.next()) {
				System.out.println(insr.getString("Id") + " " + insr.getString("Name") + " " + insr.getString("Dept")+" " +insr.getString("Course") + " " +insr.getString("Salary"));
			}

			System.out.println("Show all ");
			String SQL = "SELECT * FROM T_Shahrin";
			ResultSet rs = stm.executeQuery(SQL);
			while (rs.next()) {
				System.out.println(rs.getString("Id") + " " + rs.getString("Name") + " " + rs.getString("Dept"));
			}
			
			// Join operations

			System.out.println("***Right Join***");
			String Right = "select T_Shahrin.Course, T_Shahrin22.EmpDesignation from T_Shahrin right join T_Shahrin22 on T_Shahrin.Salary=T_Shahrin22.EmpSalary";
			ResultSet rj = stm.executeQuery(Right);
               
			while (rj.next()) {
				System.out.println(rj.getString("Course") + " " + rj.getString("EmpDesignation"));
			}
			
			System.out.println("****Left Join****");
			String Left = "select T_Shahrin.Course, T_Shahrin22.EmpDesignation from T_Shahrin left join T_Shahrin22 on T_Shahrin.Salary=T_Shahrin22.EmpSalary";
			ResultSet lj = stm.executeQuery(Left);

			while (lj.next()) {
				System.out.println(lj.getString("Course") + " " + lj.getString("EmpDesignation"));
			}
			
			System.out.println("***Inner Join****");
			
			String Inner = "select T_Shahrin.Course, T_Shahrin22.EmpDesignation from T_Shahrin inner join T_Shahrin22 on T_Shahrin.Salary=T_Shahrin22.EmpSalary";
			ResultSet ij = stm.executeQuery(Inner);

			while (ij.next()) {
				System.out.println(ij.getString("Course") + " " + ij.getString("EmpDesignation"));
			}



		} catch (Exception e) {
			System.out.println(e);

		}
	}

}
