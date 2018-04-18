package com.springmvc.dao;

import java.util.List;

import com.springmvc.pojo.TStudent;

public interface StudentDao extends GenerateDao<TStudent, String>{

	public List getAllStudentInfo();
	
	public List getAllStudentById(String stuId);
	
	public TStudent getStuInfo(String stuId);
}
