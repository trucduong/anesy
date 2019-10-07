package com.green.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.green.entity.Lesson;
import com.green.entity.Subjects;
import com.green.util.ApplicationConfig;

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
		hql.append("select * from lesson le where 1=1");
		if (filter != null) {
			hql.append(" and LOWER(le.name) like N'%").append(filter.toLowerCase()).append("%'");
		}
		
		Query query = getFactory().openSession().createNativeQuery(hql.toString(), Lesson.class);
		query.setFirstResult((page-1) * pageSize);
		query.setMaxResults(pageSize);
		
		return query.getResultList();
	}
	
	public long count(String filter) {
		StringBuilder hql = new StringBuilder();
		hql.append("select count(*) from lesson le where 1=1");
		if (filter != null) {
			hql.append(" and LOWER(le.name) like N'%").append(filter.toLowerCase()).append("%'");
		}
		
		Query query = getFactory().openSession().createNativeQuery(hql.toString());
		Number val = (Number) query.getSingleResult();
		return val.longValue();
	}
	
	public List<Lesson> findLessonbySubject(Subjects subjects){
		StringBuilder hql = new StringBuilder();
		hql.append("from Lesson where subjects = :_subjects");
		
		Query query = getFactory().openSession().createQuery(hql.toString(), Lesson.class);
		query.setParameter("_subjects", subjects);
		
		return query.getResultList();
	}
}
