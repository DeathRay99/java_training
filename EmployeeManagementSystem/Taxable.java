package EmployeeManagementSystem;

public interface Taxable {
	// by default -> public static final
	double Tax_Rate=0.20;
	// by default -> abstract
	double calculateTax(double salary);

}
