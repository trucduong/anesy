package com.green.entity;

<<<<<<< HEAD
import javax.persistence.CascadeType;
=======
import java.util.Date;

>>>>>>> refs/remotes/origin/dev
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

	@Column(name = "subjects_id")
	private int subjectsId;
	
<<<<<<< HEAD
	@ManyToOne(cascade = CascadeType.ALL)
	private Course courseId;
	
	@Column(name="order")
	private int order;
	
	@Column(name="author")
=======
	@Column(name = "author")
>>>>>>> refs/remotes/origin/dev
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

<<<<<<< HEAD
	public Course getCourseId() {
		return courseId;
=======
	public int getSubjectsId() {
		return subjectsId;
>>>>>>> refs/remotes/origin/dev
	}

<<<<<<< HEAD
	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
=======
	public void setSubjectsId(int subjectsId) {
		this.subjectsId = subjectsId;
>>>>>>> refs/remotes/origin/dev
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