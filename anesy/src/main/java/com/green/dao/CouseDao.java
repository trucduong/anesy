package com.green.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.green.entity.Course;
import com.green.model.CourseFilter;

@Repository
public class CouseDao extends BaseDao<Course, Integer> {
	
	@Override
	protected Class<Course> getEntityClass() {
		return Course.class;
	}
	
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
	
}
