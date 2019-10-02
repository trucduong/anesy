package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.dao.CourseCategoryDao;
import com.green.dao.CourseCommentDao;
import com.green.dao.CourseRegistrationDao;
import com.green.dao.CouseDao;
import com.green.entity.Course;
import com.green.entity.CourseCategory;
import com.green.entity.CourseComment;
import com.green.entity.CourseRegistration;
import com.green.entity.Profile;
import com.green.entity.Progress;
import com.green.model.CourseFilter;
import com.green.model.Page;

@Service
public class CourseService {
	@Autowired
	private CourseCategoryDao courseCategoryDao;
	
	@Autowired
	private CourseRegistrationDao courseRegistrationDao;
	
	@Autowired
	private CouseDao courseDao;
	
	
	@Autowired
	private CourseCommentDao courseCommentDao;
	

	public List<Course> search(CourseFilter filter) {
		if (filter == null) {
			return courseDao.findAll();
		}
		
		return courseDao.search(filter);
	}

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

	public List<CourseCategory> findCategories() {
		return courseCategoryDao.findAll();
	}
	

	public List<CourseComment> findAllComments(int id) {
		return courseCommentDao.findbyCourseID(id);
	}
	
	public Page<CourseCategory> findCategories(String filter, int page) {
		Page<CourseCategory> result = new Page<>();
		long totalRows = courseCategoryDao.count(filter);
		if (totalRows <= 0) {
			return result;
		}
		
		List<CourseCategory> list = courseCategoryDao.search(filter, page);
		
		result.setCurrent(page);
		result.setList(list);
		result.setTotalRows(totalRows);
		return result;
	}
	
	public List<Course> findByAuthor(Profile profile) {
		return courseDao.findByAuthor(profile);
	}
	
	
	
	public void saveCategory(CourseCategory category) {
		courseCategoryDao.save(category);
	}
	
	public CourseCategory findCategory(int catId) {
		return courseCategoryDao.find(catId);
	}
	
	public void deleteCategory(int catId) {
		List<Course> courses = courseDao.findAll(catId);
		for (Course course : courses) {
			course.setCategory(null);
			courseDao.save(course);
		}
		
		courseCategoryDao.deleteById(catId);
	}
	
	public void saveCourseRegis(CourseRegistration courseRegistration) {
		courseRegistrationDao.save(courseRegistration);
	}
	
	public Page<Course> findCourse(String filter, int page) {
		Page<Course> result = new Page<>();
		long totalRows = courseDao.count(filter);
		if (totalRows <= 0) {
			return result;
		}
		
		List<Course> list = courseDao.search(filter, page);
		
		result.setCurrent(page);
		result.setList(list);
		result.setTotalRows(totalRows);
		return result;
	}
	
	public List<CourseRegistration> findCourseRegistration(Profile profile) {
		return courseRegistrationDao.findByStudent(profile);
	}
	
	public CourseRegistration findCourseRegistration(int accountId, int courseId, Progress[] status) {
		return courseRegistrationDao.find(accountId, courseId, status);
	}
	
	public void insertComment(CourseComment courseComment) {
		courseCommentDao.save(courseComment);
	}
	
}
