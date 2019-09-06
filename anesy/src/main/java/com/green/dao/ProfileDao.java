package com.green.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.entity.Profile;

@Repository
public class ProfileDao {
	@Autowired
	private SessionFactory factory;
	
	public Profile findById(int id) {
		Session session = factory.openSession();		
		Profile profile = session.find(Profile.class, id);
		session.close();
		return profile;
	}
	
	public List<Profile> findAll() {
		Session session = factory.openSession();
		Query query = session.createQuery("from Profile");
		List<Profile> profiles = query.getResultList();
		session.close();
		return profiles;
	}
	
	public boolean insert(Profile profile) {
		try {
			Session session = factory.openSession();
			session.save(profile);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean update(int id, Profile profile) {
		try {
			Session session = factory.openSession();
			session.update(profile);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean delete(int id) {
		try {
			Session session = factory.openSession();
			Profile profile = session.find(Profile.class, id);
			session.remove(profile);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
}
