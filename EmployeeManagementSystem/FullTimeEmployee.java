package EmployeeManagementSystem;

public class FullTimeEmployee extends Employee implements Taxable, WorkHours{
	
	private double bonus;

	public FullTimeEmployee(String empName, int empId, String department, double baseSalary, int leaveBalance, double bonus) {
		super(empName, empId, department, baseSalary, leaveBalance);
		this.bonus=bonus;
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
		return Standard_Workhours;
	}

	@Override
	public double calculateTax(double salary) {
		// TODO Auto-generated method stub
		return salary*0.20;
	}

	@Override
	double calculateSalary() {
		// TODO Auto-generated method stub
		return baseSalary+bonus;
	}

	@Override
	String getEmploymentType() {
		// TODO Auto-generated method stub
		return "Full Time Employee";
	}

	@Override
	void provideBenifits() {
		// TODO Auto-generated method stub
		System.out.println("Health Insurance Benifits, PF. ");
		
	}

	
	

}
