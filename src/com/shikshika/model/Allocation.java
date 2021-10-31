package com.shikshika.model;

public class Allocation 
{
	private String student_id;
    private String cid;
 
    public Allocation() 
    {
	}
    
    public Allocation(String student_id, String cid) 
    {
        this.student_id = student_id;
        this.cid = cid;
    }
 
    public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	
 
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}
}
