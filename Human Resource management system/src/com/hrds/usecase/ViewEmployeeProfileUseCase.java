package com.hrds.usecase;

import java.util.Scanner;

import com.hrds.Dao.DepartmentDao;
import com.hrds.Dao.DepartmentDaoImpl;
import com.hrds.Dao.EmployeeDao;
import com.hrds.Dao.EmployeeDaoImpl;
import com.hrds.bean.Department;
import com.hrds.bean.Employee;
import com.hrds.exceptions.DepartmentException;
import com.hrds.exceptions.EmployeeException;

public class ViewEmployeeProfileUseCase {

	public static void main(String[] args) {
		
        Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter employee id :");
		int eId = sc.nextInt();
		
		
		 EmployeeDao dao=new EmployeeDaoImpl();
		 
		try {
			Employee  employee= dao.viewProfile(eId);
			
			System.out.println("Welcome "+employee.geteName()+".");
			System.out.println("Your employee id  is "+employee.geteId());
			System.out.println("Your name is "+employee.geteName());
			System.out.println("Your Email is "+employee.geteEmail());
			System.out.println("Your Address is "+employee.geteAddress());
			System.out.println("Your Mobile no. is "+employee.geteMobile());
			System.out.println("Your Salary is "+employee.geteSalary());
			
			
		} catch (EmployeeException e) {
			
			System.out.println(e.getMessage());
		}

	}

}
