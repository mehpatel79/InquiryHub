package com.sb.InquiryHub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.InquiryHub.model.InquiryDB;
import com.sb.InquiryHub.repository.InquiryDBRepository;

@Service
public class InquiryDBService {

	@Autowired
	private InquiryDBRepository inquiryDBRepository;
	
	public List <InquiryDB> getInquiryList(){
	
		return inquiryDBRepository.findAll();
	}
	
	
	public void saveInquiry(InquiryDB inquiryDB) {
		inquiryDBRepository.save(inquiryDB);
		
	}


	public List<InquiryDB> getInquiryListbyHub(String hubtype){
		
		return inquiryDBRepository.findInquiryDBByHub(hubtype);
	}
	

	public List<InquiryDB> getInquiryDBbyHubAndStatus(String hubtype, String status){
		
		return inquiryDBRepository.findInquiryDBByHubAndStatus(hubtype, status);
	}

	
	public InquiryDB getInquiryDBById(Integer id) {
		return inquiryDBRepository.getById(id);
		
	}
	
}
