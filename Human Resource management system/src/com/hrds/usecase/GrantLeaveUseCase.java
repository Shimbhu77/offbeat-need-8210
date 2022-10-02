package com.hrds.usecase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.hrds.Dao.EmployeeDao;
import com.hrds.Dao.EmployeeDaoImpl;
import com.hrds.utility.DBUtil;

public class GrantLeaveUseCase {

	public static void main(String[] args) {
		
        Scanner sc= new Scanner(System.in);
		
        
       String message=" Empty list";
		
		try(Connection conn =DBUtil.provideConnection()){
			
            PreparedStatement ps=conn.prepareStatement("select * from leaveRequest");
			
			
			ResultSet rs =ps.executeQuery();
			boolean flag =true;
			
			while(rs.next())
			{
				flag=false;
				int id=rs.getInt("eId");
				String r=rs.getString("reason");
				
				System.out.println("employee id "+id+" is applied for leave request for this reason "+r);
			
				System.out.println("Enter 1 for Accept");
				System.out.println("Enter 2 for Deny");
				System.out.println("Enter a number  :");
				
				String reason= sc.next();
				
				String request;
				
				if(reason.equals("1"))
				{
					request ="leave request is accepted";
					PreparedStatement ps1=conn.prepareStatement("delete from leaveRequest where eId=?");
					ps1.setInt(1, id);
					
					int x=ps1.executeUpdate();
					
				}
				else
				{
					request ="leave request is denied";
					PreparedStatement ps1=conn.prepareStatement("delete from leaveRequest where eId=?");
					ps1.setInt(1, id);
					
					int x=ps1.executeUpdate();
				}
				
				System.out.println(request);
			
			}
			if(flag){
				System.out.println("empty list ");
			}
			
			
		} catch (SQLException e) {
			message=e.getMessage();
			System.out.println(message);
		}
        
		
		

	}

}
