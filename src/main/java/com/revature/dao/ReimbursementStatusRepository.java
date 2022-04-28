package com.revature.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.revature.dto.DataChart;
import com.revature.models.Reimbursement;

public interface ReimbursementStatusRepository extends CrudRepository<Reimbursement, Integer>{
	
	@Query(nativeQuery=true, value="select reimb_status as label, COUNT(*) as count "
			+ "from Reimbursement "
			+ "GROUP BY reimb_status;")
	public List<DataChart> getReimbursementStatusCount();

}
