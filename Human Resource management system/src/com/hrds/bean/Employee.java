package com.hrds.bean;

public class Employee {

	private int eId;
	private String eName;
	private String eEmail;
	private String ePassword;
	private String eAddress;
	private String eMobile;
	private int eSalary;
	private int eDId;
	private String eDName;
	
	
	public Employee() {
		super();
	}


	


	public Employee(int eId, String eName, String eEmail, String ePassword, String eAddress, String eMobile,
			int eSalary, int eDId, String eDName) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.eEmail = eEmail;
		this.ePassword = ePassword;
		this.eAddress = eAddress;
		this.eMobile = eMobile;
		this.eSalary = eSalary;
		this.eDId = eDId;
		this.eDName = eDName;
	}





	public int geteId() {
		return eId;
	}


	public void seteId(int eId) {
		this.eId = eId;
	}


	public String geteName() {
		return eName;
	}


	public void seteName(String eName) {
		this.eName = eName;
	}


	public String geteEmail() {
		return eEmail;
	}


	public void seteEmail(String eEmail) {
		this.eEmail = eEmail;
	}


	public String getePassword() {
		return ePassword;
	}


	public void setePassword(String ePassword) {
		this.ePassword = ePassword;
	}


	public String geteAddress() {
		return eAddress;
	}


	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
	}


	public String geteMobile() {
		return eMobile;
	}


	public void seteMobile(String eMobile) {
		this.eMobile = eMobile;
	}


	public int geteSalary() {
		return eSalary;
	}


	public void seteSalary(int eSalary) {
		this.eSalary = eSalary;
	}


	public int geteDId() {
		return eDId;
	}

	public void seteDId(int eDId) {
		this.eDId = eDId;
	}

	public String geteDName() {
		return eDName;
	}

	public void seteDName(String eDName) {
		this.eDName = eDName;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", eEmail=" + eEmail + ", ePassword=" + ePassword
				+ ", eAddress=" + eAddress + ", eMobile=" + eMobile + ", eSalary=" + eSalary + ", eDId=" + eDId
				+ ", eDName=" + eDName + "]";
	}


	
	
	
	
	
	
	
}
