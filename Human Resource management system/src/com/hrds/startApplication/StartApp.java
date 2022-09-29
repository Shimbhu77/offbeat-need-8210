package com.hrds.startApplication;

import java.util.Scanner;

import com.hrds.Dao.AdminDaoImpl;
import com.hrds.Dao.DepartmentDaoImpl;
import com.hrds.Dao.EmployeeDaoImpl;
import com.hrds.usecase.AddDepartmentUseCase;
import com.hrds.usecase.AddEmployeeUseCase;
import com.hrds.usecase.AdminLoginUseCase;
import com.hrds.usecase.ChangeEmployeePasswordUseCase;
import com.hrds.usecase.EmployeeLoginUseCase;
import com.hrds.usecase.GrantLeaveUseCase;
import com.hrds.usecase.UpdateDepartmentUseCase;
import com.hrds.usecase.UpdateEmployeeProfileUseCase;
import com.hrds.usecase.ViewDepartmentUseCase;
import com.hrds.usecase.ViewEmployeeProfileUseCase;
import com.hrds.usecase.TransferEmployeeDepartmentUseCase;

public class StartApp {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		AdminDaoImpl adminDaoImpl =new AdminDaoImpl();
		
		DepartmentDaoImpl departmentDaoImpl =new DepartmentDaoImpl();
		
		EmployeeDaoImpl employeeDaoImpl =new EmployeeDaoImpl();
		
		System.out.println("Welcome to Human Resource Management system ");
		
		while(true)
		{
			System.out.println("1. Login as Admin ");
			System.out.println("2. Login as Employee");
			System.out.println("3. Exit Application");
			
			System.out.println("Enter a number 1 or 2 or 3");
			
			int login=sc.nextInt();
			
			if(login ==1)
			{
				AdminLoginUseCase adminlogin =new AdminLoginUseCase();
				adminlogin.main(args);
				boolean loopadmin=true;
				while(loopadmin)
				{
				System.out.println("1. Add new Department ");
				System.out.println("2. View department by id ");
				System.out.println("3. Update department by id");
				System.out.println("4. Add new Employee and give password ");
				System.out.println("5. Transfer Employee Department");
				System.out.println("6. GrantLeave request of Employee");
				System.out.println("7. Logout");
				
				System.out.println("Enter a number");
			    int num2=sc.nextInt();
			    
			    switch(num2)
			    {
			        case 1:
			        {
			        	AddDepartmentUseCase addDeparment =new AddDepartmentUseCase();
			        	addDeparment.main(args);
			        	break;
			        }
			        case 2:
			        {
			        	ViewDepartmentUseCase viewDeparment =new ViewDepartmentUseCase();
			        	viewDeparment.main(args);
			        	break;
			        }
			        case 3:
			        {
			        	UpdateDepartmentUseCase updateDeparment =new UpdateDepartmentUseCase();
			        	updateDeparment.main(args);
			        	break;
			        }
			        case 4:
			        {
			        	AddEmployeeUseCase addEmployeeUseCase =new AddEmployeeUseCase();
			        	addEmployeeUseCase.main(args);
			        	break;
			        }
			        case 5:
			        {
			        	TransferEmployeeDepartmentUseCase transferEmployeeDepartmentUseCase =new TransferEmployeeDepartmentUseCase();
			        	transferEmployeeDepartmentUseCase.main(args);
			        	break;
			        }
			        case 6:
			        {
			        	GrantLeaveUseCase grantLeaveUseCase =new GrantLeaveUseCase();
			        	grantLeaveUseCase.main(args);
			        	break;
			        }
			        default:
			        {
			        	System.out.println("Admin is Log out ");
			        	loopadmin=false;
			        	break;
			        }

			    }
			    
				} 
			
			}
			else if(login ==2)
			{
				EmployeeLoginUseCase employeelogin =new EmployeeLoginUseCase();
				employeelogin.main(args);
				
				boolean loopemployee=true;
				while(loopemployee)
				{
				System.out.println("1. View employee profile by id ");
				System.out.println("2. Update employee profile  by id");
				System.out.println("3. Change password ");
				System.out.println("4. apply for Leave request ");
				System.out.println("5. Logout");
				
				System.out.println("Enter a number");
			    int num2=sc.nextInt();
			    
			    switch(num2)
			    {
			        case 1:
			        {
			        	ViewEmployeeProfileUseCase viewEmployeeProfileUseCase =new ViewEmployeeProfileUseCase();
			        	viewEmployeeProfileUseCase.main(args);
			        	break;
			        }
			        case 2:
			        {
			        	UpdateEmployeeProfileUseCase updateEmployeeProfileUseCase =new UpdateEmployeeProfileUseCase();
			        	updateEmployeeProfileUseCase.main(args);
			        	break;
			        }
			        case 3:
			        {
			        	ChangeEmployeePasswordUseCase changeEmployeePasswordUseCase =new ChangeEmployeePasswordUseCase();
			        	changeEmployeePasswordUseCase.main(args);
			        	break;
			        }
			        case 4:
			        {
			        	GrantLeaveUseCase grantLeaveUseCase =new GrantLeaveUseCase();
			        	grantLeaveUseCase.main(args);
			        	break;
			        }
			        default:
			        {
			        	System.out.println("Employee is Log out ");
			        	loopemployee=false;
			        	break;
			        }

			    }
			    
				} 
		
			
			}
			else
			{
				System.out.println("Thank you for using our application");
				break;
				
			}
		}
		
		
		
		
		


	}

}
