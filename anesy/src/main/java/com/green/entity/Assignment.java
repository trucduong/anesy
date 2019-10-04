package com.green.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assignment")
public class Assignment {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name", columnDefinition = "nvarchar(MAX)")
	private String name;

	@Column(name = "description", columnDefinition = "nvarchar(MAX)")
	private String description;

	// assignment.excerise_id -> excerise.id
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "excerise_id")
	private Exercise excerise;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "student_id")
	private Account student;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "started_date")
	private Date startedDate;

	@Column(name = "ended_date")
	private Date endedDate;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private AssignmentStatus status;

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

	public Exercise getExcerise() {
		return excerise;
	}

	public void setExcerise(Exercise excerise) {
		this.excerise = excerise;
	}

	public Account getStudent() {
		return student;
	}

	public void setStudent(Account student) {
		this.student = student;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartedDate() {
		return startedDate;
	}

	public void setStartedDate(Date startedDate) {
		this.startedDate = startedDate;
	}

	public Date getEndedDate() {
		return endedDate;
	}

	public void setEndedDate(Date endedDate) {
		this.endedDate = endedDate;
	}

	public AssignmentStatus getStatus() {
		return status;
	}

	public void setStatus(AssignmentStatus status) {
		this.status = status;
	}

}