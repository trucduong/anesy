package com.green.dao;

import org.springframework.stereotype.Repository;

import com.green.entity.AssignmentComment;

@Repository
public class AssignmentCommentDao extends BaseDao<AssignmentComment, Integer> {
	
	@Override
	protected Class<AssignmentComment> getEntityClass() {
		return AssignmentComment.class;
	}
}
