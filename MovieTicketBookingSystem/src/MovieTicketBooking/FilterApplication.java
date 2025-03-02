package MovieTicketBooking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.RowSetProvider;

//import com.mysql.cj.protocol.Resultset;

public class FilterApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Connection conn = DatabaseConnection.getConnection();
			Statement smt=conn.createStatement();
			ResultSet rs = smt.executeQuery("select * from shows")){
			FilteredRowSet frs=RowSetProvider.newFactory().createFilteredRowSet();
			frs.populate(rs);
			frs.setFilter(new AvailableShowsSeatsFilter(100));
			while(frs.next()) {
				System.out.println("Show ID: "+frs.getInt("show_id")+", Available seats: "+frs.getInt("available_seats"));
				
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}

	}

}
