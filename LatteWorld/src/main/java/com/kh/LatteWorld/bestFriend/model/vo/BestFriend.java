package com.kh.LatteWorld.bestFriend.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class BestFriend implements Serializable{

	private int bfNo;
	private String bfApplyId;
	private String bfAppliedId;
	private String bfStatus;
	private String bfComments;
	private Date bfDate;
	private Date bfConfirmDate;
	public BestFriend() {
	
	}
	public BestFriend(int bfNo, String bfApplyId, String bfAppliedId, String bfStatus, String bfComments, Date bfDate,
			Date bfConfirmDate) {
		super();
		this.bfNo = bfNo;
		this.bfApplyId = bfApplyId;
		this.bfAppliedId = bfAppliedId;
		this.bfStatus = bfStatus;
		this.bfComments = bfComments;
		this.bfDate = bfDate;
		this.bfConfirmDate = bfConfirmDate;
	}
	public int getBfNo() {
		return bfNo;
	}
	public void setBfNo(int bfNo) {
		this.bfNo = bfNo;
	}
	public String getBfApplyId() {
		return bfApplyId;
	}
	public void setBfApplyId(String bfApplyId) {
		this.bfApplyId = bfApplyId;
	}
	public String getBfAppliedId() {
		return bfAppliedId;
	}
	public void setBfAppliedId(String bfAppliedId) {
		this.bfAppliedId = bfAppliedId;
	}
	public String getBfStatus() {
		return bfStatus;
	}
	public void setBfStatus(String bfStatus) {
		this.bfStatus = bfStatus;
	}
	public String getBfComments() {
		return bfComments;
	}
	public void setBfComments(String bfComments) {
		this.bfComments = bfComments;
	}
	public Date getBfDate() {
		return bfDate;
	}
	public void setBfDate(Date bfDate) {
		this.bfDate = bfDate;
	}
	public Date getBfConfirmDate() {
		return bfConfirmDate;
	}
	public void setBfConfirmDate(Date bfConfirmDate) {
		this.bfConfirmDate = bfConfirmDate;
	}
	@Override
	public String toString() {
		return "BestFriend [bfNo=" + bfNo + ", bfApplyId=" + bfApplyId + ", bfAppliedId=" + bfAppliedId + ", bfStatus="
				+ bfStatus + ", bfComments=" + bfComments + ", bfDate=" + bfDate + ", bfConfirmDate=" + bfConfirmDate
				+ "]";
	}
	
	
	
	
	
	
	
}
