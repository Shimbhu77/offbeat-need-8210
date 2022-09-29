package com.hrds.usecase;

import java.util.Scanner;

import com.hrds.Dao.DepartmentDao;
import com.hrds.Dao.DepartmentDaoImpl;
import com.hrds.Dao.EmployeeDao;
import com.hrds.Dao.EmployeeDaoImpl;
import com.hrds.bean.Department;
import com.hrds.bean.Employee;
import com.hrds.exceptions.EmployeeException;

public class AddEmployeeUseCase {

	public static void main(String[] args) {
		
		    Scanner sc= new Scanner(System.in);
			
			System.out.println("Enter Employee Email :");
		    String eEmail= sc.nextLine();
			
			System.out.println("Enter Employee Password :");
			String ePassword = sc.nextLine();
			
			System.out.println("Enter Employee Salary :");
			int eSalary = sc.nextInt();
			
			System.out.println("Enter Department Id for assigning employeee :");
			int dId = sc.nextInt();
			
			EmployeeDao dao=new EmployeeDaoImpl();
			Employee employee =new Employee();
			
			employee.seteEmail(eEmail);
			employee.setePassword(ePassword);
			employee.seteSalary(eSalary);
			
			String result = null;
			try {
				result = dao.addEmployee(employee,dId);
			} catch (EmployeeException e) {
				result=e.getMessage();
			}
			 
	      	System.out.println(result);
	}
	
}

