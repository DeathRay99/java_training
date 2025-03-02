package EmployeeManagementSystem;
import java.util.*;

class NoEmployeeException extends Exception {
    public NoEmployeeException(String message) {
        super(message);
    }
}

class MaxEmployeesReachedException extends Exception {
    public MaxEmployeesReachedException(String message) {
        super(message);
    }
}

public class EMSApplication {
    private static int totalEmp = 0;
    private static int maxEmp = 5;
    private static Employee[] employees = new Employee[5];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Employee Management Application");
            System.out.println("Press 1 : To enter a Full Time Employee ");
            System.out.println("Press 2 : To enter a Part Time Employee ");
            System.out.println("Press 3 : To enter an Intern ");
            System.out.println("Press 4 : To enter a Manager ");
            System.out.println("Press 5 : Details of all Employees ");
            System.out.println("Press 6 : Apply leave ");
            
            int choice = scanner.nextInt();
            
            try {
                switch (choice) {
                    case 1:
                        createFTE(scanner);
                        break;
                    case 2:
                        createPartTime(scanner);
                        break;
                    case 3:
                        createIntern(scanner);
                        break;
                    case 4:
                        createManager(scanner);
                        break;
                    case 5:
                        allEmployeeDetails();
                        break;
                    case 6:
                        applyLeave(scanner);
                        break;
                    default:
                        System.out.println("Thank you, exiting from system");
                        scanner.close();
                        return;
                }
            } catch (NoEmployeeException | MaxEmployeesReachedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void createFTE(Scanner scanner) throws MaxEmployeesReachedException {
        if (totalEmp >= maxEmp) {
            throw new MaxEmployeesReachedException("Sorry, cannot enter more employees.");
        }
        System.out.println("Enter emp name ");
        String empName = scanner.next();
        System.out.println("Enter empId ");
        int empId = scanner.nextInt();
        System.out.println("Enter department ");
        String empDep = scanner.next();
        System.out.println("Enter baseSalary ");
        double empBaseSalary = scanner.nextDouble();
        System.out.println("Enter leaveBalance ");
        int empLeaveBalance = scanner.nextInt();
        System.out.println("Enter Bonus ");
        int empBonus = scanner.nextInt();
        
        employees[totalEmp] = new FullTimeEmployee(empName, empId, empDep, empBaseSalary, empLeaveBalance, empBonus);
        totalEmp++;
    }

    public static void createIntern(Scanner scanner) throws MaxEmployeesReachedException {
        if (totalEmp >= maxEmp) {
            throw new MaxEmployeesReachedException("Sorry, cannot enter more employees.");
        }
        System.out.println("Enter emp name ");
        String empName = scanner.next();
        System.out.println("Enter empId ");
        int empId = scanner.nextInt();
        System.out.println("Enter department ");
        String empDep = scanner.next();
        System.out.println("Enter Stipend ");
        double empBaseSalary = scanner.nextDouble();
        System.out.println("Enter leaveBalance ");
        int empLeaveBalance = scanner.nextInt();
        
        employees[totalEmp] = new InternEmployee(empName, empId, empDep, empBaseSalary, empLeaveBalance);
        totalEmp++;
    }

    public static void createPartTime(Scanner scanner) throws MaxEmployeesReachedException {
        if (totalEmp >= maxEmp) {
            throw new MaxEmployeesReachedException("Sorry, cannot enter more employees.");
        }
        System.out.println("Enter emp name ");
        String empName = scanner.next();
        System.out.println("Enter empId ");
        int empId = scanner.nextInt();
        System.out.println("Enter department ");
        String empDep = scanner.next();
        System.out.println("Enter hourlyRate ");
        double empHourlyRate = scanner.nextDouble();
        System.out.println("Enter ContractHours ");
        int empContractHours = scanner.nextInt();
        System.out.println("Enter leaveBalance ");
        int empLeaveBalance = scanner.nextInt();
        
        employees[totalEmp] = new PartTimeEmployee(empName, empId, empDep, 0, empLeaveBalance, empHourlyRate, empContractHours);
        totalEmp++;
    }

    public static void allEmployeeDetails() throws NoEmployeeException {
        if (totalEmp == 0) {
            throw new NoEmployeeException("No employees found.");
        }
        for (int i = 0; i < totalEmp; i++) {
            System.out.println("Payroll AND Employee Details of: " + (i + 1) + " employee is ");
            employees[i].displayInfo();
            PayrollManager.generatePayroll(employees[i]);
        }
        System.out.println(" ----------------------------------------- ");
    }

    public static void createManager(Scanner scanner) throws MaxEmployeesReachedException {
        if (totalEmp >= maxEmp) {
            throw new MaxEmployeesReachedException("Sorry, cannot enter more employees.");
        }
        System.out.println("Enter emp name ");
        String empName = scanner.next();
        System.out.println("Enter empId ");
        int empId = scanner.nextInt();
        System.out.println("Enter department ");
        String empDep = scanner.next();
        System.out.println("Enter baseSalary ");
        double empBaseSalary = scanner.nextDouble();
        System.out.println("Enter leaveBalance ");
        int empLeaveBalance = scanner.nextInt();
        System.out.println("Enter Bonus ");
        int empBonus = scanner.nextInt();
        
        employees[totalEmp] = new ManagerEmployee(empName, empId, empDep, empBaseSalary, empLeaveBalance, empBonus);
        totalEmp++;
    }

    public static void applyLeave(Scanner scanner) {
        System.out.println("Enter empId ");
        int empId = scanner.nextInt();
        System.out.println("Enter no. of leaves ");
        int leave = scanner.nextInt();
        
        for (int i = 0; i < totalEmp; i++) {
            if (employees[i].getEmpId() == empId) {
                employees[i].requestLeaves(leave);
                System.out.println("Your remaining leave balance is: " + employees[i].getLeaveBalance());
                return;
            }
        }
        System.out.println("Employee not found ");
    }
}
