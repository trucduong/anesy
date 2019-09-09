package com.green.dao;

import org.springframework.stereotype.Repository;

import com.green.entity.Lesson;

@Repository
public class LessonDao extends BaseDao<Lesson, Integer> {
	
	@Override
	protected Class<Lesson> getEntityClass() {
		return Lesson.class;
	}
}
