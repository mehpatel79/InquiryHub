package com.sb.InquiryHub.repository;



 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sb.InquiryHub.model.AssociateCompany;

@Repository
public interface AssociateCompanyRepository extends JpaRepository<AssociateCompany, Integer>{

	List<AssociateCompany> findByHubtypeId(Integer hubtypeId);

	@Query(nativeQuery=true, value = "SELECT * from AssociateCompany where hubtype_id = :hubtypeId")
	List <AssociateCompany> findAssociateCompanyByHubtypeId(Integer hubtypeId);
	
}
