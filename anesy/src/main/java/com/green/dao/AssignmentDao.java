package com.green.dao;

import org.springframework.stereotype.Repository;

import com.green.entity.Assignment;

@Repository
public class AssignmentDao extends BaseDao<Assignment, Integer> {
	
	@Override
	protected Class<Assignment> getEntityClass() {
		return Assignment.class;
	}
}
