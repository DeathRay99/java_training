package MovieTicketBooking;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabseTables {
	
	public static void createTables() {
		Connection conn = DatabaseConnection.getConnection();
		if(conn==null) {
			System.out.println("Database Connection Failed.");
			return;
		}
		try {
			Statement smt = conn.createStatement();
			
			String createMoviesTable = "Create table if not exists movies ("
					                   + "movie_id int auto_increment primary key, "
					                   + "title varchar(60) not null,"
					                   + "genre varchar(20),"
					                   + "duration int not null)";
			smt.executeUpdate(createMoviesTable);
			System.out.println("Movies Table created. ");
			
			String createShowsTable = "CREATE TABLE IF NOT EXISTS Shows ("
                                      + "show_id INT AUTO_INCREMENT PRIMARY KEY, "
                                      + "movie_id INT, "
                                      + "show_time DATETIME NOT NULL, "
                                      + "available_seats INT NOT NULL, "
                                      + "FOREIGN KEY (movie_id) REFERENCES Movies(movie_id))";
           smt.executeUpdate(createShowsTable);
           System.out.println("Shows table created");

           String createBookingsTable = "CREATE TABLE IF NOT EXISTS Bookings ("
                                      + "booking_id INT AUTO_INCREMENT PRIMARY KEY, "
                                      + "username VARCHAR(20) NOT NULL, "
                                      + "show_id INT NOT NULL, "
                                      + "seats_booked INT NOT NULL, "
                                      + "booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
                                      + "FOREIGN KEY (show_id) REFERENCES Shows(show_id))";


            smt.executeUpdate(createBookingsTable);
            System.out.println("Bookings table created");
            
            String createUsersTable = "CREATE TABLE IF NOT EXISTS users ("
                    + "user_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "username VARCHAR(20) NOT NULL, "
                    + "pwd VARCHAR(20) NOT NULL, "
                    + "admin BOOLEAN DEFAULT 0)";
            smt.executeUpdate(createUsersTable);
            System.out.println("Users table created.");


            smt.close();
//            conn.close();
         }
      catch(SQLException e) {
       e.printStackTrace();
       }
		
	}
	
	public static void main(String[] args) {
		createTables();
	}

}
