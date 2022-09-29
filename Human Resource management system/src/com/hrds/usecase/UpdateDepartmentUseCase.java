package com.hrds.usecase;

import java.util.Scanner;

import com.hrds.Dao.DepartmentDao;
import com.hrds.Dao.DepartmentDaoImpl;
import com.hrds.bean.Department;

public class UpdateDepartmentUseCase {

	public static void main(String[] args) {
		
		    Scanner sc= new Scanner(System.in);
			
			System.out.println("Enter Department Id :");
			int dId = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter new Department Name :");
			String dName = sc.nextLine();
			
			DepartmentDao dao=new DepartmentDaoImpl();
			
			String result =dao.upadateDepartment(dId, dName);
			 
	      	System.out.println(result);
	}
}
