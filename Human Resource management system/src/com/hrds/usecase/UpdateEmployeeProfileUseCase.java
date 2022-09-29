package com.hrds.usecase;

import java.util.Scanner;

import com.hrds.Dao.DepartmentDao;
import com.hrds.Dao.DepartmentDaoImpl;
import com.hrds.Dao.EmployeeDao;
import com.hrds.Dao.EmployeeDaoImpl;

public class UpdateEmployeeProfileUseCase {

	public static void main(String[] args) {
		
	    Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter employee Id :");
		int eId = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter updated Name :");
		String eName = sc.nextLine();
		
		System.out.println("Enter updated Address :");
		String eAddress = sc.nextLine();
		
		System.out.println("Enter updated Mobile no. :");
		String eMobile = sc.nextLine();
		
		
		EmployeeDao dao=new EmployeeDaoImpl();
		
		String result =dao.upadateProfile(eId, eName,eAddress,eMobile);
		 
      	System.out.println(result);
	}
	
}
