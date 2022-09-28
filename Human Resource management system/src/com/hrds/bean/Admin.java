package com.hrds.bean;

public class Admin {

	private int aId;
	private String aName;
	private String aEmail;
	private String aPassword;
	
	public Admin() {
		super();
	}

	

	public Admin(int aId, String aName, String aEmail, String aPassword) {
		super();
		this.aId = aId;
		this.aName = aName;
		this.aEmail = aEmail;
		this.aPassword = aPassword;
	}



	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	
	
	public String getaName() {
		return aName;
	}



	public void setaName(String aName) {
		this.aName = aName;
	}



	public String getaEmail() {
		return aEmail;
	}

	public void setaEmail(String aEmail) {
		this.aEmail = aEmail;
	}

	public String getaPassword() {
		return aPassword;
	}

	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}



	@Override
	public String toString() {
		return "Admin [aId=" + aId + ", aName=" + aName + ", aEmail=" + aEmail + ", aPassword=" + aPassword + "]";
	}

	
	
	
	
}
