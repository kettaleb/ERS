package com.revature.models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

@Entity
public class Reimbursement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reimbId; //Reimbursement ID is auto-increment in the database
	
	//@DecimalMax("10.0") @DecimalMin("0.0")
	private double reimbAmount; //Reimbursement amount
	
	private String reimbType; //Reimbursement type: LODGING, FOOD, TRAVEL
	
	private LocalDateTime reimCreationDate; //Reimbursement create date hidden field
	
	private String reimbDescription; //Reimbursement description details
	private String reimbStatus = "Pending"; //Reimbursement status: Pending, Approved, Denied
	private String reimbApprovalReason; //Message explaining why a reimbursement is pending or denied
	private LocalDateTime reimApprovalDate; //Reimbursement approval date hidden field
	
	//Relation between ErsUser and Reimbursement entity
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE,CascadeType.REFRESH, CascadeType.PERSIST}, fetch=FetchType.LAZY)		 
	@JoinColumn(name="user_id")
	private ErsUser ersUser;

	
	
	//No-argument constructor
	public Reimbursement() {
		
	}


	//Constructor with arguments
	public Reimbursement(double reimbAmount, String reimbType, LocalDateTime reimCreationDate, String reimbDescription,
			String reimbStatus, String reimbApprovalReason, LocalDateTime reimApprovalDate, ErsUser ersUser) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbType = reimbType;
		this.reimCreationDate = reimCreationDate;
		this.reimbDescription = reimbDescription;
		this.reimbStatus = reimbStatus;
		this.reimbApprovalReason = reimbApprovalReason;
		this.reimApprovalDate = reimApprovalDate;
		this.ersUser = ersUser;
	}


	public int getReimbId() {
		return reimbId;
	}


	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}


	public double getReimbAmount() {
		return reimbAmount;
	}


	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}


	public String getReimbType() {
		return reimbType;
	}


	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}


	public LocalDateTime getReimCreationDate() {
		return reimCreationDate;
	}


	public void setReimCreationDate(LocalDateTime reimCreationDate) {
		this.reimCreationDate = reimCreationDate;
	}


	public String getReimbDescription() {
		return reimbDescription;
	}


	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}


	public String getReimbStatus() {
		return reimbStatus;
	}


	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}


	public String getReimbApprovalReason() {
		return reimbApprovalReason;
	}


	public void setReimbApprovalReason(String reimbApprovalReason) {
		this.reimbApprovalReason = reimbApprovalReason;
	}


	public LocalDateTime getReimApprovalDate() {
		return reimApprovalDate;
	}


	public void setReimApprovalDate(LocalDateTime reimApprovalDate) {
		this.reimApprovalDate = reimApprovalDate;
	}

	public ErsUser getErsUser() {
		return ersUser;
	}


	public void setErsUser(ErsUser ersUser) {
		this.ersUser = ersUser;
	}
	
	@PrePersist
	void createdAt() {
		this.reimCreationDate = LocalDateTime.now();
	}

	
	@PreUpdate
	void approvedAt() {
		this.reimApprovalDate = LocalDateTime.now();
	}

	
}
