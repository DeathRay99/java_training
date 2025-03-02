package MovieTicketBooking;

import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class WebRowSetApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection conn = DatabaseConnection.getConnection();
		try {
//			WebRowSet wrs=RowSetProvider.newFactory().createWebRowSet();
//			wrs.setCommand("select*from movies");
//			wrs.execute(conn);
//			System.out.println("Connection Closed.");
//			
//			FileWriter writer=new FileWriter("movies.xml");
//			wrs.writeXml(writer);
//			writer.close();
//			
//			//read data from xml
//			WebRowSet new_wrs=RowSetProvider.newFactory().createWebRowSet();
//			FileReader reader=new FileReader("movies.xml");
//			new_wrs.readXml(reader);
//			reader.close();
//			
//			while(new_wrs.next()) {
//				System.out.println("ID :"+new_wrs.getInt("movie_id")+" Title: "+new_wrs.getString("title"));
//			}
			CachedRowSet ct1 = RowSetProvider.newFactory().createCachedRowSet();
			ct1.setCommand("select* from movies");
			ct1.execute(conn);
			
			CachedRowSet ct2 = RowSetProvider.newFactory().createCachedRowSet();
			ct2.setCommand("select* from shows");
			ct2.execute(conn);
			
			conn.close();
			
			JoinRowSet j1=RowSetProvider.newFactory().createJoinRowSet();
			ct1.setMatchColumn("movie_id");
			ct2.setMatchColumn("movie_id");
			
			j1.addRowSet(ct1);
            j1.addRowSet(ct2);
            while(j1.next())
            {
				System.out.println("Id: "+j1.getInt("movie_id")+"\tTitle: "+j1.getString("title")+"\tGenre: "+j1.getString("genre")+"\tDuration: "+j1.getInt("duration")+"\tseats: "+j1.getInt("available_seats"));
 
            }
			
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
