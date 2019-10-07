package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.dao.CourseSubjectDao;
import com.green.dao.CouseDao;
import com.green.dao.ExerciseDao;
import com.green.dao.LessonDao;
import com.green.dao.SubjectsDao;
import com.green.entity.Course;
import com.green.entity.CourseSubjects;
import com.green.entity.Exercise;
import com.green.entity.Lesson;
import com.green.entity.Subjects;
import com.green.model.Page;

@Service
public class SubjectsService {
	@Autowired
	private SubjectsDao subjectsDao;
	
	@Autowired
	private LessonDao lessonDao;
	
	@Autowired
	private ExerciseDao exerciseDao;
	
	@Autowired
	private CourseSubjectDao courseSubjectdao;
	
	@Autowired
	private CouseDao courseDao;

	public List<Subjects> findAll() {
		return subjectsDao.findAll();

	}

	public Subjects findById(int id) {
		return subjectsDao.find(id);
	}

	public void insert(Subjects subjects, int courseId) {
		int subjectId = subjectsDao.save(subjects);
		subjects.setId(subjectId);
		
		Course course = courseDao.find(courseId);
		CourseSubjects courseSubjects = new CourseSubjects();
		courseSubjects.setCourse(course);
		courseSubjects.setSubjects(subjects);
		courseSubjectdao.save(courseSubjects);
	}

	public void delete(int subId, Subjects subject) {
		List<Lesson> lessons = lessonDao.findAll(subId);
		List<Exercise> exercises= exerciseDao.findAll(subId);
		for (Lesson lesson : lessons) {
			
			lessonDao.delete(lesson);
		}
		for(Exercise exercise: exercises){
			exerciseDao.delete(exercise);
		}
		
		List<CourseSubjects> courseSubjects = courseSubjectdao.findBySubjects(subId);
		for (CourseSubjects courseSubjects2 : courseSubjects) {
			courseSubjectdao.delete(courseSubjects2);
		}
		
		subjectsDao.delete(subject);
		
	}

	public void update(Subjects subjects, int courseId) {
		subjectsDao.update(subjects);
		
		CourseSubjects courseSubjects = courseSubjectdao.find(courseId, subjects.getId());
		Course course = courseDao.find(courseId);
		if (courseSubjects == null) {
			courseSubjects = new CourseSubjects();
			courseSubjects.setCourse(course);
			courseSubjects.setSubjects(subjects);
			courseSubjectdao.save(courseSubjects);
		} else {
			courseSubjects.setCourse(course);
			courseSubjectdao.update(courseSubjects);
		}
	}

	public Page<Subjects> findSubject(String filter, int page) {
		Page<Subjects> result = new Page<>();
		long totalRows = subjectsDao.count(filter);
		if (totalRows <= 0) {
			return result;
		}

		List<Subjects> list = subjectsDao.search(filter, page);

		result.setCurrent(page);
		result.setList(list);
		result.setTotalRows(totalRows);
		return result;
	}
	
	public List<CourseSubjects> findCourseSubjectsByCourse(int courseId){
		return courseSubjectdao.findByCourse(courseId);
	}
	
	public List<CourseSubjects> findCourseSubjectsBySubjects(int subjectsId){
		return courseSubjectdao.findBySubjects(subjectsId);
	}
	
	public CourseSubjects findCourseSubjects(int courseId, int subjectsId){
		return courseSubjectdao.find(courseId, subjectsId);
	}
	
	public CourseSubjects findCourseSubjectsbysubject(Subjects subjects){
		return courseSubjectdao.findBysubjectId(subjects);
	}
	
	
	
}
