package com.green.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course_detail")
public class CourseDetail {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "course_id")
	private int courseId;

	@Column(name = "subjects_id")
	private int subjectsId;

	@Column(name = "seq")
	private int seq;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getSubjectsId() {
		return subjectsId;
	}

	public void setSubjectsId(int subjectsId) {
		this.subjectsId = subjectsId;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

}