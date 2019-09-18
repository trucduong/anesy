package com.green.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile {
	@Id
	@Column(name="account_id")
	private int accountId;
	
	@Column(name="user_type")
	private int userType;
	
	@Column(name = "full_name",columnDefinition = "nvarchar(100)")
	private String fullName;
	
	@Column(name = "phone",columnDefinition = "varchar(15)")
	private String phone;
	
	@Column(name = "email",columnDefinition = "nvarchar(100)")
	private String email;
	
	@Column(name = "gender",columnDefinition = "char(1)")
	private String gender;
	
	@Column(name = "birth_date")
	private Date birthDate;
	
	@Column(name = "address",columnDefinition = "nvarchar(200)")
	private String address;
	
	@Column(name = "certificates",columnDefinition = "text")
	private String certificates;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCertificates() {
		return certificates;
	}

	public void setCertificates(String certificates) {
		this.certificates = certificates;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
}	
	
