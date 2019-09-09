package com.green.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exercise")
public class Exercise {
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

	public int getSubjectsId() {
		return subjectsId;
	}

	public void setSubjectsId(int subjectsId) {
		this.subjectsId = subjectsId;
	}

}