package com.green.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "practices_files")
public class PracticesFiles {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="practices_id")
	private int practicesId;
	
	@Column(name = "file_name")
	private String fileName;
	
	@Column(name="_order")
	private int order;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPracticesId() {
		return practicesId;
	}

	public void setPracticesId(int practicesId) {
		this.practicesId = practicesId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
}
