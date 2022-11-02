package com.hrds.checkvalidnumber;

public class Check {

	public static boolean check(String s) {
		
		try {
			int num= Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			System.out.println("Enter valid number.");
			System.out.println("-----------------------------------------------");
			return false;
		}
		
	}
	
}
