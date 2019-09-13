package com.green.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.green.entity.Account;

@Repository
public class AccountDao extends BaseDao<Account, Integer> {

	@Override
	protected Class<Account> getEntityClass() {
		return Account.class;
	}

	
	
}
