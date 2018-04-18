package com.springmvc.service;

import java.util.List;

import com.springmvc.bean.StudentBean;
import com.springmvc.pojo.TStudent;

public interface StudentService {
	TStudent load(String id);

	TStudent get(String id);

	List<TStudent> findAll();

	void persist(TStudent entity);

	void save(TStudent entity);

	void saveOrUpdate(TStudent entity);

	void delete(String id);

	void flush();
	
	List<StudentBean> getAllStudentInfo();
	
	
}
