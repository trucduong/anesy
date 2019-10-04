package com.green.model;

import com.green.entity.Subjects;

public class ExerciseModel {
	private String description;
	private String name;
	private int subjectsId;
	private String subjectName;
	public int getSubjectsId() {
		return subjectsId;
	}
	public void setSubjectsId(int subjectsId) {
		this.subjectsId = subjectsId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
