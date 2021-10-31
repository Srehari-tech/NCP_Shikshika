package com.shikshika.model;

public class Student {
	private String student_id;
	private String name;
	private String email;
	private String password;

	public Student() {
	}

	public Student(String student_id, String name, String email, String password) 
	{
		this.student_id=student_id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public Student(String student_id,String email, String password) 
	{
		this.student_id=student_id;
		this.email = email;
		this.password = password;
	}
	
	

	
	public Student(String student_id, String name) 
	{
		this.student_id=student_id;
		this.name = name;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id +", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
}
