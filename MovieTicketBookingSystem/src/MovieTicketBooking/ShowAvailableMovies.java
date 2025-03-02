package MovieTicketBooking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class ShowAvailableMovies {
	
	public static void showMovies() {
		
		Connection conn = DatabaseConnection.getConnection();
		if(conn==null) {
			System.out.println("Database Connection Failed.");
			return;
		}
		try {
			Statement smt = conn.createStatement();
			
			String query = "Select m.title, m.movie_id, s.show_id, s.show_time, s.available_seats from movies m inner join shows s on s.movie_id=m.movie_id";
			ResultSet rs=smt.executeQuery(query);
			while(rs.next()) {
				int movieId=rs.getInt("movie_id");
				String title=rs.getString("title");
				String showId=rs.getString("show_id");
				Timestamp showTime=rs.getTimestamp("show_time");
				int availableSeats=rs.getInt("available_seats");
				
				 System.out.println("Movie ID: " + movieId + ", Title: " + title + 
	                       ", Show ID: " + showId + ", Show Time: " + showTime + 
	                       ", Available Seats: " + availableSeats);
				 
				 System.out.println("----------------------------------------");
				
			}

            smt.close();
//            conn.close();
         }
      catch(SQLException e) {
       e.printStackTrace();
       }
		
	}
		
		
	}

