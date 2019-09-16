package com.green.service;

import java.util.List;
import java.util.UUID;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.dao.AccountDao;
import com.green.dao.ProfileDao;
import com.green.entity.Account;
import com.green.entity.Profile;
import com.green.exception.MyException;
import com.green.util.EmailUtils;

//@Component
@Service
public class AccountService {

	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private ProfileDao profileDao;

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

	public void regis(String email, String fullName, int userType) throws Exception {
		// ktra email
		Account account = accountDao.findByEmail(email);
		if (account != null) {
			throw new MyException("Email da ton tai!");
		}
		// khoi tao mat khau
		String password = UUID.randomUUID().toString().substring(0, 8);
		// insert account
		account = new Account();
		account.setEmail(email);
		account.setPassword(password);
		account.setActive(true);
		insert(account);
		
		account = accountDao.findByEmail(email);
		Profile profile = new Profile();
		profile.setAccountId(account.getId());
		profile.setEmail(email);
		profile.setFullName(fullName);
		profile.setUserType(userType);
		profileDao.save(profile);
		
		if (!EmailUtils.send(email, "Active Your Account", "Your password is: " + password))
			throw new MyException("Gui mail that bai!");
	}

	public void resetPassword(String email) throws Exception {
		// ktra email
		Account account = accountDao.findByEmail(email);
		if (account == null) {
			throw new MyException("Email khong ton tai!");
		}
		// khoi tao mat khau
		String password = UUID.randomUUID().toString().substring(0, 8);
		account.setPassword(password);
		// cap nhat tai khoan moi
		update(account);
		// gui email
		if (!EmailUtils.send(email, "Reset your password", "Your new password is: " + password))
			throw new MyException("Gui mail that bai!");
	}

	public Account findById(int id) {
		return accountDao.find(id);
	}

	public void insert(Account account) {
		accountDao.save(account);
	}

	public void update(Account account) {
		accountDao.update(account);
	}

	public void delete(int id) {
		accountDao.deleteById(id);
	}
}
