package com.hrds.Dao;

import com.hrds.bean.Department;
import com.hrds.exceptions.DepartmentException;

public interface DepartmentDao {

	public String addDepartment(Department department);
	
	public Department viewDepartment(int dId) throws DepartmentException;
	
	public String upadateDepartment(int dId,String dName);
	
	
	
}
