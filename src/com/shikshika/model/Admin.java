package com.shikshika.model;

public class Admin {
	private String admin_id;
	private String ad_password;

	public Admin() {
	}

	public Admin(String admin_id, String ad_password) 
	{
		this.admin_id=admin_id;
		this.ad_password = ad_password;
	}


	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	
	

	public String getAdminPassword() {
		return ad_password;
	}

	public void setAdminPassword(String ad_password) {
		this.ad_password = ad_password;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id +", ad_password=" + ad_password + "]";
	}
	
}
