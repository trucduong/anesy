package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.dao.LessonDao;
import com.green.entity.Lesson;
import com.green.exception.MyException;

@Service
public class LessonService {
	@Autowired
	private LessonDao lessonDao;
	
	public List<Lesson> findAll() {
		
		return lessonDao.findAll();
	}
	
	public Lesson findById(int id) {
		return lessonDao.findById(id);
	}
	
	public boolean insert(Lesson account) {
		return lessonDao.insert(account);
	}

	public boolean update(int id, Lesson account) {
		return lessonDao.update(id, account);
	}
	
	public boolean delete(int id) {
		return lessonDao.delete(id);
	}
}
