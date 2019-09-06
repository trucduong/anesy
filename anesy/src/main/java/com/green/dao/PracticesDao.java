package com.green.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.entity.Practices;

@Repository
public class PracticesDao {
	@Autowired
	private SessionFactory factory;
	
	public Practices findById(int id) {
		Session session = factory.openSession();		
		Practices practices = session.find(Practices.class, id);
		session.close();
		return practices;
	}
	
	public List<Practices> findAll() {
		Session session = factory.openSession();
		Query query = session.createQuery("from Practices");
		List<Practices> practicess = query.getResultList();
		session.close();
		return practicess;
	}
	
	public boolean insert(Practices practices) {
		try {
			Session session = factory.openSession();
			session.save(practices);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean update(int id, Practices practices) {
		try {
			Session session = factory.openSession();
			session.update(practices);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean delete(int id) {
		try {
			Session session = factory.openSession();
			Practices practices = session.find(Practices.class, id);
			session.remove(practices);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
}
