package com.green.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
public class Lesson {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name", columnDefinition = "nvarchar(500)")
	private String name;

	@Column(name = "description", columnDefinition = "nvarchar(1000)")
	private String description;

	// TODO: mapping
	@ManyToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name = "subjects_id")
	private Subjects subjectsId;
	
	@Column(name = "author")
	private int author;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "seq")
	private int seq;

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

	
	public Subjects getSubjectsId() {
		return subjectsId;
	}

	public void setSubjectsId(Subjects subjectsId) {
		this.subjectsId = subjectsId;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

}