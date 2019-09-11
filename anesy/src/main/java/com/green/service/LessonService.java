package com.green.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.dao.LessonDao;
import com.green.entity.Lesson;
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
		return lessonDao.find(id);
	}
	
	public void insert(Lesson lesson) {
		lessonDao.save(lesson);
	}

	public void update(Lesson lesson) {
		lessonDao.update(lesson);
	}
	
	public void delete(int id) {
		lessonDao.deleteById(id);
	}
	
	public List<Lesson> findAllWithSubjects() {
		Lesson lesson1 = new Lesson();
		lesson1.setId(191);
		lesson1.setName("Bài học số 1");
		lesson1.setAuthor(113);
		List<Lesson> lessons = new ArrayList<>();
		lessons.add(lesson1);
		
		return lessons;
//		return lessonDao.findAllWithSubjects();
	}
}
