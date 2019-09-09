package com.green.dao;

import org.springframework.stereotype.Repository;

import com.green.entity.Subjects;

@Repository
public class SubjectsDao extends BaseDao<Subjects, Integer> {
	
	@Override
	protected Class<Subjects> getEntityClass() {
		return Subjects.class;
	}
}
