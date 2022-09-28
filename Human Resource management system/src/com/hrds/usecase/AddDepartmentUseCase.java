package com.hrds.usecase;

import java.util.Scanner;

import com.hrds.Dao.AdminDao;
import com.hrds.Dao.AdminDaoImpl;
import com.hrds.Dao.DepartmentDao;
import com.hrds.Dao.DepartmentDaoImpl;
import com.hrds.bean.Admin;
import com.hrds.bean.Department;
import com.hrds.exceptions.AdminException;

public class AddDepartmentUseCase {

	public static void main(String[] args) {
		
        Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Department Id :");
		int dId = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter Department Name :");
		String dName = sc.next();
		
		DepartmentDao dao=new DepartmentDaoImpl();
		Department department =new Department();
		
		department.setdId(dId);
		department.setdName(dName);
		
		String result =dao.addDepartment(department);
		 
      	System.out.println(result);

	}

}
