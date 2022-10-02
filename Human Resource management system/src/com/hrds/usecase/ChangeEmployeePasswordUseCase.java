package com.hrds.usecase;

import java.util.Scanner;

import com.hrds.Dao.EmployeeDao;
import com.hrds.Dao.EmployeeDaoImpl;

public class ChangeEmployeePasswordUseCase {

	public static void main(String[] args) {
		
		    Scanner sc= new Scanner(System.in);
			
			System.out.println("Enter employee Id :");
			int eId = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter your Email :");
			String eEmail= sc.nextLine();
			
			System.out.println("Enter New Password :");
			String ePassword = sc.nextLine();
			
			
			EmployeeDao dao=new EmployeeDaoImpl();
			
			String result =dao.changePassword(eId,ePassword,eEmail);
			 
	      	System.out.println(result);
		
	}

}
