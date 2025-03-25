package com.sb.InquiryHub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.InquiryHub.model.Hubtype;
import com.sb.InquiryHub.repository.HubtypeRepository;

@Service
public class HubtypeService {

	@Autowired
	private HubtypeRepository hubtypeRepository;
	
	public List<Hubtype> getHubTypeList(){
		
		return hubtypeRepository.findAll();
	}
	
	public Optional<Hubtype> getHubTypeById(Integer id) {
		return hubtypeRepository.findById(id);
	}
	
	public Hubtype saveHubType(Hubtype hubtype) {
		Hubtype hubtypeData = hubtypeRepository.save(hubtype);
		return hubtypeData;
	}
	
}
