package com.green.dao;

import org.springframework.stereotype.Repository;

import com.green.entity.CourseRegistration;
import com.green.entity.CourseSubjects;

@Repository
public class CourseRegistrationDao extends BaseDao<CourseRegistration, Integer> {
	
	@Override
	protected Class<CourseRegistration> getEntityClass() {
		return CourseRegistration.class;
	}


}
