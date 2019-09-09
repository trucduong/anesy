package com.green.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.entity.Course;

@Repository
public class CourseDao {
	@Autowired
	private SessionFactory factory;
	
	public Course findById(int id) {
		Session session = factory.openSession();		
		Course course = session.find(Course.class, id);
		session.close();
		return course;
	}
	
	public List<Course> findAll() {
		Session session = factory.openSession();
		Query query = session.createQuery("from Course");
		List<Course> courses = query.getResultList();
		session.close();
		return courses;
	}
	
	public boolean insert(Course course) {
		try {
			Session session = factory.openSession();
			session.save(course);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean update(int id, Course course) {
		try {
			Session session = factory.openSession();
			session.update(course);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean delete(int id) {
		try {
			Session session = factory.openSession();
			Course course = session.find(Course.class, id);
			session.remove(course);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
}
