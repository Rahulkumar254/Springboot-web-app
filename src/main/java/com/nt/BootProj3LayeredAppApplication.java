package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj3LayeredAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootProj3LayeredAppApplication.class, args);
		PayrollOperationsController controller=ctx.getBean("payroll",PayrollOperationsController.class);
		
		try {
			List<Employee> list=controller.showEmployeesByDesgs("CLERK", "MANAGER", "SALESMAN");
			list.forEach(emp->{
				System.out.println(emp);
			});
		}//try
		catch(Exception e) {
			e.printStackTrace();
			System.err.println("Internal problem--try again::"+e.getMessage());
		}//catch
		//close IOC container
		((ConfigurableApplicationContext) ctx).close();
		
		
	}

}
