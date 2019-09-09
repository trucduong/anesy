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
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name", columnDefinition = "nvarchar(500)")
	private String name;

	@Column(name = "description", columnDefinition = "nvarchar(1000)")
	private String description;

	@Column(name = "author")
	private int author;

	@Column(name = "price")
	private int price;

	@Column(name = "like_number")
	private int like;

	@Column(name = "unlike_number")
	private int unlike;

	@Column(name = "created_at")
	private Date createdAt;
<<<<<<< HEAD
	
	@ManyToOne(cascade = CascadeType.ALL)
	private CourseGroup groupId;
=======

	@Column(name = "tags", columnDefinition = "nvarchar(500)")
	private String tags;
>>>>>>> refs/remotes/origin/dev

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getUnlike() {
		return unlike;
	}

	public void setUnlike(int unlike) {
		this.unlike = unlike;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

<<<<<<< HEAD
	public CourseGroup getGroupId() {
		return groupId;
=======
	public String getTags() {
		return tags;
>>>>>>> refs/remotes/origin/dev
	}

<<<<<<< HEAD
	public void setGroupId(CourseGroup groupId) {
		this.groupId = groupId;
=======
	public void setTags(String tags) {
		this.tags = tags;
>>>>>>> refs/remotes/origin/dev
	}

}