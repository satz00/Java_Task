import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCInsertData {
    public static void main(String[] args) {

        String dbURL = "jdbc:mysql://localhost:3306/Db";
        String username = "root";
        String password = "your_password";

        String createTableSQL = "CREATE TABLE IF NOT EXISTS Employee ("
                + "empcode INT PRIMARY KEY, "
                + "empname VARCHAR(50), "
                + "empage INT, "
                + "esalary DECIMAL(10, 2)"
                + ");";

        String insertSQL = "INSERT INTO Employee (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";

        Object[][] data = {
                {101, "Jenny", 25, 10000},
                {102, "Jacky", 30, 20000},
                {103, "Joe", 20, 40000},
                {104, "John", 40, 80000},
                {105, "Shameer", 25, 90000}
        };

        try (Connection conn = DriverManager.getConnection(dbURL, username, password);
             PreparedStatement createTableStmt = conn.prepareStatement(createTableSQL);
             PreparedStatement insertStmt = conn.prepareStatement(insertSQL)) {

            createTableStmt.executeUpdate();
            System.out.println("Table created or already exists.");

            for (Object[] row : data) {
                insertStmt.setInt(1, (int) row[0]);
                insertStmt.setString(2, (String) row[1]);
                insertStmt.setInt(3, (int) row[2]);
                insertStmt.setDouble(4, (double) ((int) row[3]));
                insertStmt.executeUpdate();
            }
            System.out.println("Data inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
