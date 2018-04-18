package com.springmvc.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.dao.StudentDao;
import com.springmvc.pojo.TStudent;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public TStudent load(String id) {
		// TODO Auto-generated method stub
		return (TStudent) this.getCurrentSession().load(TStudent.class, id);
	}

	public TStudent get(String id) {
		// TODO Auto-generated method stub
		return (TStudent)this.getCurrentSession().get(TStudent.class, id);
	}

	public List<TStudent> findAll() {
		// TODO Auto-generated method stub
		return this.getCurrentSession().createQuery("from TStudent").list();
	}

	public void persist(TStudent entity) {
		// TODO Auto-generated method stub
		
	}

	
	public void save(TStudent entity) {
		// TODO Auto-generated method stub
		this.getCurrentSession().save(entity);
	}

	public void saveOrUpdate(TStudent entity) {
		// TODO Auto-generated method stub
		this.getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	public void flush() {
		// TODO Auto-generated method stub
		
	}

	public List getAllStudentInfo() {
		StringBuilder sql = new StringBuilder();
		sql.append("select s.stu_id,s.stu_name,s.stu_age,c.class_name,t.teacher_name from t_student s ,t_class c ,t_teacher t ");
		sql.append(" where s.class_id = c.class_id and c.teacher_id = t.teacher_id ");
		sql.append(" order by c.class_id,s.stu_id ");
		
		Query query = this.getCurrentSession().createSQLQuery(sql.toString());
		List list= query.list();
		return list;
	}

	public List getAllStudentById(String stuId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TStudent getStuInfo(String stuId) {
		Query query = this.getCurrentSession().createSQLQuery("from TStudent where stuId=?");
		query.setParameter(0, stuId);
		return (TStudent) query.uniqueResult();
	}

}
