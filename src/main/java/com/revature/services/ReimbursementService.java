package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.dao.ReimbursementRepository;
import com.revature.models.Reimbursement;

@Service
public class ReimbursementService {
		
	@Autowired
	ReimbursementRepository reimRepo;
	
	
	public Reimbursement save(Reimbursement reimbursement) {
		return reimRepo.save(reimbursement);
	}

	public Reimbursement findByReimbId(Integer reimbId) {
		return reimRepo.findByReimbId(reimbId);
	}

	public List<Reimbursement> getAll() {
		return reimRepo.findAll();
	}

    public void delete(Reimbursement reimbId) {
    	reimRepo.delete(reimbId);
		
	}
    
    public List<Reimbursement> findByKeyword(String keyword){
		  return reimRepo.findByKeyword(keyword);
		 }
    public List<Reimbursement> findByReimbStatus(String keyword){
    	return reimRepo.findByReimbStatus(keyword);
    }
}
