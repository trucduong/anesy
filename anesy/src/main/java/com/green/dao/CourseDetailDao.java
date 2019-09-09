package com.green.dao;

import org.springframework.stereotype.Repository;

import com.green.entity.CourseDetail;

@Repository
public class CourseDetailDao extends BaseDao<CourseDetail, Integer> {
	
	@Override
	protected Class<CourseDetail> getEntityClass() {
		return CourseDetail.class;
	}
}
