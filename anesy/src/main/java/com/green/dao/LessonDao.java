package com.green.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Tuple;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.green.entity.Course;
import com.green.entity.Lesson;
import com.green.entity.Subjects;

@Repository
public class LessonDao extends BaseDao<Lesson, Integer> {
	
	private int pageSize;
	
	@PostConstruct
	private void init() {
		pageSize = Integer.parseInt(ApplicationConfig.getConfig("paging.size"));
	}
	
	@Override
	protected Class<Lesson> getEntityClass() {
		return Lesson.class;
	}
	
	/*public List<Lesson> findAllWithSubjects() {
		List<Lesson> lessons = new ArrayList<>();
		
		Session session = getFactory().openSession();
		String hql = "select L, S from Lesson L inner join Subjects S on L.subjectsId = S.id";
		Query q = session.createQuery(hql, Tuple.class);
		List<Tuple> resultList = q.getResultList();
		for (Tuple item : resultList) {
			Lesson lesson = new Lesson();
			lesson.setId(item.get("Lid", Integer.class));
			
			lessons.add(lesson);
		}
		
		return session.createQuery(hql).getResultList();
	}*/
	
	public List<Lesson> findAll(int subId) {
		StringBuilder hql = new StringBuilder();
		hql.append("select co from Lession co where co.subjects.id = :subId");
		
		Query query = getFactory().openSession().createQuery(hql.toString(), Subjects.class);
		query.setParameter("subId", subId);
		
		return query.getResultList();
	}
	
	public List<Lesson> search(String filter, int page) {
		StringBuilder hql = new StringBuilder();
		hql.append("from Lesson le where 1=1");
		if (filter != null) {
			hql.append(" and le.name like '%").append(filter).append("%'");
		}
		
		Query query = getFactory().openSession().createQuery(hql.toString(), Lesson.class);
		query.setFirstResult((page-1) * pageSize);
		query.setMaxResults(pageSize);
		
		return query.getResultList();
	}
	
	public long count(String filter) {
		StringBuilder hql = new StringBuilder();
		hql.append("select count(le) from Lesson le where 1=1");
		if (filter != null) {
			hql.append(" and le.name like '%").append(filter).append("%'");
		}
		
		Query query = getFactory().openSession().createQuery(hql.toString());
		Number val = (Number) query.getSingleResult();
		return val.longValue();
	}
}
