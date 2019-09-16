package com.green.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.dao.AccountDao;
import com.green.dao.ProfileDao;
import com.green.entity.Account;
import com.green.entity.Profile;
import com.green.exception.MyException;
import com.green.util.EmailUtils;

@Service
public class ProfileService {
	
		@Autowired
		private ProfileDao profileDao;

		public List<Profile> findAll() {
			return profileDao.findAll();
		}

		public Profile findById(int id) {
			return profileDao.find(id);
		}

		public void insert(Profile profile) {
			profileDao.save(profile);
		}

		public void delete(Profile profile) {
			profileDao.delete(profile);
		}

		public void update(Profile profile) {
			profileDao.update(profile);
		}
		
}
