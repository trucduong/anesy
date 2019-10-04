package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.dao.ExerciseDao;
import com.green.entity.Exercise;


import com.green.model.Page;

@Service
public class ExerciseService {

	@Autowired
	private ExerciseDao exerciseDao;
	

	public List<Exercise> findAll() {
		return exerciseDao.findAll();

	}

	public  Exercise findById(int id) {
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
	
	public Page<Exercise> findExercise(String filter, int page) {
		Page<Exercise> result = new Page<>();
		long totalRows = exerciseDao.count(filter);
		if (totalRows <= 0) {
			return result;
		}

		List<Exercise> list = exerciseDao.search(filter, page);

		result.setCurrent(page);
		result.setList(list);
		result.setTotalRows(totalRows);
		return result;
	}
	public void delete(int id ) {
		exerciseDao.deleteById(id);
	}
}
