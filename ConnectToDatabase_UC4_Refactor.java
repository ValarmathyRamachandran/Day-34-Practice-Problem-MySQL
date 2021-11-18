package bridgelabzAddressBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class ADO_UC4_Refactor {

	public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement stmt = null;
        String query = "select * from payroll_service.employee_payroll where EmployeeName = ? ";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Name to fetch Employee payroll details");
        String Name = sc.next();
        sc.close();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver loaded");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306?user = root & password = valar@123");
            System.out.println("connection established");
            stmt = connection.prepareStatement(query);
            System.out.println("platform created");
            stmt.setString(1, Name);
            ResultSet resultSet = stmt.executeQuery();
            System.out.println("data fetched");
            if(resultSet.next()){
            	 String EmployeeId = resultSet.getString(1);
                String EmployeeName = resultSet.getString(2);
                String Gender = resultSet.getString(3);
                String Salary = resultSet.getString(4);
                Date StartDate = resultSet.getDate(6);
              
                System.out.println("name:" + EmployeeId+ " Employee Name : "+ EmployeeName+" Gender: "+ Gender+ " Salary: "+ Salary+" Start date: "+StartDate);
            }else{
                System.out.println("no data found of id: "+ Name);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
