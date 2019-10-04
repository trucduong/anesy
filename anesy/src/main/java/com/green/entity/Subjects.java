package com.green.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subjects {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "avatar", columnDefinition = "nvarchar(50)")
	private String avatar;

	@Column(name = "name", columnDefinition = "nvarchar(MAX)")
	private String name;

	@Column(name = "description", columnDefinition = "nvarchar(MAX)")
	private String description;

	@Column(name = "author")
	private int author;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "tags", columnDefinition = "nvarchar(MAX)")
	private String tags;

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

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	
	public String getAvatar() {
		return avatar;
	}
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}