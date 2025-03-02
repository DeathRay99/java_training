package HMSystem;
import java.sql.SQLException;
import java.util.*;

public class HMSApplication {

    private static PatientDAO pd = new PatientDAO();
    private static DoctorDAO dd = new DoctorDAO();
    private static AppointmentDAO ad = new AppointmentDAO();
    private static StaffDAO sd = new StaffDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        while (true) {
            System.out.println("HMS Application");
            System.out.println("Press 1 : Manage Patients");
            System.out.println("Press 2 : Manage Doctors");
            System.out.println("Press 3 : Manage Appointments");
            System.out.println("Press 4 : Manage Staff");
            System.out.println("Press 5 : Exit");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    managePatients();
                    break;
                case 2:
                    manageDoctors();
                    break;
                case 3:
                    manageAppointments();
                    break;
                case 4:
                    manageStaff();
                    break;
                case 5:
                    System.out.println("Thank you, exiting from system");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
    
    private static void managePatients() throws SQLException {
        while (true) {
            System.out.println("Manage Patients");
            System.out.println("Press 1 : To add new patient");
            System.out.println("Press 2 : To get all patients");
            System.out.println("Press 3 : To update name of patient");
            System.out.println("Press 4 : To delete a patient");
            System.out.println("Press 5 : Back to Main Menu");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    Patient p = new Patient("temp3", "temp4", 56, "female", "887999567");
                    pd.addPatient(p);
                    break;
                case 2:
                    System.out.println(pd.getAllPatients());
                    break;
                case 3:
                    System.out.println("Enter patient id");
                    int patientId = scanner.nextInt();
                    pd.updatePatient(patientId, scanner);
                    break;
                case 4:
                    System.out.println("Enter patient id");
                    patientId = scanner.nextInt();
                    pd.deletePatient(patientId);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }

    private static void manageDoctors() throws SQLException {
        while (true) {
            System.out.println("Manage Doctors");
            System.out.println("Press 1 : To add new doctor");
            System.out.println("Press 2 : To get all doctors");
            System.out.println("Press 3 : To update name of doctor");
            System.out.println("Press 4 : To delete a doctor");
            System.out.println("Press 5 : Back to Main Menu");
            
            int choice = scanner.nextInt();
            
            try {
				switch (choice) {
				    case 1:
				        Doctor d = new Doctor("Dr. John Doe", "Cardiology", "9876543210");
				        dd.addDoctor(d);
				        break;
				    case 2:
				        System.out.println(dd.getAllDoctors());
				        break;
				    case 3:
				        System.out.println("Enter doctor id");
				        int doctorId = scanner.nextInt();
				        dd.updateDoctor(doctorId, scanner);
				        break;
				    case 4:
				        System.out.println("Enter doctor id");
				        doctorId = scanner.nextInt();
				        dd.deleteDoctor(doctorId);
				        break;
				    case 5:
				        return;
				    default:
				        System.out.println("Invalid choice, please try again.");
				        break;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

    private static void manageAppointments() throws SQLException {
        while (true) {
            System.out.println("Manage Appointments");
            System.out.println("Press 1 : To add new appointment");
            System.out.println("Press 2 : To get appointment by id");
            System.out.println("Press 3 : To delete an appointment");
            System.out.println("Press 4 : Back to Main Menu");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    Appointment appointment = new Appointment(1, 1, java.sql.Date.valueOf("2025-02-20"), "Routine Checkup");
                    ad.bookAppointment(appointment);
                    break;
                case 2:
                    System.out.println(ad.getAppointmentById(1));
                    break;
                case 3:
                    System.out.println("Enter appointment id to delete: ");
                    int appointmentId = scanner.nextInt();
                    ad.cancelAppointment(appointmentId);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }

    private static void manageStaff() throws SQLException {
        while (true) {
            System.out.println("Manage Staff");
            System.out.println("Press 1 : To add new staff member");
            System.out.println("Press 2 : To get all staff members");
            System.out.println("Press 3 : To update name of staff member");
            System.out.println("Press 4 : To delete a staff member");
            System.out.println("Press 5 : Back to Main Menu");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    Staff s = new Staff("John Dii", "Nurse", "9876543210");
                    sd.addStaff(s);
                    break;
                case 2:
                    System.out.println(sd.getAllStaff());
                    break;
                case 3:
                    System.out.println("Enter staff id");
                    int staffId = scanner.nextInt();
                    sd.updateStaff(staffId, scanner);
                    break;
                case 4:
                    System.out.println("Enter staff id");
                    staffId = scanner.nextInt();
                    sd.deleteStaff(staffId);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
}
