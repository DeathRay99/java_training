package MovieTicketBooking;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
 
public class RowSetApplication {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection conn = DatabaseConnection.getConnection();
//			JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
//			rowSet.setUrl("jdbc:mysql://localhost:3306/movie_booking");
//			rowSet.setUsername("root");
//			rowSet.setPassword("Genpact@123456789");
//			rowSet.setCommand("Select * from movies");
//			rowSet.execute();
//			while(rowSet.next()) {
//				System.out.println("ID: "+rowSet.getInt("movie_id"));
//			}
//			while(rowSet.previous()) {
//				System.out.println("ID: "+rowSet.getInt("movie_id"));
//			}
//			rowSet.close();
			CachedRowSet ct = RowSetProvider.newFactory().createCachedRowSet();
			ct.setCommand("select* from movies");
			ct.execute(conn);
 
			while(ct.next()) {
				if(ct.getInt("movie_id")==3) {
					ct.updateString("title", "Fighter3");
					ct.updateRow();
				}
			}
			conn=DatabaseConnection.getConnection();
			conn.setAutoCommit(false);
			ct.acceptChanges();
			while(ct.next()) {
				System.out.println("ID: "+ ct.getInt("movie_id"));
				System.out.println("title: "+ ct.getString("title"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}