package com.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.bean.StudentBean;
import com.springmvc.dao.StudentDao;
import com.springmvc.pojo.TStudent;
import com.springmvc.service.StudentService;

@Transactional
@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public TStudent load(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public TStudent get(String id) {
		// TODO Auto-generated method stub
		return this.studentDao.get(id);
	}

	public List<TStudent> findAll() {
		// TODO Auto-generated method stub
		return this.studentDao.findAll();
	}

	public void persist(TStudent entity) {
		// TODO Auto-generated method stub

	}

	@Transactional
	public void save(TStudent entity) {
		// TODO Auto-generated method stub
		this.studentDao.save(entity);
	}

	public void saveOrUpdate(TStudent entity) {
		// TODO Auto-generated method stub

	}

	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	public void flush() {
		// TODO Auto-generated method stub

	}

	public List<StudentBean> getAllStudentInfo() {
		List<StudentBean> stuList = new ArrayList<StudentBean>();
		List list = this.studentDao.getAllStudentInfo();
		for(int i=0;i<list.size();i++){
			Object[] obj = (Object[]) list.get(i);			
			StudentBean stu = new StudentBean();
			stu.setStuId(Integer.parseInt(String.valueOf(obj[0])));
			stu.setStuName(String.valueOf(obj[1]));
			stu.setStuAge(String.valueOf(obj[2]));
			stu.setClassName(String.valueOf(obj[3]));
			stu.setTeacherName(String.valueOf(obj[4]));
			stuList.add(stu);
		}
		return stuList;
	}

}
