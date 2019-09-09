package com.green.dao;

import org.springframework.stereotype.Repository;

import com.green.entity.CourseComment;

@Repository
public class CourseCommentDao extends BaseDao<CourseComment, Integer> {
	
	@Override
	protected Class<CourseComment> getEntityClass() {
		return CourseComment.class;
	}
}
