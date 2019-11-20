package com.kh.LatteWorld.bestFriend.model.vo;

import java.io.Serializable;

public class bfSearchCondition implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2141008203142041029L;
	private String bfType;
	private String bfId;
	private String bfAll;
	private String bfName;
	private String bfValue;
	public bfSearchCondition() {
	}
	public bfSearchCondition(String bfType, String bfValue) {
		super();
		this.bfType = bfType;
		this.bfValue = bfValue;
	}

	public String getBfType() {
		return bfType;
	}
	public String getBfId() {
		return bfId;
	}
	public void setBfId(String bfId) {
		this.bfId = bfId;
	}
	public String getBfName() {
		return bfName;
	}
	public void setBfName(String bfName) {
		this.bfName = bfName;
	}
	public void setBfType(String bfType) {
		this.bfType = bfType;
	}
	public String getBfValue() {
		return bfValue;
	}
	public void setBfValue(String bfValue) {
		this.bfValue = bfValue;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getBfAll() {
		return bfAll;
	}
	public void setBfAll(String bfAll) {
		this.bfAll = bfAll;
	}
	@Override
	public String toString() {
		return "bfSearchCondition [bfType=" + bfType + ", bfId=" + bfId + ", bfAll=" + bfAll + ", bfName=" + bfName
				+ ", bfValue=" + bfValue + "]";
	}
	

	
}
