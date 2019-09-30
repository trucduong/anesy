package com.green.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lesson_progress")
public class LessonProgress {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "account_id")
	private Profile student;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "course_id")
	private Course course;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "lesson_id")
	private Lesson lesson;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private Progress status;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the student
	 */
	public Profile getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Profile student) {
		this.student = student;
	}

	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * @return the lesson
	 */
	public Lesson getLesson() {
		return lesson;
	}

	/**
	 * @param lesson the lesson to set
	 */
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	/**
	 * @return the status
	 */
	public Progress getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Progress status) {
		this.status = status;
	}


	
	
	
}
