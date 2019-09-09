package com.green.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course_comment")
public class CourseComment {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
<<<<<<< HEAD
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Course courseId;
	
	@Column(name="author")
=======

	@Column(name = "course_id")
	private int courseId;

	@Column(name = "author")
>>>>>>> refs/remotes/origin/dev
	private int author;

	@Column(name = "content", columnDefinition = "nvarchar(1000)")
	private String content;

	@Column(name = "created_at")
	private Date createdAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Course getCourseId() {
		return courseId;
	}

	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}