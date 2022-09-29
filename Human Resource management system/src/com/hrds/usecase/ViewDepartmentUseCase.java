package com.hrds.usecase;

import java.util.Scanner;

import com.hrds.Dao.AdminDao;
import com.hrds.Dao.AdminDaoImpl;
import com.hrds.Dao.DepartmentDao;
import com.hrds.Dao.DepartmentDaoImpl;
import com.hrds.bean.Admin;
import com.hrds.bean.Department;
import com.hrds.exceptions.AdminException;
import com.hrds.exceptions.DepartmentException;

public class ViewDepartmentUseCase {

	public static void main(String[] args) {
		
        Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Department id :");
		int dId = sc.nextInt();
		
		
		 DepartmentDao dao=new DepartmentDaoImpl();
		 
		try {
			Department department = dao.viewDepartment(dId);
			
			System.out.println("Welcome to "+department.getdName()+" Department.");
			System.out.println(department);
			
		} catch (DepartmentException e) {
			
			System.out.println(e.getMessage());
		}

	}

}
