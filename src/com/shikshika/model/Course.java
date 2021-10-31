package com.shikshika.model;




public class Course {
	private String cid;
	private String name;
	private String cat_id;
	private String image;
	private String abt_course;
	private String syllabus;
	private String textbook;
	private String ref;
	
	public Course() 
	{
	}

	
	public Course(String name, String cat_id, String image) 
	{
		this.name = name;
		this.cat_id = cat_id;
		this.image = image;
	}

	
	public Course(String cid,String name,String cat_id,String image) 
	{
		
		this.cid=cid;
		this.name = name;
		this.cat_id = cat_id;
		this.image = image;
		
	}
	public Course(String cid,String name, String cat_id,String image,String abt_course,String syllabus,String textbook, String ref) 
	{
		
		this.cid=cid;
		this.name = name;
		this.cat_id = cat_id;
		this.image = image;
		this.abt_course = abt_course;
		this.syllabus = syllabus;
		this.textbook = textbook;
		this.ref = ref;
	}
	
	
	
	
	
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getCategory() {
		return cat_id;
	}

	public void setCategory(String cat_id) {
		this.cat_id = cat_id;
	}

	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getAbt_course() {
		return abt_course;
	}

	public void setAbt_course(String abt_course) {
		this.abt_course = abt_course;
	}
	
	public String getSyllabus() 
	{	
	return syllabus;		
	}

	public void setSyllabus(String syllabus) 
	{
	this.syllabus = syllabus;
	}

	public String getTextbook() 
	{
	return textbook;
	}


	public void setTextbook(String textbook)
	{
	this.textbook = textbook;
	}


	public String getRef() 
	{
	return ref;
	}



	public void setRef(String ref) 
	{
	this.ref = ref;
	}
	


	@Override
	public String toString() {
		return "Course [cid=" + cid + ", name=" + name + ", cat_id=" + cat_id + ", image="+ image + ", abt_course=" + abt_course + ", syllabus="+ syllabus + ", textbook=" + textbook + ", ref=" + ref + "]";
	}
	
	
}
