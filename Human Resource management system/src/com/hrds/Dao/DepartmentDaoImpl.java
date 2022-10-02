package com.hrds.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hrds.bean.Department;
import com.hrds.bean.DepartmentEmployee;
import com.hrds.exceptions.DepartmentException;
import com.hrds.utility.DBUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public String addDepartment(Department department) {
		
		String message ="not inserted ";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("insert into department(dName) values(?)");
		
//			ps.setInt(1, department.getdId());
			ps.setString(1, department.getdName());
			
			int x = ps.executeUpdate();
			
			if(x>0)
				message="New department added and automatic generated id of department Succuessfully.";
			
			PreparedStatement ps1=conn.prepareStatement("select dId from department where dName=?");
			
			ps1.setString(1, department.getdName());
			
			ResultSet rs1=ps1.executeQuery();
			
			if(rs1.next())
			{
				int id=rs1.getInt("dId");
				System.out.println("generated department id is "+id);
			}
			else
			{
				System.out.println("id not found");
			}
			
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
			
			 PreparedStatement ps1=conn.prepareStatement("update employee set eDName= ? where eDId=?");
				
			 
			    ps1.setString(1, dName);
	            ps1.setInt(2, dId);
	           
	            int y =ps1.executeUpdate();
	            if(y>0)
	            {
//	            	System.out.println("dname updated in employee table");
	            }
			
		} catch (SQLException e) {
			message=e.getMessage();
		}
	
		return message;
		
	}

	@Override
	public List<DepartmentEmployee> viewDepartmentEmployees(int dId) throws DepartmentException {
		
		
		List<DepartmentEmployee> list=new ArrayList<>();
;      
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select d.dName,d.dId ,e.eName,e.eId,e.eEmail,e.eAddress,e.eMobile,e.eSalary from department d INNER JOIN employee e where e.eDId=? and d.dId=?");
			
			ps.setInt(1,dId);
			ps.setInt(2,dId);
			
			ResultSet rs=ps.executeQuery();
	
			boolean flag=false;
			while(rs.next())
			{
				flag=true;
				DepartmentEmployee department=null;
				int id= rs.getInt("dId");
				String n=rs.getString("dName");
				int eid= rs.getInt("eId");
				String en=rs.getString("eName");
				String ee=rs.getString("eEmail");
				int es=rs.getInt("eSalary");
				String ea=rs.getString("eAddress");
				String em=rs.getString("eMobile");
			    
			   department =new DepartmentEmployee(id,n,eid,en,ee,ea,em,es);
			   list.add(department);
//			   System.out.println(department);
			}
			if(!flag)
			{
				throw new DepartmentException("No result found with this Department id "+dId);
			}
			
			
		} catch (SQLException e) {
			
			throw new DepartmentException(e.getMessage());
		}
		
//		System.out.println("list"+list);
		
		return list;
	
	}

	@Override
	public List<Department> viewAllDepartment() throws DepartmentException {
		
		List<Department> list=new ArrayList<>();      
				
				try(Connection conn = DBUtil.provideConnection()) {
					
					PreparedStatement ps=conn.prepareStatement("select * from department");
					
					ResultSet rs=ps.executeQuery();
			
					boolean flag=false;
					while(rs.next())
					{
						flag=true;
						Department department=null;
						int id= rs.getInt("dId");
						String n=rs.getString("dName");
					    
					   department =new Department(id,n);
					   list.add(department);
//					   System.out.println(department);
					}
					if(!flag)
					{
						throw new DepartmentException("No result found , list is empty ");
					}
					
					
				} catch (SQLException e) {
					
					throw new DepartmentException(e.getMessage());
				}
				
//				System.out.println("list"+list);
				
				return list;
	}

	



	
	
}
