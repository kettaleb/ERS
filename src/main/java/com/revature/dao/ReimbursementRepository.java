package com.revature.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.revature.models.Reimbursement;

public interface ReimbursementRepository extends CrudRepository<Reimbursement, Integer>{

	@Override 
	  public List<Reimbursement> findAll();

	  public Reimbursement findByReimbId(Integer reimbId);
	  
	  @Query(value = "select * from reimbursement r where r.reimb_status like %:keyword%", nativeQuery = true)
	  public List<Reimbursement> findByKeyword(@Param("keyword") String keyword);
	  
	  public List<Reimbursement> findByReimbStatus(String status);
}
