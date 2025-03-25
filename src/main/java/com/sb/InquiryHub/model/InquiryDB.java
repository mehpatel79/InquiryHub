package com.sb.InquiryHub.model;

import com.fasterxml.jackson.annotation.JsonIgnore; 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "inquirydb")
public class InquiryDB {

	@Id
	@Column (name = "id")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "inquiry_hub")
	private String inquiryHub;
	
	@Column(name = "inquiry_for")
	private String inquiryFor;
	
	@Column(name = "creation_date")
	private String creationDate;
	
	@Column(name = "updated_date")
	private String updatedDate;
	
	@Column(name = "inquiry_status")
	private String inquiryStatus;
	
	@Column(name = "inquiry_attend_by")
	private String inquiryAttendBy;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public InquiryDB() {
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInquiryHub() {
		return inquiryHub;
	}

	public void setInquiryHub(String inquiryHub) {
		this.inquiryHub = inquiryHub;
	}

	public String getInquiryFor() {
		return inquiryFor;
	}

	public void setInquiryFor(String inquiryFor) {
		this.inquiryFor = inquiryFor;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getInquiryStatus() {
		return inquiryStatus;
	}

	public void setInquiryStatus(String inquiryStatus) {
		this.inquiryStatus = inquiryStatus;
	}

	public String getInquiryAttendBy() {
		return inquiryAttendBy;
	}

	public void setInquiryAttendBy(String inquiryAttendBy) {
		this.inquiryAttendBy = inquiryAttendBy;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public InquiryDB(Integer id, String inquiryHub, String inquiryFor, String creationDate, String updatedDate,
			String inquiryStatus, String inquiryAttendBy, User user) {
		super();
		this.id = id;
		this.inquiryHub = inquiryHub;
		this.inquiryFor = inquiryFor;
		this.creationDate = creationDate;
		this.updatedDate = updatedDate;
		this.inquiryStatus = inquiryStatus;
		this.inquiryAttendBy = inquiryAttendBy;
		this.user = user;
	}


	@Override
	public String toString() {
		return "InquiryDB [id=" + id + ", inquiryHub=" + inquiryHub + ", inquiryFor=" + inquiryFor + ", creationDate="
				+ creationDate + ", updatedDate=" + updatedDate + ", inquiryStatus=" + inquiryStatus
				+ ", inquiryAttendBy=" + inquiryAttendBy + ", user=" + user + "]";
	}

	
	
}
