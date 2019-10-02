package com.green.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.entity.Course;
import com.green.entity.Profile;
import com.green.model.CourseFilter;
import com.green.util.ApplicationConfig;

@Repository
public class CouseDao extends BaseDao<Course, Integer> {
	
private int pageSize;
	
	@PostConstruct
	private void init() {
		pageSize = Integer.parseInt(ApplicationConfig.getConfig("paging.size"));
	}
	
	@Override
	protected Class<Course> getEntityClass() {
		return Course.class;
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Course> findAll(int catId) {
		StringBuilder hql = new StringBuilder();
		hql.append("select co from Course co where co.category.id = :catId");
		
		Query query = getFactory().openSession().createQuery(hql.toString(), Course.class);
		query.setParameter("catId", catId);
		
		return query.getResultList();
	}
	
	public List<Course> search(CourseFilter filter) {
		StringBuilder hql = new StringBuilder();
		hql.append("select co from Course co where 1=1");
		
		if (filter.getSearchText() != null) {
			hql.append(" and LOWER(co.name) like N'%" + filter.getSearchText().toLowerCase() + "%'");
		}
		
		if (filter.getCategory() != null) {
			hql.append(" and co.category.id = " + String.valueOf(filter.getCategory()));
		}
		
//		if (filter.getTag() != null) {
//			hql.append(" and co.name like '%," + filter.getTag() + ",%'");
//		}
		
		Query query = getFactory().openSession().createQuery(hql.toString(), Course.class);
		return query.getResultList();
	}
	
	public List<Course> findByAuthor(Profile profile) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Course where author = :_author");
		query.setParameter("_author", profile);
		return query.getResultList();
		
	}
	
	public List<Course> search(String filter, int page) {
		StringBuilder hql = new StringBuilder();
		hql.append("from Course ca where 1=1");
		if (filter != null) {
			hql.append(" and LOWER(ca.name) like N'%").append(filter.toLowerCase()).append("%'");
		}
		
		Query query = getFactory().openSession().createQuery(hql.toString(), Course.class);
		query.setFirstResult((page-1) * pageSize);
		query.setMaxResults(pageSize);
		
		return query.getResultList();
	}
	
	public long count(String filter) {
		StringBuilder hql = new StringBuilder();
		hql.append("select count(ca) from Course ca where 1=1");
		if (filter != null) {
			hql.append(" and LOWER(ca.name) like N'%").append(filter.toLowerCase()).append("%'");
		}
		
		Query query = getFactory().openSession().createQuery(hql.toString());
		Number val = (Number) query.getSingleResult();
		return val.longValue();
	}
	
}
