package com.green.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDao<E, ID> {

	@Autowired
	private SessionFactory factory;

	private Class<E> entityClass;

	public BaseDao() {
		this.entityClass = getEntityClass();
	}

	protected abstract Class<E> getEntityClass();

	public SessionFactory getFactory() {
		return factory;
	}

	public E find(ID id) {
		Session session = factory.openSession();
		return session.find(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		Session session = factory.openSession();
		return session.createQuery("from " + entityClass.getName()).getResultList();
	}

	public void save(E entity) {
		Session session = factory.openSession();
		session.save(entity);
		session.close();
	}

	public void update(E entity) {
		Session session = factory.openSession();
		session.update(entity);
		session.close();
	}

	public void delete(E entity) {
		Session session = factory.openSession();
		session.remove(entity);
		session.close();
	}

	public void deleteById(ID id) {
		Session session = factory.openSession();
		E entity = session.find(entityClass, id);
		session.remove(entity);
	}
	
	public boolean isExist(String email) {
		Session session = factory.openSession();
			String hql = "select email from Account where email = :_email";
			Query query = session.createQuery(hql);
			query.setParameter("_email", email);
			return false;
	
	}
}
