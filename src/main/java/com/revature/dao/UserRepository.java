package com.revature.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.revature.models.ErsUser;
import com.revature.models.Reimbursement;


  public interface UserRepository extends CrudRepository<ErsUser, Integer>{
  
  @Override 
  public List<ErsUser> findAll();

  public ErsUser findByUserId(Integer userId);
  
  ErsUser findByUsername(String username);
  //public List<ErsUser> findByKeyword(String keyword);
  
 }
 