package com.green.dao;

import org.springframework.stereotype.Repository;

import com.green.entity.Profile;

@Repository
public class ProfileDao extends BaseDao<Profile, Integer> {
	
	@Override
	protected Class<Profile> getEntityClass() {
		return Profile.class;
	}
}
