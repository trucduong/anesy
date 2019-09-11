package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.green.dao.SubjectsDao;
import com.green.entity.Subjects;


public class SubjectsService {
	@Service
	public class CourseService {
		@Autowired
		private SubjectsDao subjectsDao;

		public List<Subjects> findAll() {
			return subjectsDao.findAll();

		}

		public Subjects findById(int id) {
			return subjectsDao.find(id);
		}

		public void insert(Subjects subjects) {
			subjectsDao.save(subjects);
		}

		public void delete(Subjects subjects) {
			subjectsDao.delete(subjects);
		}

		public void update(Subjects subjects) {
			subjectsDao.update(subjects);
		}
	}
}
