package com.green.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course_registration")
public class CourseRegistration {
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "account_id")
	private Profile student;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "course")
	private Course course;
	
	@Column(name="regis_date")
	private Date regisDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "account_id")
	private Profile teacher;


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


	public Date getRegisDate() {
		return regisDate;
	}


	public void setRegisDate(Date regisDate) {
		this.regisDate = regisDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Profile getTeacher() {
		return teacher;
	}

	public void setTeacher(Profile teacher) {
		this.teacher = teacher;
	}
	
	
	
}
