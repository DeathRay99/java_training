package MovieTicketBooking;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StoredProCallable {
	
	public static void proCall() {
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
//			String procedure = "CREATE PROCEDURE test(IN movieid INT, OUT movietitle VARCHAR(25)) "
//                    + "BEGIN "
//                    + "     SELECT title INTO movietitle FROM movies WHERE movie_id = movieid; "
//                    + "END;";
//			String procedure = "CREATE PROCEDURE test1(IN user VARCHAR(25)) "
//                    + "BEGIN "
//                    + "     SELECT * from bookings WHERE username = user; "
//                    + "END;";
			String procedure = "CREATE PROCEDURE test8(IN user VARCHAR(25)) "
                    + "BEGIN "
                    + "    DECLARE booked_seats INT; "
                    + "    DECLARE bookingID INT; "
                    + "    DECLARE showID INT; "
                    + "    SELECT seats_booked, booking_id, show_id INTO booked_seats, bookingID, showID FROM bookings WHERE username = 'user'; "
                    + "    update shows set available_seats = available_seats + booked_seats where show_id = showID; "
                    + "    delete from bookings where booking_id = bookingID; "
                    + "END;";
			Statement smt=conn.createStatement();
			smt.execute(procedure);
			System.out.println("procedure created");
		}
		catch(SQLException e) {
		       e.printStackTrace();
		       }
	}
	

}
