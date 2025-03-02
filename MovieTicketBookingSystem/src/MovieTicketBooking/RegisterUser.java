package MovieTicketBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterUser {

    public static boolean register(String username, String pwd) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed.");
            return false;
        }
        try {
            String query = "INSERT INTO users (username, pwd, admin) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, pwd);
            pstmt.setBoolean(3, false);  // Default to regular user (not admin)

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
