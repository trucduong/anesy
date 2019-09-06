package com.green.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.entity.CourseGroup;

@Repository
public class CourseGroupDao {
	@Autowired
	private SessionFactory factory;
	
	public CourseGroup findById(int id) {
		Session session = factory.openSession();		
		CourseGroup courseGroup = session.find(CourseGroup.class, id);
		session.close();
		return courseGroup;
	}
	
	public List<CourseGroup> findAll() {
		Session session = factory.openSession();
		Query query = session.createQuery("from CourseGroup");
		List<CourseGroup> courseGroups = query.getResultList();
		session.close();
		return courseGroups;
	}
	
	public boolean insert(CourseGroup courseGroup) {
		try {
			Session session = factory.openSession();
			session.save(courseGroup);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean update(int id, CourseGroup courseGroup) {
		try {
			Session session = factory.openSession();
			session.update(courseGroup);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean delete(int id) {
		try {
			Session session = factory.openSession();
			CourseGroup courseGroup = session.find(CourseGroup.class, id);
			session.remove(courseGroup);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
}
