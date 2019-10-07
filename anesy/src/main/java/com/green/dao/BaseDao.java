package com.green.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.green.entity.Account;

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

	public ID save(E entity) {
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		ID id = (ID) session.save(entity);
		tran.commit();
		session.close();
		return id;
	}

	public void update(E entity) {
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		session.update(entity);
		tran.commit();
		session.close();
	}

	public void delete(E entity) {
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		session.remove(entity);
		tran.commit();
		session.close();
	}

	public void deleteById(ID id) {
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		E entity = session.find(entityClass, id);
		session.remove(entity);
		tran.commit();
		session.remove(entity);
	}

	public boolean isExist(String email) {
		Session session = factory.openSession();
		String hql = "select email from Account where email = :_email";
		Query query = session.createQuery(hql);
		query.setParameter("_email", email);
		return false;

	}

	public Account findByEmail(String email) {
		Session session = factory.openSession();

		Query query = session.createQuery(" from Account where Email = :_email");
		query.setParameter("_email", email);
		List<Account> list = query.getResultList();
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
