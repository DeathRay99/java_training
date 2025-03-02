package EmployeeManagementSystem;

public class ManagerEmployee extends FullTimeEmployee implements BonusProvider{

	public ManagerEmployee(String empName, int empId, String department, double baseSalary, int leaveBalance,
			double bonus) {
		super(empName, empId, department, baseSalary, leaveBalance, bonus);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateBonus(double salary) {
		// TODO Auto-generated method stub
		return salary*Bonus_Percentage;
	}
	

}
