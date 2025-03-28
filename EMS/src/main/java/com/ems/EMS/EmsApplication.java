package com.ems.EMS;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

 
import com.ems.EMS.model.Employee;
import com.ems.EMS.model.EmsAppConfig;
import com.ems.EMS.model.HR;
import com.ems.EMS.model.Payroll;
import com.ems.EMS.model.Performance;
import com.ems.EMS.service.EmployeeService;
import com.ems.EMS.service.HRService;
import com.ems.EMS.service.PayrollService;
import com.ems.EMS.service.PerformanceService;
 
@SpringBootApplication
public class EmsApplication {
 
	public static void main(String[] args) {
////		SpringApplication.run(EmsApplication.class, args);
//		//ApplicationContext context = new ClassPathXmlApplicationContext("emsConfiguration.xml");
//		ApplicationContext context = new AnnotationConfigApplicationContext(EmsAppConfig.class);
//		Employee emp = context.getBean("employee", Employee.class);
//		Payroll payroll = context.getBean("payroll", Payroll.class);
////		Performance performance = context.getBean("performance", Performance.class);
//		HR hr = context.getBean("hr", HR.class);
//		System.out.println(emp);
//		System.out.println("Calculated Salary: "+payroll.calculateSalary());
////		System.out.println(performance);
//		System.out.println(" -------------------- ");
//		hr.displayEmployees();
		
		ApplicationContext context = new AnnotationConfigApplicationContext(EmsAppConfig.class);
		System.out.println("Employee service");
		EmployeeService empService = context.getBean(EmployeeService.class);
		empService.printEmpDetails();
		System.out.println(empService.calAnnualSalary());
		System.out.println(empService.getEmployeeSkills());
		System.out.println("--------------------------------------------");
		
		System.out.println("HR service");
		HRService hrService = context.getBean(HRService.class);
		System.out.println(hrService.getEmpById(1));
		System.out.println("--------------------------------------------");
		
		System.out.println("Payroll service");
		PayrollService payrollService = context.getBean(PayrollService.class);
		System.out.println(payrollService.calAnnualbonus());
		System.out.println(payrollService.calAnnualdeduction());
		System.out.println(payrollService.toString());
		System.out.println("--------------------------------------------");
		
		System.out.println("Performance service");
		PerformanceService performanceService = context.getBean(PerformanceService.class);
		System.out.println(performanceService.IsEligibleForProject());
		System.out.println(performanceService.displayProjectList());
		System.out.println("--------------------------------------------");

		
		
		
		
	}
 
}