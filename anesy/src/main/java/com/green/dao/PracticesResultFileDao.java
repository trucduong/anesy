package com.green.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.entity.PracticesResultFile;

@Repository
public class PracticesResultFileDao {
	@Autowired
	private SessionFactory factory;
	
	public PracticesResultFile findById(int id) {
		Session session = factory.openSession();		
		PracticesResultFile practicesResultFile = session.find(PracticesResultFile.class, id);
		session.close();
		return practicesResultFile;
	}
	
	public List<PracticesResultFile> findAll() {
		Session session = factory.openSession();
		Query query = session.createQuery("from PracticesResultFile");
		List<PracticesResultFile> practicesResultFiles = query.getResultList();
		session.close();
		return practicesResultFiles;
	}
	
	public boolean insert(PracticesResultFile practicesResultFile) {
		try {
			Session session = factory.openSession();
			session.save(practicesResultFile);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean update(int id, PracticesResultFile practicesResultFile) {
		try {
			Session session = factory.openSession();
			session.update(practicesResultFile);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean delete(int id) {
		try {
			Session session = factory.openSession();
			PracticesResultFile practicesResultFile = session.find(PracticesResultFile.class, id);
			session.remove(practicesResultFile);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
}
