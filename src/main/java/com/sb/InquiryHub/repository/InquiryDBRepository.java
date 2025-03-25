package com.sb.InquiryHub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sb.InquiryHub.model.AssociateCompany;
import com.sb.InquiryHub.model.InquiryDB;

@Repository
public interface InquiryDBRepository extends JpaRepository<InquiryDB, Integer>{

	List<InquiryDB> findByInquiryHub(String hubtype);

	@Query(nativeQuery=true, value = "SELECT * from InquiryDB where inquiry_hub = :acName and inquiry_status = :status")
	List <InquiryDB> findInquiryDBByHubAndStatus(String acName, String status);

	@Query(nativeQuery=true, value = "SELECT * from InquiryDB where inquiry_hub = :acName")
	List <InquiryDB> findInquiryDBByHub(String acName);
	
}
