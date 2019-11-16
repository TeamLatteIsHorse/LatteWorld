package com.kh.LatteWorld.UserInfo.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class UserInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3811422703713145395L;
	
	private String userId;
	private String minihomeCode;
	private String userPwd;
	private String userName;
	private int userType;
	private String userStatus;
	private Date registerDate;
	private int zat;
	private int reportCount;
	public UserInfo() {
	 
	}
	public UserInfo(String userId, String minihomeCode, String userPwd, String userName, int userType,
			String userStatus, Date registerDate, int zat, int reportCount) {
		super();
		this.userId = userId;
		this.minihomeCode = minihomeCode;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userType = userType;
		this.userStatus = userStatus;
		this.registerDate = registerDate;
		this.zat = zat;
		this.reportCount = reportCount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMinihomeCode() {
		return minihomeCode;
	}
	public void setMinihomeCode(String minihomeCode) {
		this.minihomeCode = minihomeCode;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public int getZat() {
		return zat;
	}
	public void setZat(int zat) {
		this.zat = zat;
	}
	public int getReportCount() {
		return reportCount;
	}
	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", minihomeCode=" + minihomeCode + ", userPwd=" + userPwd + ", userName="
				+ userName + ", userType=" + userType + ", userStatus=" + userStatus + ", registerDate=" + registerDate
				+ ", zat=" + zat + ", reportCount=" + reportCount + "]";
	}
	}
