package MovieTicketBooking;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class InsertData {
	
	public static void insertMovies() {
		Connection conn = DatabaseConnection.getConnection();
		if(conn==null) {
			System.out.println("Database Connection Failed.");
			return;
		}
		
		String insertMovieSQL="Insert into movies (title, genre, duration) values (?,?,?)";
		
		try(PreparedStatement psmt=conn.prepareStatement(insertMovieSQL)){
			psmt.setString(1, "Interstellar");
			psmt.setString(2, "sci-fi");
			psmt.setInt(3, 150);
			psmt.executeUpdate();
			
			psmt.setString(1, "The Matrix");
			psmt.setString(2, "Action");
			psmt.setInt(3, 136);
			psmt.executeUpdate();
			
			psmt.setString(1, "Fighter");
			psmt.setString(2, "Action");
			psmt.setInt(3, 150);
			psmt.executeUpdate();
			
			System.out.println("Movies inserted successfully.");
			
//			psmt.close();
//			conn.close();
//			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertShows() {
		Connection conn = DatabaseConnection.getConnection();
		if(conn==null) {
			System.out.println("Database Connection Failed.");
			return;
		}
		
		String insertShowsSQL="Insert into shows (movie_id, show_time, available_seats) values (?,?,?)";
		
		try(PreparedStatement psmt=conn.prepareStatement(insertShowsSQL)){
			
			psmt.setInt(1, 1);
			psmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.of(2025,2,16, 9,30)));
			psmt.setInt(3, 100); 
			psmt.executeUpdate();

//			psmt.setInt(1, 1); 
//			psmt.setString(2, "2025-02-13 18:00:00"); 
//			psmt.setInt(3, 100); 
//			psmt.executeUpdate();
//
//			psmt.setInt(1, 1); 
//			psmt.setString(2, "2025-02-13 21:00:00"); 
//			psmt.setInt(3, 100); 
//			psmt.executeUpdate();
			
			psmt.setInt(1, 2); 
		    psmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.of(2025,2,17, 11,00))); 
			psmt.setInt(3, 120); 
			psmt.executeUpdate();

//			psmt.setInt(1, 2); 
//			psmt.setString(2, "2025-02-14 18:00:00"); 
//			psmt.setInt(3, 120); 
//			psmt.executeUpdate();
//
//			psmt.setInt(1, 2); 
//			psmt.setString(2, "2025-02-14 21:00:00"); 
//			psmt.setInt(3, 120); 
//			psmt.executeUpdate();
			
			psmt.setInt(1, 3); 
			psmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.of(2025,2,17, 3,30)));
			psmt.setInt(3, 56);
			psmt.executeUpdate();

//			psmt.setInt(1, 3); 
//			psmt.setString(2, "2025-02-15 18:00:00");
//			psmt.setInt(3, 150);
//			psmt.executeUpdate();
//
//			psmt.setInt(1, 3); 
//			psmt.setString(2, "2025-02-15 21:00:00");
//			psmt.setInt(3, 150); 
//			psmt.executeUpdate();
			
			System.out.println("Shows inserted successfully.");
			
			psmt.close();
			conn.close();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		insertMovies();
		insertShows();
	}

}
