package com.hrds.usecase;

import java.util.Scanner;

import com.hrds.Dao.AdminDao;
import com.hrds.Dao.AdminDaoImpl;
import com.hrds.Dao.EmployeeDao;
import com.hrds.Dao.EmployeeDaoImpl;
import com.hrds.bean.Admin;
import com.hrds.bean.Employee;
import com.hrds.exceptions.AdminException;
import com.hrds.exceptions.EmployeeException;

public class EmployeeLoginUseCase {

	public static void main(String[] args) {
		
        Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Email :");
		String email = sc.next();
		
		System.out.println("Enter Password:");
		String pass = sc.next();
		
		EmployeeDao dao=new EmployeeDaoImpl();
		 
		try {
			Employee employee = dao.loginEmployee(email,pass);
			
			System.out.println("Welcome  , Hi "+employee.geteEmail());
			System.out.println("Your employee id is "+employee.geteId());
			
		} catch (EmployeeException e) {
			
			System.out.println(e.getMessage());
		}

	}

}
