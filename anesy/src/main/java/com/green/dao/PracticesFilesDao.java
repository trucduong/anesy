package com.green.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.entity.PracticesFiles;

@Repository
public class PracticesFilesDao {
	@Autowired
	private SessionFactory factory;
	
	public PracticesFiles findById(int id) {
		Session session = factory.openSession();		
		PracticesFiles practicesFiles = session.find(PracticesFiles.class, id);
		session.close();
		return practicesFiles;
	}
	
	public List<PracticesFiles> findAll() {
		Session session = factory.openSession();
		Query query = session.createQuery("from PracticesFiles");
		List<PracticesFiles> practicesFiless = query.getResultList();
		session.close();
		return practicesFiless;
	}
	
	public boolean insert(PracticesFiles practicesFiles) {
		try {
			Session session = factory.openSession();
			session.save(practicesFiles);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean update(int id, PracticesFiles practicesFiles) {
		try {
			Session session = factory.openSession();
			session.update(practicesFiles);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean delete(int id) {
		try {
			Session session = factory.openSession();
			PracticesFiles practicesFiles = session.find(PracticesFiles.class, id);
			session.remove(practicesFiles);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
}
