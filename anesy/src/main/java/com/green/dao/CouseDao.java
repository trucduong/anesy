package com.green.dao;

import org.springframework.stereotype.Repository;

import com.green.entity.Course;

@Repository
public class CouseDao extends BaseDao<Course, Integer> {
	
	@Override
	protected Class<Course> getEntityClass() {
		return Course.class;
	}
}
