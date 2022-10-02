package com.hrds.usecase;

import java.util.List;
import java.util.Scanner;

import com.hrds.Dao.DepartmentDao;
import com.hrds.Dao.DepartmentDaoImpl;
import com.hrds.bean.Department;
import com.hrds.bean.DepartmentEmployee;
import com.hrds.exceptions.DepartmentException;

public class ViewAllDepartmentUseCase {

	public static void main(String[] args) {
		
		
		 DepartmentDao dao=new DepartmentDaoImpl();
		 
			try {
				List<Department> list = dao.viewAllDepartment();
	
				int count=1;
				for(Department employee:list)
				{
					System.out.println("department :"+count);
					System.out.println("department id is "+employee.getdId());
					System.out.println("department name is "+employee.getdName());
					System.out.println("=======================================================");
					count++;
				}
				
			} catch (DepartmentException e) {
				
				System.out.println(e.getMessage());
			}
		
	}
	
		
	
}
