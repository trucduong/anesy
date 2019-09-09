package com.green.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	private FeedbackType feedbackType;
	
	private int author;
	
	private int targetId;
	
	private FeedbackTargetType targetType;
	
}