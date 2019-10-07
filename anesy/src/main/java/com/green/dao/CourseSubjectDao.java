package com.green.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.green.entity.Course;
import com.green.entity.CourseCategory;
import com.green.entity.CourseSubjects;
import com.green.entity.Subjects;
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
	
	public List<CourseSubjects> findByCourse(int courseId) {
		
		Course course = new Course();
		course.setId(courseId);
		
		StringBuilder hql = new StringBuilder();
		hql.append("from CourseSubjects where course = :_course");
		Query query = getFactory().openSession().createQuery(hql.toString(), CourseSubjects.class);
		query.setParameter("_course", course);
		
		return query.getResultList();

	}
	
	public List<CourseSubjects> findBySubjects(int subjectsId) {
		
		Subjects subjects = new Subjects();
		subjects.setId(subjectsId);
		
		StringBuilder hql = new StringBuilder();
		hql.append("from CourseSubjects where subjects = :subjects");
		Query query = getFactory().openSession().createQuery(hql.toString(), CourseSubjects.class);
		query.setParameter("subjects", subjects);
		
		return query.getResultList();

	}
	
	public CourseSubjects find(int courseId, int subjectsId) {
		Subjects subjects = new Subjects();
		subjects.setId(subjectsId);
		
		Course course = new Course();
		course.setId(courseId);
		
		StringBuilder hql = new StringBuilder();
		hql.append("from CourseSubjects where subjects = :subjects and course = :course");
		Query query = getFactory().openSession().createQuery(hql.toString(), CourseSubjects.class);
		query.setParameter("subjects", subjects);
		query.setParameter("course", course);
		
		List<CourseSubjects> list = query.getResultList();
		
		if (list.isEmpty()) {
			return null;
		}
		
		return list.get(0);
	}
	
	public CourseSubjects findBysubjectId(Subjects subjectsId) {
		
		
		StringBuilder hql = new StringBuilder();
		hql.append("from CourseSubjects where subjects = :subjects");
		Query query = getFactory().openSession().createQuery(hql.toString(), CourseSubjects.class);
		query.setParameter("subjects", subjectsId);
		
		List<CourseSubjects> list = query.getResultList();
		
		if (list.isEmpty()) {
			return null;
		}
		
		return list.get(0);
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
