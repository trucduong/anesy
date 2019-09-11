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
@Table(name = "course_detail")
public class CourseDetail {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	// TODO: mapping
	@ManyToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name = "course_id")
	private CourseCategory courseId;

	public CourseCategory getCourseId() {
		return courseId;
	}

	public void setCourseId(CourseCategory courseId) {
		this.courseId = courseId;
	}

	public Subjects getSubjectsId() {
		return subjectsId;
	}

	public void setSubjectsId(Subjects subjectsId) {
		this.subjectsId = subjectsId;
	}

	// TODO: mapping
	@ManyToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name = "subjects_id")
	private Subjects subjectsId;

	@Column(name = "seq")
	private int seq;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

}