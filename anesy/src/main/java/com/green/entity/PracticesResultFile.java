package com.green.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "practices_result_file")
public class PracticesResultFile {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="practices_result_id")
	private int practicesResultId;
	
	@Column(name = "file_name")
	private String fileName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPracticesResultId() {
		return practicesResultId;
	}

	public void setPracticesResultId(int practicesResultId) {
		this.practicesResultId = practicesResultId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
