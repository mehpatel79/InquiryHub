package com.sb.InquiryHub.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sb.InquiryHub.model.Hubtype;

@Repository
public interface HubtypeRepository extends JpaRepository<Hubtype, Integer>{

	/*
		@Query("SELECT a, b FROM Hubtype a JOIN a.AssociateCompany b")
    	List<Object[]> findHubtypeAssociateCompanyJoin();
	*/
	
}
