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
@Table(name = "lesson_comment")
public class LessonComment {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
<<<<<<< HEAD
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Lesson lessonId;
	
	@Column(name="author")
=======

	@Column(name = "lesson_id")
	private int lessonId;

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

<<<<<<< HEAD
	public Lesson getLessonId() {
=======
	public int getLessonId() {
>>>>>>> refs/remotes/origin/dev
		return lessonId;
	}

<<<<<<< HEAD
	public void setCourseId(Lesson lessonId) {
=======
	public void setLessonId(int lessonId) {
>>>>>>> refs/remotes/origin/dev
		this.lessonId = lessonId;
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