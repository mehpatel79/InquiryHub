package com.sb.InquiryHub.model;

import java.util.List; 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name="user")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	
	
	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_email")
	private String userEmail;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "user_contactno")
	private String userContactno;
	
	@Column(name = "user_type")
	private String userType;


	@Column(name = "hub_type")
	private String hubType;

	@Column(name = "associate_name")
	private String associateName;

	
	@OneToMany(mappedBy = "user")
	private List<InquiryDB> inquiryDB;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserContactno() {
		return userContactno;
	}

	public void setUserContactno(String userContactno) {
		this.userContactno = userContactno;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getHubType() {
		return hubType;
	}

	public void setHubType(String hubType) {
		this.hubType = hubType;
	}

	public String getAssociateName() {
		return associateName;
	}

	public void setAssociateName(String associateName) {
		this.associateName = associateName;
	}

	public List<InquiryDB> getInquiryDB() {
		return inquiryDB;
	}

	public void setInquiryDB(List<InquiryDB> inquiryDB) {
		this.inquiryDB = inquiryDB;
	}

	public User() {
	}

	public User(Integer id, String userName, String userEmail, String password, String userContactno, String userType,
			String hubType, String associateName, List<InquiryDB> inquiryDB) {
		super();
		this.id = id;
		this.userName = userName;
		this.userEmail = userEmail;
		this.password = password;
		this.userContactno = userContactno;
		this.userType = userType;
		this.hubType = hubType;
		this.associateName = associateName;
		this.inquiryDB = inquiryDB;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userEmail=" + userEmail + ", password=" + password
				+ ", userContactno=" + userContactno + ", userType=" + userType + ", hubType=" + hubType
				+ ", associateName=" + associateName + ", inquiryDB=" + inquiryDB + "]";
	}

	

		
}
