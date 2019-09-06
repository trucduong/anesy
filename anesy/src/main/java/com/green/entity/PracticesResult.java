package com.green.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "practices_result")
public class PracticesResult {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="practices_id")
	private int practicesId;
	
	@Column(name="author")
	private int author;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "created_at")
	private Date createdAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPracticesId() {
		return practicesId;
	}

	public void setPracticesId(int practicesId) {
		this.practicesId = practicesId;
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
