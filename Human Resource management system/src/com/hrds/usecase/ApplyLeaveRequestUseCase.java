package com.hrds.usecase;

import java.util.Scanner;

import com.hrds.Dao.EmployeeDao;
import com.hrds.Dao.EmployeeDaoImpl;

public class ApplyLeaveRequestUseCase {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Your employee id  :");
		int id= sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter Reason for leave request :");
		
		System.out.println("Enter 1 for Emergency");
		System.out.println("Enter 2 for Sickness");
		System.out.println("Enter 3 for some other work");
		String reason= sc.next();
		
		String request;
		
		if(reason.equals("1"))
		{
			request ="Emergency.";
		}
		else if(reason.equals("2"))
		{
			request ="Illness.";
		}
		else
		{
			request ="some other work Reason.";
		}
		
		EmployeeDao dao=new EmployeeDaoImpl();
		
//		String permission = dao.grantLeave(request);
//		System.out.println(permission);
		String permission = dao.applyLeave(request,id);
		System.out.println(permission);

	}
	
}
