package com.green.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.dao.ProfileDao;
import com.green.entity.Profile;

@Service
public class ProfileService {

	@Autowired
	private ProfileDao profileDao;
	
	public void update (Profile profile) {
		profileDao.update(profile);
	}
	
	public Profile findbyID(int id) {
		Profile profile = profileDao.find(id);
		return profile;
	}
}
