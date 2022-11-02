package com.hrds.usecase;

import java.util.Scanner;

import com.hrds.Dao.AdminDao;
import com.hrds.Dao.AdminDaoImpl;
import com.hrds.bean.Admin;
import com.hrds.exceptions.AdminException;

public class AdminLoginUseCase {

	public static boolean main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Email :");
		String email = sc.next();
		
		System.out.println("Enter Password:");
		String pass = sc.next();
		
		AdminDao dao=new AdminDaoImpl();
		 
		try {
			Admin admin = dao.loginAdmin(email,pass);
			
			System.out.println("Welcome  , Hi "+admin.getaName());
//			System.out.println(admin);
			return true;
			
		} catch (AdminException e) {
			
			System.out.println(e.getMessage());
			return false;
		}
		
		
	}
  
	
}
