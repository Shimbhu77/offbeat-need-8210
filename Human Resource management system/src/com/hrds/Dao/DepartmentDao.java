package com.hrds.Dao;

import java.util.List;

import com.hrds.bean.Department;
import com.hrds.bean.DepartmentEmployee;
import com.hrds.exceptions.DepartmentException;

public interface DepartmentDao {

	public String addDepartment(Department department);
	
	public Department viewDepartment(int dId) throws DepartmentException;
	
	public List<DepartmentEmployee> viewDepartmentEmployees(int dId) throws DepartmentException;
	
	public String upadateDepartment(int dId,String dName);
	
	public List<Department> viewAllDepartment() throws DepartmentException;
	
}
