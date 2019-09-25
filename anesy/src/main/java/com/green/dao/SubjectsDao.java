package com.green.dao;

import org.springframework.stereotype.Repository;

import com.green.entity.Subjects;

@Repository
public class SubjectsDao extends BaseDao<Subjects, Integer> {

	@PostConstruct
	private void init() {
		pageSize = Integer.parseInt(ApplicationConfig.getConfig("paging.size"));
	}
	
	@Override
	protected Class<Subjects> getEntityClass() {
		return Subjects.class;
	}
	
	public List<Subjects> search(String filter, int page) {
		StringBuilder hql = new StringBuilder();
		hql.append("from subjects ca where 1=1");
		if (filter != null) {
			hql.append(" and ca.name like '%").append(filter).append("%'");
		}
		
		Query query = getFactory().openSession().createQuery(hql.toString(), Subjects.class);
		query.setFirstResult((page-1) * pageSize);
		query.setMaxResults(pageSize);
		
		return query.getResultList();
	}

	public long count(String filter) {
		StringBuilder hql = new StringBuilder();
		hql.append("select count(ca) from subjects ca where 1=1");
		if (filter != null) {
			hql.append(" and ca.name like '%").append(filter).append("%'");
		}
		
		Query query = getFactory().openSession().createQuery(hql.toString());
		Number val = (Number) query.getSingleResult();
		return val.longValue();
	}
}