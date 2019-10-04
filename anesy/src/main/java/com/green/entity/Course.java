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

	@Column(name = "avatar", columnDefinition = "nvarchar(50)")
	private String avatar;
	
	@Column(name = "name", columnDefinition = "nvarchar(MAX)")
	private String name;

	@Column(name = "shortdesc", columnDefinition = "nvarchar(MAX)")
	private String shortdesc;

	@Column(name = "description", columnDefinition = "nvarchar(MAX)")
	private String description;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "author")
	private Profile author;

	@Column(name = "price")
	private int price;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "tags", columnDefinition = "nvarchar(MAX)")
	private String tags;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private CourseCategory category;
	
	@Column(name = "benefit", columnDefinition = "nvarchar(MAX)")
	private String benefit;
	
	@Column(name = "requiment", columnDefinition = "nvarchar(MAX)")
	private String requiment;
	
	@Column(name ="include", columnDefinition = "nvarchar(MAX)")
	private String include;
	
	/**
	 * @return the include
	 */
	public String getInclude() {
		return include;
	}

	/**
	 * @param include the include to set
	 */
	public void setInclude(String include) {
		this.include = include;
	}

	public String getRequiment() {
		return requiment;
	}

	public void setRequiment(String requiment) {
		this.requiment = requiment;
	}

	public String getBenefit() {
		return benefit;
	}


	public void setBenefit(String benefit) {
		this.benefit = benefit;
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

	public Profile getAuthor() {
		return author;
	}

	public void setAuthor(Profile author) {
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

	public String getAvatar() {
		return avatar;
	}
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
}