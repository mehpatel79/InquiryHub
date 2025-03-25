package com.sb.InquiryHub.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.InquiryHub.model.AssociateCompany;
import com.sb.InquiryHub.model.User;
import com.sb.InquiryHub.repository.AssociateCompanyRepository;

@Service
public class AssociateCompanyService {

	@Autowired
	private AssociateCompanyRepository associateCompanyRepository;

	public List<AssociateCompany> getAssociateCompanyList(){
		return associateCompanyRepository.findAll();
	}
	
	public List<AssociateCompany> getAssociateCompanyWithHubtype(Integer acid) {
		
		return associateCompanyRepository.findAssociateCompanyByHubtypeId(acid);
	}
	
	
	public AssociateCompany saveAssociate(AssociateCompany associateCompany) {
		AssociateCompany associateData = associateCompanyRepository.save(associateCompany);
		return associateData;
	}

	
}

