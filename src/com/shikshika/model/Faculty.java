package com.shikshika.model;

public class Faculty {
	private String faculty_id;
	private String facultyname;
	public String cid;
	private String password;

	public Faculty() 
	{
	}

	public Faculty(String faculty_id,String facultyname, String cid, String password) 
	{
		this.faculty_id = faculty_id;
	    this.facultyname=facultyname;
	    this.cid=cid;
		this.password = password;
	}
	

	public String getId() {
		return faculty_id;
	}

	public void setId(String faculty_id) {
		this.faculty_id = faculty_id;
	}

	
	
	public String getName() {
		return facultyname;
	}

	public void setName(String facultyname) {
		this.facultyname = facultyname;
	}

	public String getCourseId() {
		return cid;
	}

	public void setCourseId(String cid) {
		this.cid = cid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [faculty_id=" + faculty_id + ", facultyname=" + facultyname + ", cid=" + cid + ", password=" + password + "]";
	}
	
}
