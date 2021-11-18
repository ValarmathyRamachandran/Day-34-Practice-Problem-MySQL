<<<<<<< HEAD
package bridgelabzAddressBook;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Enumeration;

import com.mysql.cj.jdbc.Driver;
public class ConnectToDatabase {
   public static void main(String[] args) {
      Connection con = null;
      try {
    	  Class.forName("com.mysql.cj.jdbc.Driver");
    	  System.out.println("Driver loaded");
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user = root & password = valar@123 ");
         if (con != null) {
            System.out.println("Database connection is successful !!!!");
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
  private static void listDrivers() {
	  Enumeration<java.sql.Driver> driverList = DriverManager.getDrivers();
	  while (driverList.hasMoreElements()) {
		  Driver driverClass =(Driver) driverList.nextElement();
		  System.out.println("  "+driverClass.getClass().getName());
	  }
  } 
 }
 
=======
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
      String query= " UPDATE payroll_service.employee_payroll SET Salary =3000000.00 WHERE EmployeeName ='Terisa' ";
      try {
    	  Class.forName("com.mysql.cj.jdbc.Driver");
    	  System.out.println("Driver loaded");
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user = root & password = ******* ");
         if (con != null) {
            System.out.println("Database connection is successful !!!!");
         }
         stmt = con.createStatement();
         System.out.println("platform created");
         stmt.executeUpdate(query);
         System.out.println("Updated salary of Terisa to 3000000.00 sucessfully"); 
	      
 // UC-3 able to update the salary i.e.the base pay for Employee Terisa to 3000000.00 and sync it with Database
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
 }
 
>>>>>>> 00d7b9ca470a8f9f9a252480986ff7572ee89c2b
