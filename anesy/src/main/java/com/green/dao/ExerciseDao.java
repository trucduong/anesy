package com.green.dao;

import org.springframework.stereotype.Repository;

import com.green.entity.Exercise;

@Repository
public class ExerciseDao extends BaseDao<Exercise, Integer> {
	
	@Override
	protected Class<Exercise> getEntityClass() {
		return Exercise.class;
	}
}
