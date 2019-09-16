package com.green.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.green.entity.Account;

@Repository
public class AccountDao extends BaseDao<Account, Integer> {
	
	@Override
	protected Class<Account> getEntityClass() {
		return Account.class;
	}
	
	
	public Account findByEmail(String e) {
		
		Session session = getFactory().openSession();
		Query query = session.createQuery("from Account where email= :email");
		query.setParameter("email", e);
		List<Account> result = query.getResultList();
		if(result.isEmpty())
			return null;
		else
			return result.get(0);
	}

}

