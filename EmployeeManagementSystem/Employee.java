package EmployeeManagementSystem;

abstract class Employee implements Person {
	
	protected String empName;
	protected int empId;
	protected String department;
	protected double baseSalary;
	protected int leaveBalance;
	
	public Employee(String empName, int empId, String department, double baseSalary, int leaveBalance) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.department = department;
		this.baseSalary = baseSalary;
		this.leaveBalance = leaveBalance;
	}
	
	abstract double calculateSalary();
	abstract String getEmploymentType();
	abstract void provideBenifits();
	
	public boolean requestLeaves(int days) {
		if(days<=leaveBalance) {
			leaveBalance-=days;
			System.out.println("Leaves approved for days: "+days);
			return true;
		}
		else {
			System.out.println("Leaves not granted. ");
			return false;
		}
	}
	@Override
	public void displayInfo() {
		System.out.println("-----------------");
		System.out.println("Emp Name : "+empName+" Emp Id: "+empId+" Department: " +department);
		System.out.println("Employment Type: "+getEmploymentType());
		System.out.println("Monthly Salary: "+calculateSalary());
		System.out.println("Leave Balance : "+leaveBalance);
		provideBenifits();
		
		
		
		
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public int getLeaveBalance() {
		return leaveBalance;
	}

	public void setLeaveBalance(int leaveBalance) {
		this.leaveBalance = leaveBalance;
	}
	
	

}
