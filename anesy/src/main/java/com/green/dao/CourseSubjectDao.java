package com.green.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.green.entity.Course;
import com.green.entity.CourseCategory;
import com.green.entity.CourseSubjects;
import com.green.util.ApplicationConfig;

@Repository
public class CourseSubjectDao extends BaseDao<CourseSubjects, Integer> {
	
	private int pageSize;
	
	@PostConstruct
	private void init() {
		pageSize = Integer.parseInt(ApplicationConfig.getConfig("paging.size"));
	}
	
	@Override
	protected Class<CourseSubjects> getEntityClass() {
		return CourseSubjects.class;
	}
	
	public List<CourseSubjects> findSubjects(Course course) {
		StringBuilder hql = new StringBuilder();
		hql.append("from CourseSubjects where course = :_course");
		Query query = getFactory().openSession().createQuery(hql.toString(), CourseSubjects.class);
		query.setParameter("_course", course);
		
		return query.getResultList();

	}

	public long count(String filter) {
		StringBuilder hql = new StringBuilder();
		hql.append("select count(ca) from CourseCategory ca where 1=1");
		if (filter != null) {
			hql.append(" and ca.name like '%").append(filter).append("%'");
		}
		
		Query query = getFactory().openSession().createQuery(hql.toString());
		Number val = (Number) query.getSingleResult();
		return val.longValue();
	}
	
}
