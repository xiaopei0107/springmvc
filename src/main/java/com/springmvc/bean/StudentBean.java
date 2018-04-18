package com.springmvc.bean;

public class StudentBean {

	private int stuId;
	private String stuName;
	private String stuAge;
	private String className;
	private String teacherName;
	
	public int getStuId() {
		return stuId;
	}
	@Override
	public String toString() {
		
		return "学生编号："+this.stuId+"\t学生姓名："+this.stuName+"\t学生年龄："+this.stuAge+"\t班级："+this.className+"\t老师："+this.teacherName;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuAge() {
		return stuAge;
	}
	public void setStuAge(String stuAge) {
		this.stuAge = stuAge;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
}
