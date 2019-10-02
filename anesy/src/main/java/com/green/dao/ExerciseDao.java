package com.green.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.green.entity.Exercise;

import com.green.entity.Subjects;
import com.green.util.ApplicationConfig;

@Repository
public class ExerciseDao extends BaseDao<Exercise, Integer> {
	
	private int pageSize;

	@PostConstruct
	private void init() {
		pageSize = Integer.parseInt(ApplicationConfig.getConfig("paging.size"));
	}
	
	@Override
	protected Class<Exercise> getEntityClass() {
		return Exercise.class;
	}

	public List<Exercise> findAll(int subId) {
		StringBuilder hql = new StringBuilder();
		hql.append("select co from Exercise co where co.exercise.id = :subId");
		
		Query query = getFactory().openSession().createQuery(hql.toString(), Exercise.class);
		query.setParameter("subId", subId);
		
		return query.getResultList();
	}
	
	public List<Exercise> search(String filter, int page) {
		StringBuilder hql = new StringBuilder();
		hql.append("from Exercise ca where 1=1");
		if (filter != null) {
			hql.append(" and ca.name like '%").append(filter).append("%'");
		}
		
		Query query = getFactory().openSession().createQuery(hql.toString(), Exercise.class);
		query.setFirstResult((page-1) * pageSize);
		query.setMaxResults(pageSize);
		
		return query.getResultList();
	}

	public long count(String filter) {
		StringBuilder hql = new StringBuilder();
		hql.append("select count(ca) from Exercise ca where 1=1");
		if (filter != null) {
			hql.append(" and ca.name like '%").append(filter).append("%'");
		}
		
		Query query = getFactory().openSession().createQuery(hql.toString());
		Number val = (Number) query.getSingleResult();
		return val.longValue();
	}
}
