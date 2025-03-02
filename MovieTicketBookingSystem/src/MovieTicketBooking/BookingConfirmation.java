package MovieTicketBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Scanner;

public class BookingConfirmation {
	
	// ask username - preparedStatement
	
		// relating all three tables
		
		// Booking > USername, Booking Id
		// Movies -> Movie Name
		// Shows -> SHowtime, Seats booked ->
	
	public static void confirmBooking() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username ");
		String username=sc.next();
		sc.nextLine();
		Connection conn = DatabaseConnection.getConnection();
		if(conn==null) {
			System.out.println("Database Connection Failed.");
			return;
		}
		try {
			Statement smt = conn.createStatement();
			
			
			String query = "SELECT b.username, b.booking_id, m.title, s.show_time, b.seats_booked "
                    + "FROM bookings b "
                    + "INNER JOIN shows s ON b.show_id = s.show_id "
                    + "INNER JOIN movies m ON s.movie_id = m.movie_id "
                    + "WHERE b.username = ?";
       
       PreparedStatement psmt = conn.prepareStatement(query);
       psmt.setString(1, username);
       ResultSet rs = psmt.executeQuery();
       while (rs.next()) {
           String user = rs.getString("username");
           int bookingId = rs.getInt("booking_id");
           String title = rs.getString("title");
           Timestamp showTime = rs.getTimestamp("show_time");
           int seatsBooked = rs.getInt("seats_booked");
           
           // Print statement
           System.out.println("Username: " + user + ", Booking ID: " + bookingId + 
                              ", Movie Title: " + title + ", Show Time: " + showTime + 
                              ", Seats Booked: " + seatsBooked);
       }

            psmt.close();
//            conn.close();
         }
      catch(SQLException e) {
       e.printStackTrace();
       }
	}

}
