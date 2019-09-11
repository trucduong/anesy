package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.dao.ExerciseDao;
import com.green.entity.Exercise;



public class ExcerciseService {

	@Service
	public class CourseService {
		@Autowired
		private ExerciseDao exerciseDao;

		public List<Exercise> findAll() {
			return exerciseDao.findAll();

		}

		public Exercise findById(int id) {
			return exerciseDao.find(id);
		}

		public void insert(Exercise exercise) {
			exerciseDao.save(exercise);
		}

		public void delete(Exercise exercise) {
			exerciseDao.delete(exercise);
		}

		public void update(Exercise exercise) {
			exerciseDao.update(exercise);
		}
	}

}
