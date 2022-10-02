package com.hrds.Dao;

import java.util.List;

import com.hrds.bean.Admin;
import com.hrds.bean.Department;
import com.hrds.bean.DepartmentEmployee;
import com.hrds.bean.Employee;
import com.hrds.exceptions.AdminException;
import com.hrds.exceptions.DepartmentException;
import com.hrds.exceptions.EmployeeException;

public interface EmployeeDao {

	public String addEmployee(Employee employee,int dId) throws EmployeeException;
	
	public String transferEmployeeDepartment(int eId,int dId);
	
	public String grantLeave(String request);
	
	public Employee loginEmployee(String email,String password)throws EmployeeException;
	
	public Employee viewProfile(int dId) throws EmployeeException;
	
	public String upadateProfile(int eId,String eName,String eAddress,String eMobile);
	
	public String changePassword(int eId,String ePassword,String eEmail);

	public String applyLeave(String request, int id);
	
}
