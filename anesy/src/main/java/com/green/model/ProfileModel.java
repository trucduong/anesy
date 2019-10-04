package com.green.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ProfileModel {

	private int accountId;

	private String fullName;

	private String phone;

	private String email;

	private String gender;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;

	private String address;
	
	private String specialize;
	
	private String description;

	
	/**
	 * @return the specialize
	 */
	public String getSpecialize() {
		return specialize;
	}

	/**
	 * @param specialize the specialize to set
	 */
	public void setSpecialize(String specialize) {
		this.specialize = specialize;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
