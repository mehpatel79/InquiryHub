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
@Table (name = "associatecompany")
public class AssociateCompany {

	
	@Id
	@Column (name = "id")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "associate_name")
	private String AssociateName;
	
	private String description;
	
	
	@ManyToOne 		//(fetch=FetchType.LAZY)
	@JoinColumn(name = "hubtype_id")
	private Hubtype hubtype;

	public AssociateCompany() {
	}

	public AssociateCompany(Integer id, String associateName, String description, Hubtype hubtype) {
		super();
		this.id = id;
		AssociateName = associateName;
		this.description = description;
		this.hubtype = hubtype;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAssociateName() {
		return AssociateName;
	}

	public void setAssociateName(String associateName) {
		AssociateName = associateName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Hubtype getHubtype() {
		return hubtype;
	}

	public void setHubType(Hubtype hubtype) {
		this.hubtype = hubtype;
	}

	@Override
	public String toString() {
		return "AssociateCompany [id=" + id + ", AssociateName=" + AssociateName + ", description=" + description
				+ ", hubtype=" + hubtype + "]";
	}

	
	
}
