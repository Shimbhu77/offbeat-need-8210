package com.hrds.bean;

public class DepartmentEmployee {
	
	private int dId;
	private String dName;
	private int eId;
	private String eName;
	private String eEmail;
	private String eAddress;
	private String eMobile;
	private int eSalary;
	
	
	
	public DepartmentEmployee() {
		super();
	}



	public DepartmentEmployee(int dId, String dName, int eId, String eName, String eEmail, String eAddress,
			String eMobile, int eSalary) {
		super();
		this.dId = dId;
		this.dName = dName;
		this.eId = eId;
		this.eName = eName;
		this.eEmail = eEmail;
		this.eAddress = eAddress;
		this.eMobile = eMobile;
		this.eSalary = eSalary;
	}



	public int getdId() {
		return dId;
	}



	public void setdId(int dId) {
		this.dId = dId;
	}



	public String getdName() {
		return dName;
	}



	public void setdName(String dName) {
		this.dName = dName;
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



	@Override
	public String toString() {
		return "DepartmentEmployee [dId=" + dId + ", dName=" + dName + ", eId=" + eId + ", eName=" + eName + ", eEmail="
				+ eEmail + ", eAddress=" + eAddress + ", eMobile=" + eMobile + ", eSalary=" + eSalary + "]";
	}
	
	
	
}
