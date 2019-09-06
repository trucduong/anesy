package com.green.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.entity.Lesson;

@Repository
public class LessonDao {
	@Autowired
	private SessionFactory factory;
	
	public Lesson findById(int id) {
		Session session = factory.openSession();		
		Lesson lesson = session.find(Lesson.class, id);
		session.close();
		return lesson;
	}
	
	public List<Lesson> findAll() {
		Session session = factory.openSession();
		Query query = session.createQuery("from Lesson");
		List<Lesson> lessons = query.getResultList();
		session.close();
		return lessons;
	}
	
	public boolean insert(Lesson lesson) {
		try {
			Session session = factory.openSession();
			session.save(lesson);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean update(int id, Lesson lesson) {
		try {
			Session session = factory.openSession();
			session.update(lesson);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean delete(int id) {
		try {
			Session session = factory.openSession();
			Lesson lesson = session.find(Lesson.class, id);
			session.remove(lesson);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
}
