package com.green.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.green.entity.Exercise;
import com.green.entity.Lesson;
import com.green.entity.Subjects;

@Repository
public class ExerciseDao extends BaseDao<Exercise, Integer> {
	
	@Override
	protected Class<Exercise> getEntityClass() {
		return Exercise.class;
	}

	public List<Exercise> findAll(int subId) {
		StringBuilder hql = new StringBuilder();
		hql.append("select co from Exercise co where co.subjects.id = :subId");
		
		Query query = getFactory().openSession().createQuery(hql.toString(), Subjects.class);
		query.setParameter("subId", subId);
		
		return query.getResultList();
	}
}
