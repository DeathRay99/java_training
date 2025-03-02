package MovieTicketBooking;
import java.sql.*;
import java.util.*;
public class Test {
    public static void main(String[] args) {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = DatabaseConnection.getConnection();
            if (conn == null) {
                System.out.println("Database Connection Failed");
                return;
            }
//            cstmt = conn.prepareCall("{CALL test(?, ?)}");
//            // Set the input parameter
//            System.out.print("Enter your movie Id: ");
//            Scanner scanner = new Scanner(System.in);
//            int movieId = scanner.nextInt();
//            cstmt.setInt(1, movieId);
//            // Register the output parameter
//            cstmt.registerOutParameter(2, Types.VARCHAR);
//            // Execute the stored procedure
//            cstmt.execute();
//            // Retrieve the output parameter value
//            String title = cstmt.getString(2);
//            System.out.println("Movie Title: " + title);
            
//            cstmt = conn.prepareCall("{CALL test1(?)}");
//            // Set the input parameter
//            System.out.print("Enter your username: ");
//            Scanner scanner = new Scanner(System.in);
//            String username = scanner.next();
//            scanner.nextLine();
//            cstmt.setString(1, username);
//          
//            // Execute the stored procedure
//            ResultSet rs = cstmt.executeQuery();
//            while(rs.next()) {
//            	int bookingId=rs.getInt("booking_id");
//				String user=rs.getString("username");
//				String showId=rs.getString("show_id");
//				Timestamp bookingDate=rs.getTimestamp("booking_date");
//				int seatsBooked=rs.getInt("seats_booked");
//				
//				System.out.println("Booking ID: " + bookingId + ", User: " + user + 
//		                   ", Show ID: " + showId + ", Booking Date: " + bookingDate + 
//		                   ", Seats Booked: " + seatsBooked);
//				 
//				 System.out.println("----------------------------------------");
            cstmt = conn.prepareCall("{CALL test8(?)}");
            // Set the input parameter
            System.out.print("Enter your username: ");
            Scanner scanner = new Scanner(System.in);
            String username = scanner.next();
            scanner.nextLine();
            cstmt.setString(1, username);
            cstmt.execute();
            System.out.println("Booking cancelled ");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cstmt != null) cstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}