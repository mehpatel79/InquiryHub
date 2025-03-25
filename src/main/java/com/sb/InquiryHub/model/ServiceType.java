package com.sb.InquiryHub.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "servicetype")
public class ServiceType {

	@Id
	@Column(name = "id")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "service_name")
	private String serviceName;

	
	public ServiceType() {
	}

	public ServiceType(Integer id, String serviceName) {
		super();
		this.id = id;
		this.serviceName = serviceName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Override
	public String toString() {
		return "ServiceType [id=" + id + ", serviceName=" + serviceName + "]";
	}
	
	
	
	
}
