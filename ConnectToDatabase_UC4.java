package bridgelabzAddressBook;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class ADO_UC4 {
   public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement stmt = null;
        String query = "update payroll_service.employee_payroll WHERE EmployeeName ='Terisa'";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver loaded");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306?user = root & password = valar@123");
            System.out.println("connection established");
            stmt = connection.prepareStatement(query);
            System.out.println("platform created");
            stmt.setFloat(4, (float) 3000000.00);
            stmt.executeUpdate();
            System.out.println("data Updated");
        } catch (ClassNotFoundException | SQLException ex) {
            ((Throwable) ex).printStackTrace();
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