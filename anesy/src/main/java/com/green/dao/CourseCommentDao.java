package com.green.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.entity.CourseComment;

@Repository
public class CourseCommentDao extends BaseDao<CourseComment, Integer> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	protected Class<CourseComment> getEntityClass() {
		return CourseComment.class;
	}
	
	public List<CourseComment> findbyCourseID(int id){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from CourseComment where courseId = :_courseid");
		query.setParameter("_courseid", id);
		return query.getResultList();
		
		
	}
}
