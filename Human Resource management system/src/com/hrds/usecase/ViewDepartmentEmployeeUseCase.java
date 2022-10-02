package com.hrds.usecase;

import java.util.List;
import java.util.Scanner;

import com.hrds.Dao.DepartmentDao;
import com.hrds.Dao.DepartmentDaoImpl;
import com.hrds.bean.Department;
import com.hrds.bean.DepartmentEmployee;
import com.hrds.exceptions.DepartmentException;

public class ViewDepartmentEmployeeUseCase {

      public static void main(String[] args) {
		
        Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Department id :");
		int dId = sc.nextInt();
		
		
		 DepartmentDao dao=new DepartmentDaoImpl();
		 
		try {
			List<DepartmentEmployee> list = dao.viewDepartmentEmployees(dId);
			
			System.out.println("Welcome to "+list.get(0).getdName()+" Department.");
			System.out.println();
			int count=1;
			for(DepartmentEmployee employee:list)
			{
				System.out.println("employee :"+count);
				System.out.println("employee id  is "+employee.geteId());
				System.out.println("employee name is "+employee.geteName());
				System.out.println("employee Email is "+employee.geteEmail());
				System.out.println("employee Address is "+employee.geteAddress());
				System.out.println("employee Mobile no. is "+employee.geteMobile());
				System.out.println("employee Salary is "+employee.geteSalary());
				System.out.println("employee department id is "+employee.getdId());
				System.out.println("employee department name is "+employee.getdName());
				System.out.println("=======================================================");
				count++;
			}
			
		} catch (DepartmentException e) {
			
			System.out.println(e.getMessage());
		}

	}
	
}
