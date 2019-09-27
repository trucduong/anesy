package com.green.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course_subjects")
public class CourseSubjects {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "course_id")
	private Course course;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "subjects_id")
	private Subjects subjects;

	@Column(name = "seq")
	private int seq;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Subjects getSubjects() {
		return subjects;
	}

	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

}