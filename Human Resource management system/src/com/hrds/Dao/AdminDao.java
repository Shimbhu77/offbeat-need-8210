package com.hrds.Dao;

import com.hrds.bean.Admin;
import com.hrds.exceptions.AdminException;

public interface AdminDao {
	
	public Admin loginAdmin(String email,String password)throws AdminException;
	

}
