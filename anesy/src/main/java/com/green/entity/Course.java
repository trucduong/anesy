package com.green.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	@Column(name = "shortdesc", columnDefinition = "nvarchar(500)")
	private String shortdesc;

	@Column(name = "description", columnDefinition = "nvarchar(1000)")
	private String description;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "author")
	private Account author;

	@Column(name = "price")
	private int price;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "tags", columnDefinition = "nvarchar(500)")
	private String tags;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private CourseCategory category;

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public Account getAuthor() {
		return author;
	}

	public void setAuthor(Account author) {
		this.author = author;
	}

	public CourseCategory getCategory() {
		return category;
	}

	public void setCategory(CourseCategory category) {
		this.category = category;
	}

	public String getShortdesc() {
		return shortdesc;
	}

	public void setShortdesc(String shortdesc) {
		this.shortdesc = shortdesc;
	}

}