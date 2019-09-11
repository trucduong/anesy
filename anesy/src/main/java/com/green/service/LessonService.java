package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.green.dao.LessonDao;
import com.green.entity.Lesson;


public class LessonService {
	@Service
	public class CourseService {
		@Autowired
		private LessonDao lessonDao;

		public List<Lesson> findAll() {
			return lessonDao.findAll();

		}

		public Lesson findById(int id) {
			return lessonDao.find(id);
		}

		public void insert(Lesson lesson) {
			lessonDao.save(lesson);
		}

		public void delete(Lesson lesson) {
			lessonDao.delete(lesson);
		}

		public void update(Lesson lesson) {
			lessonDao.update(lesson);
		}
	}
}
