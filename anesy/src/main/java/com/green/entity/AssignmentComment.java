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
@Table(name = "assignment_comment")
public class AssignmentComment {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "assignment_id")
	private int assignmentId;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "author")
	private Profile author;

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

	public int getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}

	

	/**
	 * @return the author
	 */
	public Profile getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(Profile author) {
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