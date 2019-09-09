package com.green.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "feedback_type")
	@Enumerated(EnumType.STRING)
	private FeedbackType feedbackType;

	@Column(name = "author")
	private int author;

	@Column(name = "target_id")
	private int targetId;

	@Column(name = "target_type")
	private FeedbackTargetType targetType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FeedbackType getFeedbackType() {
		return feedbackType;
	}

	public void setFeedbackType(FeedbackType feedbackType) {
		this.feedbackType = feedbackType;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getTargetId() {
		return targetId;
	}

	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}

	public FeedbackTargetType getTargetType() {
		return targetType;
	}

	public void setTargetType(FeedbackTargetType targetType) {
		this.targetType = targetType;
	}

}