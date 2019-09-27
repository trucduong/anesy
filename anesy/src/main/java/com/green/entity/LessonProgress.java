package com.green.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lesson_progress")
public class LessonProgress {

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "account_id")
	private Profile student;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "course")
	private Course course;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "id")
	private Lesson lesson;
	
	@Column(name="status")
	private String status;


	public Profile getStudent() {
		return student;
	}


	public void setStudent(Profile student) {
		this.student = student;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public Lesson getLesson() {
		return lesson;
	}


	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
