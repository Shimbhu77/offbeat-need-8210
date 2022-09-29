package com.hrds.usecase;

import java.util.Scanner;

import com.hrds.Dao.DepartmentDao;
import com.hrds.Dao.DepartmentDaoImpl;
import com.hrds.Dao.EmployeeDao;
import com.hrds.Dao.EmployeeDaoImpl;

public class TransferEmployeeDepartmentUseCase {

	public static void main(String[] args) {
		

	    Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter employee Id :");
		int eId = sc.nextInt();
		
		System.out.println("Enter trasfered  Department id :");
		int dId = sc.nextInt();
		
		EmployeeDao dao=new EmployeeDaoImpl();
		
		String result =dao.transferEmployeeDepartment(eId, dId);
		 
      	System.out.println(result);

	}

}
