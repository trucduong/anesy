package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.dao.AccountDao;
import com.green.entity.Account;
import com.green.exception.MyException;

//@Component
@Service
public class AccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	public List<Account> findAll() {
//		List<Account> list = accountDao.findAll();
//		return list;
		
		return accountDao.findAll();
	}
	
	public Account login(int id, String password) throws Exception {
		Account account = accountDao.find(id);
		
		if (account == null) {
			throw new MyException("Username khong ton tai.");
		}
		
//		if (!password.equals(account.getPassword())) {
//			System.out.println("pass=" + password + "END");
//			System.out.println("DPpa=" + account.getPassword() + "END");
//			throw new MyException("Password khong dung.");
//		}
		
		return account;
	}
	
	public Account findByEmail(String email) {
		return accountDao.findByEmail(email);
		
	}
	
	public Account findById(int id) {
		return accountDao.find(id);
	}
	
	public void insert(Account account) {
		accountDao.save(account);
	}

	public void update(int id, Account account) {
		accountDao.update(account);
	}
	
	public void delete(int id) {
		accountDao.deleteById(id);
	}
}
