package com.green.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.entity.CourseComment;

@Repository
public class CourseCommentDao {
	@Autowired
	private SessionFactory factory;
	
	public CourseComment findById(int id) {
		Session session = factory.openSession();		
		CourseComment courseComment = session.find(CourseComment.class, id);
		session.close();
		return courseComment;
	}
	
	public List<CourseComment> findAll() {
		Session session = factory.openSession();
		Query query = session.createQuery("from CourseComment");
		List<CourseComment> courseComments = query.getResultList();
		session.close();
		return courseComments;
	}
	
	public boolean insert(CourseComment courseComment) {
		try {
			Session session = factory.openSession();
			session.save(courseComment);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean update(int id, CourseComment courseComment) {
		try {
			Session session = factory.openSession();
			session.update(courseComment);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean delete(int id) {
		try {
			Session session = factory.openSession();
			CourseComment courseComment = session.find(CourseComment.class, id);
			session.remove(courseComment);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
}
