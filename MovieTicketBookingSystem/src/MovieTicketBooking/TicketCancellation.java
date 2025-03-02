package MovieTicketBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TicketCancellation {
	
	public static void cancelTicket() {
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
			String updateSeatsSQL="update shows set available_seats=available_seats+? where show_id=?";
			String getBookingInfoSQL="select seats_booked, booking_id, show_id from bookings where username=? ";
			String deleteBookingSQL="delete from bookings where booking_id=? ";
			PreparedStatement psmt1=conn.prepareStatement(getBookingInfoSQL);
			PreparedStatement psmt2=conn.prepareStatement(updateSeatsSQL);
			PreparedStatement psmt3=conn.prepareStatement(deleteBookingSQL);
			psmt1.setString(1, username);
			ResultSet rs=psmt1.executeQuery();
			while(rs.next()) {
				int bookedSeats=rs.getInt("seats_booked");
				int show_Id=rs.getInt("show_id");
				int booking_id=rs.getInt("booking_id");
				
				
				psmt2.setInt(1, bookedSeats);
				psmt2.setInt(2, show_Id);
				psmt2.executeUpdate();
				
				
				psmt3.setInt(1, booking_id);
				psmt3.executeUpdate();
				
				System.out.println("Booking cancelled ");
				
			}
			psmt1.close();
			psmt2.close();
			psmt3.close();
		}
		catch(SQLException e) {
		       e.printStackTrace();
		       }
		
	}

}
