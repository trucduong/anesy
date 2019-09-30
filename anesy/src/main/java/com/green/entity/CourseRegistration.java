package com.green.entity;

import java.util.Date;

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
@Table(name = "course_registration")
public class CourseRegistration {
	
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
	
	@Column(name="regis_date")
	private Date regisDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private Progress status;
	
	@Column(name = "author")
	private int author;

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
	 * @return the regisDate
	 */
	public Date getRegisDate() {
		return regisDate;
	}

	/**
	 * @param regisDate the regisDate to set
	 */
	public void setRegisDate(Date regisDate) {
		this.regisDate = regisDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the author
	 */
	public int getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(int author) {
		this.author = author;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Progress status) {
		this.status = status;
	}


	
	
	
	
}
