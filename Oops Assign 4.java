import java.sql.*;
public class ExecuteStoredProcedure {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb"; // your DB name
        String user = "root"; // your DB username
        String password = "root"; // your DB password
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully!");
            stmt = conn.prepareCall("{call getEmployeeDetails(?)}");
            stmt.setInt(1, 101); // Pass parameter (emp_id)
            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("--------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

