package bridgelabzAddressBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ADO_UC6 {
	 public static void main(String[] args) {
	      Connection con = null;
	      java.sql.Statement stmt = null;
	      String query1 = "SELECT SUM(Salary) from payroll_service.employee_payroll WHERE Gender = 'F' GROUP BY Gender;";
	      String query2 = "SELECT SUM(Salary) from payroll_service.employee_payroll WHERE Gender = 'M' GROUP BY Gender;";
	      String query3 = "SELECT AVG(Salary) from payroll_service.employee_payroll WHERE Gender = 'M' GROUP BY Gender;";
	      String query4 = "SELECT AVG(Salary) from payroll_service.employee_payroll WHERE Gender = 'F' GROUP BY Gender;";
	      String query5 = "SELECT min(Salary) from payroll_service.employee_payroll WHERE Gender = 'F' GROUP BY Gender;";
	      String query6 = "SELECT max(Salary) from payroll_service.employee_payroll WHERE Gender = 'M' GROUP BY Gender;";
	      String query7 = "SELECT count(Salary) from payroll_service.employee_payroll WHERE Gender = 'F' GROUP BY Gender;";
	      try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	    	  System.out.println("Driver loaded");
	         con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user = root & password = valar@123 ");
	         if (con != null) {
	            System.out.println("Database connection is successful !!!!");
	         }
	         stmt = con.createStatement();
	         System.out.println("platform created");
	         
	         stmt.executeQuery(query1);
	         ResultSet resultSet = stmt.getResultSet();

	        if(resultSet.next()){
	             
	             System.out.println("Salary =" +resultSet.getString("SUM(Salary)")); 
	             
	         }
	        
	        stmt.executeQuery(query2 );
	         ResultSet resultSet1 = stmt.getResultSet();

	        if(resultSet1.next()){
	             
	             System.out.println("Salary =" +resultSet1.getString("SUM(Salary)")); 
	             
	         }
	        stmt.executeQuery(query3 );
	         ResultSet resultSet2 = stmt.getResultSet();

	        if(resultSet2.next()){
	             
	             System.out.println("Average Salary =" +resultSet2.getString("AVG(Salary)")); 
	             
	         }
	        stmt.executeQuery(query4 );
	         ResultSet resultSet3 = stmt.getResultSet();

	        if(resultSet3.next()){
	             
	             System.out.println("Average Salary =" +resultSet3.getString("AVG(Salary)")); 
	             
	         }
	        stmt.executeQuery(query5 );
	         ResultSet resultSet4 = stmt.getResultSet();

	        if(resultSet4.next()){
	             
	             System.out.println("Minimum Salary =" +resultSet4.getString("min(Salary)")); 
	             
	         }
	        
	        stmt.executeQuery(query6 );
	         ResultSet resultSet5 = stmt.getResultSet();

	        if(resultSet5.next()){
	             
	             System.out.println("Maximum Salary =" +resultSet5.getString("max(Salary)")); 
	             
	         }
	        
	        stmt.executeQuery(query7);
	         ResultSet resultSet6 = stmt.getResultSet();

	        if(resultSet6.next()){
	             
	             System.out.println("Count =" +resultSet6.getString("count(Salary)")); 
	             
	         }
	        
	         //UC-6 Ability to find sum, average, min,max and number of male and female employees
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	 }
	 
