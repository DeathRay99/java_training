package HMSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentDAO {

    public void bookAppointment(Appointment appointment) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed.");
            return;
        }

        if (!isPatientRegistered(appointment.getPatientId())) {
            System.out.println("Patient ID not registered.");
//            return;
        }
//
//
        if (!isDoctorRegistered(appointment.getDoctorId())) {
            System.out.println("Doctor ID not registered.");
//            return;
        }

        String query = "INSERT INTO Appointment (patient_id, doctor_id, appointment_date, reason) VALUES (?,?,?,?)";
        try {
            PreparedStatement psmt = conn.prepareStatement(query);
            psmt.setInt(1, appointment.getPatientId());
            psmt.setInt(2, appointment.getDoctorId());
            psmt.setDate(3, new java.sql.Date(appointment.getAppointmentDate().getTime()));
            psmt.setString(4, appointment.getReason());
            psmt.executeUpdate();
            System.out.println("Appointment booked successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean isPatientRegistered(int patientId) {
        String query = "SELECT id FROM Patient WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(query)) {
            psmt.setInt(1, patientId);
            ResultSet rs = psmt.executeQuery();
            if (rs.next())
            	return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isDoctorRegistered(int doctorId) {
        String query = "SELECT id FROM Doctor WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(query)) {
            psmt.setInt(1, doctorId);
            ResultSet rs = psmt.executeQuery();
            if (rs.next())
            	return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Appointment getAppointmentById(int appointmentId) {
        Appointment appointment = null;
        String query = "SELECT * FROM Appointment WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(query)) {
            psmt.setInt(1, appointmentId);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                appointment = new Appointment(rs.getInt("id"), rs.getInt("patient_id"),
                        rs.getInt("doctor_id"), rs.getDate("appointment_date"), rs.getString("reason"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointment;
    }


    public void cancelAppointment(int appointmentId) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed.");
            return;
        }
        String query = "DELETE FROM Appointment WHERE id = ?";
        try (PreparedStatement psmt = conn.prepareStatement(query)) {
            psmt.setInt(1, appointmentId);
            psmt.executeUpdate();
            System.out.println("Appointment cancelled successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
