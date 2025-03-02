package EmployeeManagementSystem;

public class PayrollManager {
	
	public static void generatePayroll(Employee emp) {
		double salary=emp.calculateSalary();
		double extraBonus=(emp instanceof ManagerEmployee)?((ManagerEmployee)emp).calculateBonus(salary):0.0;
		double tax=(emp instanceof Taxable)?((Taxable)emp).calculateTax(salary+extraBonus):0.0;
		
		double netSalary=salary+extraBonus-tax;
		
		System.out.println("Payroll for: "+emp.getEmpName());
		System.out.println("Monthly Salary : "+salary+extraBonus);
		System.out.println("Tax Deduction : "+tax);
		System.out.println("Net Salary: "+netSalary);
	}

}
