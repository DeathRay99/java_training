package MovieTicketBooking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

public class TicketBooking {
	
	public static void bookTicket() {
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
			System.out.println("Here are all available shows. ");
			ShowAvailableMovies.showMovies();
			
			System.out.println("Choose a show id.... ");
			int show_Id=sc.nextInt();
			
			System.out.println("How many tickets? ");
			int numSeats=sc.nextInt();
			
			String availableSeatsSQL="Select available_seats from shows where show_id=?";
			PreparedStatement psmt1=conn.prepareStatement(availableSeatsSQL);
			
			psmt1.setInt(1, show_Id);
			ResultSet rs=psmt1.executeQuery();
			if(rs.next()) {
				int availableSeats=rs.getInt("available_seats");
				if(availableSeats>=numSeats) {
					String insertBookingSQL="insert into bookings (username,show_id,seats_booked) values (?,?,?)";
					PreparedStatement psmt2=conn.prepareStatement(insertBookingSQL);
					
					psmt2.setString(1,username);
					psmt2.setInt(2,show_Id);
					psmt2.setInt(3,numSeats);
					psmt2.executeUpdate();
					
					String updateShowsSQL="update shows set available_seats=available_seats-? where show_id=?";
					PreparedStatement psmt3=conn.prepareStatement(updateShowsSQL);
					
					psmt3.setInt(1,numSeats);
					psmt3.setInt(2, show_Id);
					psmt3.executeUpdate();
					
					System.out.println("Booking successfull ");
					psmt1.close();
					psmt2.close();
					psmt3.close();
//		            conn.close();
					
				}
				else {
					System.out.println("Sorry Housefull. ");
				}
				
			}
			
			
			
		}
		catch(SQLException e) {
		       e.printStackTrace();
		       }
		
	}

}
