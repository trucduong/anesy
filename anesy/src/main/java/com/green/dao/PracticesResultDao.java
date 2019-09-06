package com.green.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.entity.PracticesResult;

@Repository
public class PracticesResultDao {
	@Autowired
	private SessionFactory factory;
	
	public PracticesResult findById(int id) {
		Session session = factory.openSession();		
		PracticesResult practicesResult = session.find(PracticesResult.class, id);
		session.close();
		return practicesResult;
	}
	
	public List<PracticesResult> findAll() {
		Session session = factory.openSession();
		Query query = session.createQuery("from PracticesResult");
		List<PracticesResult> practicesResults = query.getResultList();
		session.close();
		return practicesResults;
	}
	
	public boolean insert(PracticesResult practicesResult) {
		try {
			Session session = factory.openSession();
			session.save(practicesResult);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean update(int id, PracticesResult practicesResult) {
		try {
			Session session = factory.openSession();
			session.update(practicesResult);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean delete(int id) {
		try {
			Session session = factory.openSession();
			PracticesResult practicesResult = session.find(PracticesResult.class, id);
			session.remove(practicesResult);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
}
