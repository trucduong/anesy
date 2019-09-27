package com.green.dao;

import org.springframework.stereotype.Repository;

import com.green.entity.CourseSubjects;

@Repository
public class CourseDetailDao extends BaseDao<CourseSubjects, Integer> {
	
	@Override
	protected Class<CourseSubjects> getEntityClass() {
		return CourseSubjects.class;
	}
}
