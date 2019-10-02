package com.green.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.green.entity.CourseCategory;
import com.green.util.ApplicationConfig;

@Repository
public class CourseCategoryDao extends BaseDao<CourseCategory, Integer> {
	
	private int pageSize;
	
	@PostConstruct
	private void init() {
		pageSize = Integer.parseInt(ApplicationConfig.getConfig("paging.size"));
	}
	
	@Override
	protected Class<CourseCategory> getEntityClass() {
		return CourseCategory.class;
	}
	
	public List<CourseCategory> search(String filter, int page) {
		StringBuilder hql = new StringBuilder();
		hql.append("select * from course_category ca where 1=1");
		if (filter != null) {
			hql.append(" and LOWER(ca.name) like N'%").append(filter.toLowerCase()).append("%'");
		}
		
		Query query = getFactory().openSession().createNativeQuery(hql.toString(), CourseCategory.class);
		query.setFirstResult((page-1) * pageSize);
		query.setMaxResults(pageSize);
		
		return query.getResultList();
	}

	public long count(String filter) {
		StringBuilder hql = new StringBuilder();
		hql.append("select count(*) from course_category ca where 1=1");
		if (filter != null) {
			hql.append(" and LOWER(ca.name) like N'%").append(filter.toLowerCase()).append("%'");
		}
		
		Query query = getFactory().openSession().createNativeQuery(hql.toString());
		Number val = (Number) query.getSingleResult();
		return val.longValue();
	}
	
}
