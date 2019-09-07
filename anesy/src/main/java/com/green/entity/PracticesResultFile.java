package com.green.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "practices_result_file")
public class PracticesResultFile {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private PracticesResult practicesResultId;
	
	@Column(name = "file_name")
	private String fileName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PracticesResult getPracticesResultId() {
		return practicesResultId;
	}

	public void setPracticesResultId(PracticesResult practicesResultId) {
		this.practicesResultId = practicesResultId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
