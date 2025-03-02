package HMSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientDAO {
	
	public void addPatient(Patient patient) throws SQLException {
		Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed.");
            return;
        }
		String query = "Insert into Patient (f_name, l_name, age, gender, contact_number) Values (?,?,?,?,?)";
		try {
			PreparedStatement psmt=conn.prepareStatement(query);
			   psmt.setString(1,patient.getFname());
			   psmt.setString(2,patient.getLname());
			   psmt.setInt(3, patient.getAge());
			   psmt.setString(4, patient.getGender());
			   psmt.setString(5, patient.getContactNumber());
			   psmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Patient> getAllPatients(){
		List<Patient> patients = new ArrayList<>();
		String query = "SELECT * FROM patient";
		try {
			Connection conn = DatabaseConnection.getConnection();
			 Statement smt = conn.createStatement();
			 ResultSet rs = smt.executeQuery(query);
			while(rs.next()) {
				Patient patient = new Patient(rs.getInt("id"), rs.getString("f_name"), rs.getString("l_name"), 
											  rs.getInt("age"), rs.getString("gender"), rs.getString("contact_number"));
				patients.add(patient);	
			}
			 
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return patients;
		
	}
	
	// Method to update patient details
	public void updatePatient(int id,Scanner scanner) throws SQLException {
	    Connection conn = DatabaseConnection.getConnection();
	    if (conn == null) {
	        System.out.println("Database Connection Failed.");
	        return;
	    }
	    String query = "UPDATE Patient SET f_name = ? WHERE id = ?";
	    System.out.println("enter new name.. ");
	    String name=scanner.next();
	    
	    try {
	        PreparedStatement psmt = conn.prepareStatement(query);
	        psmt.setString(1,name);
	        psmt.setInt(2, id);
	        psmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	// Method to delete a patient
	public void deletePatient(int patientId) throws SQLException {
	    Connection conn = DatabaseConnection.getConnection();
	    if (conn == null) {
	        System.out.println("Database Connection Failed.");
	        return;
	    }
	    String query = "DELETE FROM Patient WHERE id = ?";
	    try {
	        PreparedStatement psmt = conn.prepareStatement(query);
	        psmt.setInt(1, patientId);
	        psmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
