package com.green.dao;

import org.springframework.stereotype.Repository;

import com.green.entity.CourseCategory;
import com.green.entity.CourseDetail;

@Repository
public class CourseCategoryDao extends BaseDao<CourseCategory, Integer> {
	
	@Override
	protected Class<CourseCategory> getEntityClass() {
		return CourseCategory.class;
	}
	
	
}
