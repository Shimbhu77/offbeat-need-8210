package com.hrds.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hrds.bean.Admin;
import com.hrds.exceptions.AdminException;
import com.hrds.utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public Admin loginAdmin(String email, String password) throws AdminException {
		
		
		Admin admin =null;
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps =conn.prepareStatement("select * from admin where aEmail=? and aPassword =?");
			
			ps.setString(1,email);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next())
			{
				int id= rs.getInt("aId");
				String n= rs.getString("aName");
				String e= rs.getString("aEmail");
				String p= rs.getString("aPassword");
				
				admin = new Admin(id,n,e,p);
			}
			else
			{
				throw new AdminException("Invalid Email or Password.");
			}
			
		} catch (SQLException e) {
			
			throw new AdminException(e.getMessage());
		}
		
		
		
		return admin;
	}

}
