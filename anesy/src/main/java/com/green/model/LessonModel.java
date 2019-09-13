package com.green.model;

import java.sql.Date;

import com.green.entity.Lesson;

public class LessonModel {
	private int id;
	private String name;
	private String description;
	private int subjectsId;
	private String subjectName;
	private int author;
	private int seq;
	private Date createdAt;

	public LessonModel() {
	}

	public LessonModel(Lesson lesson) {
		this.id = lesson.getId();
		this.name = lesson.getName();
		this.description = lesson.getDescription();
		this.seq = lesson.getSeq();
		this.author = lesson.getAuthor();
	}

	public LessonModel(int id, String name, String description, int seq, int author) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.seq = seq;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSubjectsId() {
		return subjectsId;
	}

	public void setSubjectsId(int subjectsId) {
		this.subjectsId = subjectsId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	

}
