package com.green.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.entity.Course;
import com.green.entity.Profile;
import com.green.model.CourseFilter;

@Repository
public class CouseDao extends BaseDao<Course, Integer> {
	
	@Override
	protected Class<Course> getEntityClass() {
		return Course.class;
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Course> search(CourseFilter filter) {
		StringBuilder hql = new StringBuilder();
		hql.append("select co from Course co where 1=1");
		
		if (filter.getSearchText() != null) {
			hql.append(" and co.name like '%" + filter.getSearchText() + "%'");
		}
		
		if (filter.getCategory() != null) {
			hql.append(" and co.category.id = " + String.valueOf(filter.getCategory()));
		}
		
		if (filter.getTag() != null) {
			hql.append(" and co.name like '%," + filter.getTag() + ",%'");
		}
		
		Query query = getFactory().openSession().createQuery(hql.toString(), Course.class);
		return query.getResultList();
	}
	
	public List<Course> findByAuthor(Profile profile) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Course where author = :_author");
		query.setParameter("_author", profile);
		return query.getResultList();
		
	}
	
}
