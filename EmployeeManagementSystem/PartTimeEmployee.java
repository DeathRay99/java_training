package EmployeeManagementSystem;

public class PartTimeEmployee extends Employee implements WorkHours {
	
    private double hourlyRate;
    private int contractHours;
	public PartTimeEmployee(String empName, int empId, String department, double baseSalary, int leaveBalance, double hourlyRate, int contractHours) {
		super(empName, empId, department, baseSalary, leaveBalance);
		this.hourlyRate=hourlyRate;
		this.contractHours=contractHours;
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
	public int getWorkHours() {
		// TODO Auto-generated method stub
		return contractHours;
	}
	@Override
	double calculateSalary() {
		// TODO Auto-generated method stub
		return hourlyRate*contractHours;
	}
	@Override
	String getEmploymentType() {
		// TODO Auto-generated method stub
		return "Part Time Employee";
	}
	@Override
	void provideBenifits() {
		// TODO Auto-generated method stub
		System.out.println("Reimbursements ");
		
	}

}
