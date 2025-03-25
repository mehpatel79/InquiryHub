package com.sb.InquiryHub.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "hubtype")
public class Hubtype {
	
	@Id
	@Column(name = "id")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "hub_type_name")
	private String hubTypeName;
	
	@OneToMany(mappedBy = "hubtype", cascade = CascadeType.ALL)
	private List<AssociateCompany> associateCompany;

	public Hubtype() {
	}

	public Hubtype(Integer id, String hubTypeName, List<AssociateCompany> associateCompany) {
		super();
		this.id = id;
		this.hubTypeName = hubTypeName;
		this.associateCompany = associateCompany;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHubTypeName() {
		return hubTypeName;
	}

	public void setHubTypeName(String hubTypeName) {
		this.hubTypeName = hubTypeName;
	}

	public List<AssociateCompany> getAssociateCompany() {
		return associateCompany;
	}

	public void setAssociateCompany(List<AssociateCompany> associateCompany) {
		this.associateCompany = associateCompany;
	}

	@Override
	public String toString() {
		return "HubType [id=" + id + ", hubTypeName=" + hubTypeName + ", associateCompany=" + associateCompany + "]";
	}
	
	
}
