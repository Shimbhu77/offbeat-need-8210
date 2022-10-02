package com.hrds.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hrds.bean.Admin;
import com.hrds.bean.Department;
import com.hrds.bean.Employee;
import com.hrds.exceptions.AdminException;
import com.hrds.exceptions.DepartmentException;
import com.hrds.exceptions.EmployeeException;
import com.hrds.utility.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String addEmployee(Employee employee,int dId) throws EmployeeException {
		
		String message =" not inserted";
		
		
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
			PreparedStatement ps1= conn.prepareStatement("select * from department where dId =?");
			
			ps1.setInt(1, dId);
			
			ResultSet rs =ps1.executeQuery();
			
			if(rs.next())
			{
				String dName=rs.getString("dName");
				System.out.println("department name is "+dName+" id is "+dId);
				
				PreparedStatement ps= conn.prepareStatement("insert into employee(eEmail, ePassword ,eSalary,eDId ,eDName) values(?,?,?,?,?)");
				
				ps.setString(1, employee.geteEmail());
				ps.setString(2, employee.getePassword());
				ps.setInt(3, employee.geteSalary());
				ps.setInt(4,dId);
				ps.setString(5,dName);
				
				int x= ps.executeUpdate();
				
				if(x>0)
				{
					message="new employee added successfully";
					System.out.println(message);
				}	
				
				PreparedStatement ps3= conn.prepareStatement("select * from employee where eEmail =?");
				
				ps3.setString(1, employee.geteEmail());
				
				ResultSet rs1 =ps3.executeQuery();
				
				if(rs1.next())
				{
					
					
					System.out.println("auto generated employee id is  "+ rs1.getInt("eId") +" and Department id is "+dId);
					
					PreparedStatement ps2= conn.prepareStatement("insert into department_employee values(?,?)");
					
					ps2.setInt(1, rs1.getInt("eId"));
					ps2.setInt(2,dId);
					
	                int y= ps2.executeUpdate();
					
					if(y>0)
					{
						message="new employee added in a department successfully ";
					}	
			
				}
				else
				{
					System.out.println("unable to add department");
				}
				
			}
			else
			{
				throw new EmployeeException("Department not found.");
			}
			
			
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		
		return message;	
	}

	@Override
	public String transferEmployeeDepartment(int eId, int dId) {
		
		String message ="unable to transfer employee department";
		
        try(Connection conn =DBUtil.provideConnection()){
			
            PreparedStatement ps=conn.prepareStatement("update department_employee set dId =? where eId=?");
			
            ps.setInt(1, dId);
			ps.setInt(2,eId);
			
			
			int x =ps.executeUpdate();
			
			if(x>0)
				message ="Transfer Department of employee successfully.";
            
			PreparedStatement ps2=conn.prepareStatement("select dName from department where dId =?");
			
            ps2.setInt(1, dId);
            ResultSet rs=ps2.executeQuery();
            
            String name=null;
            if(rs.next())
            {
            	name =rs.getString("dName");
//            	System.out.println("name updated");
            }
			
            PreparedStatement ps1=conn.prepareStatement("update employee set eDId =? ,eDName= ? where eId=?");
			
            ps1.setInt(1, dId);
            ps1.setString(2, name);
			ps1.setInt(3,eId);
            int y =ps1.executeUpdate();
			
//			if(y>0)
//			{
//				System.out.println("employee table updated successfully.");
//			}
			
		} catch (SQLException e) {
			message=e.getMessage();
		}
	
		return message;
		
	}

	@Override
	public String grantLeave(String request) {
		
		String message="Leave request denied.";
		
		request =request.toLowerCase();
		
		if(request.equals("emergency") || request.equals("illness"))
		{
			message="Leave request accepted.";
		}
		
		return message;
		
	}

	@Override
	public Employee loginEmployee(String email, String password) throws EmployeeException {
		
		Employee employee = null;
		 
        try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps =conn.prepareStatement("select * from employee where eEmail=? and ePassword =?");
			
			ps.setString(1,email);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next())
			{
				int id= rs.getInt("eId");
				String n= rs.getString("eName");
				String e= rs.getString("eEmail");
				String p= rs.getString("ePassword");
				String a= rs.getString("eAddress");
				String m= rs.getString("eMobile");
				int s= rs.getInt("eSalary");
				int edid= rs.getInt("eDId");
				String edn= rs.getString("eDName");
				
				employee =new Employee(id,n,e,p,a,m,s,edid,edn);
			}
			else
			{
				throw new EmployeeException("Invalid Email or Password.");
			}
			
		} catch (SQLException e) {
			
			throw new EmployeeException(e.getMessage());
		}
		
		
		return employee;
		
	}

	@Override
	public Employee viewProfile(int eId) throws EmployeeException {
		
		Employee employee=null;
		
           try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from employee where eId=?");
			
			ps.setInt(1,eId);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				int id= rs.getInt("eId");
				String n= rs.getString("eName");
				String e= rs.getString("eEmail");
				String p= rs.getString("ePassword");
				String a= rs.getString("eAddress");
				String m= rs.getString("eMobile");
				int s= rs.getInt("eSalary");
				int edid= rs.getInt("eDId");
				String edn= rs.getString("eDName");
				
				employee =new Employee(id,n,e,p,a,m,s,edid,edn);
			}
			else
			{
				throw new EmployeeException("No result found with this employee id "+eId);
			}
			
			
		} catch (SQLException e) {
			
			throw new EmployeeException(e.getMessage());
		}
		
		return employee;
	}

	@Override
	public String upadateProfile(int eId, String eName, String eAddress, String eMobile) {
		
        String message ="profile not updated ";
		
		try(Connection conn =DBUtil.provideConnection()){
			
            PreparedStatement ps=conn.prepareStatement("update employee set eName =? ,eAddress=? ,eMobile =? where eId=?");
			
            ps.setString(1, eName);
            ps.setString(2, eAddress);
            ps.setString(3, eMobile);
			ps.setInt(4,eId);
			
			
			int x =ps.executeUpdate();
			
			if(x>0)
				message =" Profile updated successfully.";
			
		} catch (SQLException e) {
			message=e.getMessage();
		}
	
		return message;
		
	}

	@Override
	public String changePassword(int eId, String ePassword,String eEmail) {
		
		 String message ="Password not changed ";
			
			try(Connection conn =DBUtil.provideConnection()){
				
	            PreparedStatement ps=conn.prepareStatement("update employee set ePassword =? where eId=? and eEmail=?");
				
	            ps.setString(1, ePassword);
	            ps.setInt(2,eId);
	            ps.setString(3, eEmail);
				
				
				int x =ps.executeUpdate();
				
				if(x>0)
					message =" Password Changed successfully.";
				
			} catch (SQLException e) {
				message=e.getMessage();
			}
		
			return message;
		
	}

	@Override
	public String applyLeave(String request,int id) {
		
        String message=" not applied for Leave request";
		
		try(Connection conn =DBUtil.provideConnection()){
			
            PreparedStatement ps=conn.prepareStatement("insert into leaveRequest values(?,?)");
			
            ps.setString(1, request);
            ps.setInt(2, id);
			
			int x =ps.executeUpdate();
			
			if(x>0)
				message ="applied for leave request successfully.";
			
		} catch (SQLException e) {
			message=e.getMessage();
		}
	
		return message;
		
		
		
		
	}
	
}
