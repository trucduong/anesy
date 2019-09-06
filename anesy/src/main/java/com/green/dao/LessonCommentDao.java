package com.green.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.entity.LessonComment;

@Repository
public class LessonCommentDao {
	@Autowired
	private SessionFactory factory;
	
	public LessonComment findById(int id) {
		Session session = factory.openSession();		
		LessonComment lessonComment = session.find(LessonComment.class, id);
		session.close();
		return lessonComment;
	}
	
	public List<LessonComment> findAll() {
		Session session = factory.openSession();
		Query query = session.createQuery("from LessonComment");
		List<LessonComment> lessonComments = query.getResultList();
		session.close();
		return lessonComments;
	}
	
	public boolean insert(LessonComment lessonComment) {
		try {
			Session session = factory.openSession();
			session.save(lessonComment);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean update(int id, LessonComment lessonComment) {
		try {
			Session session = factory.openSession();
			session.update(lessonComment);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean delete(int id) {
		try {
			Session session = factory.openSession();
			LessonComment lessonComment = session.find(LessonComment.class, id);
			session.remove(lessonComment);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
}
