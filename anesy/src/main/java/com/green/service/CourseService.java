package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.dao.CouseDao;
import com.green.entity.Course;

@Service
public class CourseService {
	@Autowired
	private CouseDao courseDao;

	public List<Course> findAll() {
		return courseDao.findAll();

	}

	public Course findById(int id) {
		return courseDao.find(id);
	}

	public void insert(Course course) {
		courseDao.save(course);
	}

	public void delete(Course course) {
		courseDao.delete(course);
	}

	public void update(Course course) {
		courseDao.update(course);
	}
}
