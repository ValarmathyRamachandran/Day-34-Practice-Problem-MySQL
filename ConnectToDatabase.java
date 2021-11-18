package bridgelabzAddressBook;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Enumeration;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Statement;
public class ConnectToDatabase {
   public static void main(String[] args) {
      Connection con = null;
      java.sql.Statement stmt = null;
      String query= "SELECT * from payroll_service.employee_payroll";
      try {
    	  Class.forName("com.mysql.cj.jdbc.Driver");
    	  System.out.println("Driver loaded");
<<<<<<< HEAD
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user = root & password = valar@123	 ");
=======
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user = root & password = ******* ");
>>>>>>> 00d7b9ca470a8f9f9a252480986ff7572ee89c2b
         if (con != null) {
            System.out.println("Database connection is successful !!!!");
         }
         stmt = con.createStatement();
         System.out.println("platform created");
         stmt.executeQuery(query);
         ResultSet resultSet = stmt.getResultSet();
        
         if(resultSet.next()){
        	
             System.out.println("Employee Id = "+resultSet.getInt("EmployeeId"));
             System.out.println("Employee Name = "+resultSet.getString("EmployeeName"));
             System.out.println("Gender = "+resultSet.getString("Gender"));
             System.out.println("Salary =" +resultSet.getString("Salary"));
             System.out.println("Start Date =" +resultSet.getString("StartDate"));
            
         }

      } catch (Exception e) {
         e.printStackTrace();
      }
   }
 }
 
