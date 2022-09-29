package com.hrds.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hrds.bean.Department;
import com.hrds.exceptions.DepartmentException;
import com.hrds.utility.DBUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public String addDepartment(Department department) {
		
		String message ="not inserted ";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("insert into department values(?,?)");
		
			ps.setInt(1, department.getdId());
			ps.setString(2, department.getdName());
			
			int x = ps.executeUpdate();
			
			if(x>0)
				message="New department added Succuessfully.";
			
			
		} catch (SQLException e) {
			
			message=e.getMessage();
			
		}
	
		return message;
		
	}

	@Override
	public Department viewDepartment(int dId) throws DepartmentException  {
		
		Department department=null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from department where dId=?");
			
			ps.setInt(1,dId);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				int id= rs.getInt("dId");
				String n=rs.getString("dName");
			    
			   department =new Department(id,n);
			}
			else
			{
				throw new DepartmentException("No result found with this Department id "+dId);
			}
			
			
		} catch (SQLException e) {
			
			throw new DepartmentException(e.getMessage());
		}
		
		
		
		return department;
		
	}

	@Override
	public String upadateDepartment(int dId ,String dName) {
		
		String message =" not updated ";
		
		try(Connection conn =DBUtil.provideConnection()){
			
            PreparedStatement ps=conn.prepareStatement("update department set dName =? where dId=?");
			
            ps.setString(1, dName);
			ps.setInt(2,dId);
			
			
			int x =ps.executeUpdate();
			
			if(x>0)
				message ="Department name updated successfully.";
			
		} catch (SQLException e) {
			message=e.getMessage();
		}
	
		return message;
		
	}



	
	
}
