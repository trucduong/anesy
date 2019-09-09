package com.green.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.entity.Account;

@Repository
public class AccountDao {
	@Autowired
	private SessionFactory factory;
	
	public Account findByEmail(String email) {
		Session session = factory.openSession();
		Account account = session.find(Account.class, email);
		session.close();
		return account;
	}
	
	public Account findById(int id) {
		Session session = factory.openSession();		
		Account account = session.find(Account.class, id);
		session.close();
		return account;
	}
	
	public List<Account> findAll() {
		Session session = factory.openSession();
		Query query = session.createQuery("from Account");
		List<Account> accounts = query.getResultList();
		session.close();
		return accounts;
	}
	
	public boolean insert(Account account) {
		try {
			Session session = factory.openSession();
			session.save(account);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean update(int id, Account account) {
		try {
			Session session = factory.openSession();
			session.update(account);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean delete(int id) {
		try {
			Session session = factory.openSession();
			Account account = session.find(Account.class, id);
			session.remove(account);
			session.close();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
}
