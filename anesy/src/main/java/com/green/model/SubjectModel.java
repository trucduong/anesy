package com.green.model;

import java.util.Date;

public class SubjectModel {
private String name;
private String description;
private String avatar;
private int author;
private Date createdAt;
private String tags;

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
public String getAvatar() {
	return avatar;
}
public void setAvatar(String avatar) {
	this.avatar = avatar;
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
public String getTags() {
	return tags;
}
public void setTags(String tags) {
	this.tags = tags;
}
}
