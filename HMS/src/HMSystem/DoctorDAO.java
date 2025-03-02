package HMSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorDAO {

    public void addDoctor(Doctor doctor) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed.");
            return;
        }
        String query = "INSERT INTO Doctor (name, speciality, contact) VALUES (?,?,?)";
        try {
            PreparedStatement psmt = conn.prepareStatement(query);
            psmt.setString(1, doctor.getName());
            psmt.setString(2, doctor.getSpeciality());
            psmt.setString(3, doctor.getContact());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        String query = "SELECT * FROM Doctor";
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Doctor doctor = new Doctor(rs.getInt("id"), rs.getString("name"), rs.getString("speciality"),
                        rs.getString("contact"));
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    // Method to update doctor details
    public void updateDoctor(int id, Scanner scanner) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed.");
            return;
        }
        String query = "UPDATE Doctor SET name = ? WHERE id = ?";
        System.out.println("Enter new name: ");
        String name = scanner.next();
        
        try {
            PreparedStatement psmt = conn.prepareStatement(query);
            psmt.setString(1, name);
            psmt.setInt(2, id);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a doctor
    public void deleteDoctor(int doctorId) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed.");
            return;
        }
        String query = "DELETE FROM Doctor WHERE id = ?";
        try {
            PreparedStatement psmt = conn.prepareStatement(query);
            psmt.setInt(1, doctorId);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
