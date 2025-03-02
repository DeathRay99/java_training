package EmployeeManagementSystem;

public class InternEmployee extends Employee{

	public InternEmployee(String empName, int empId, String department, double baseSalary, int leaveBalance) {
		super(empName, empId, department, baseSalary, leaveBalance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return empName;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return empId;
	}

	@Override
	double calculateSalary() {
		// TODO Auto-generated method stub
		return baseSalary;
	}

	@Override
	String getEmploymentType() {
		// TODO Auto-generated method stub
		return "Intern";
	}

	@Override
	void provideBenifits() {
		// TODO Auto-generated method stub
		System.out.println("conversion to FTE. ");
		
	}
	

}
