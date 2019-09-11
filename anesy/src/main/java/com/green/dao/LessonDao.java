package com.green.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Tuple;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.green.entity.Lesson;

@Repository
public class LessonDao extends BaseDao<Lesson, Integer> {
	
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
}
