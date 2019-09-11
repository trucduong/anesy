package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.green.dao.ProfileDao;
import com.green.entity.Profile;


public class ProfileService {
	@Service
	public class CourseService {
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
}
