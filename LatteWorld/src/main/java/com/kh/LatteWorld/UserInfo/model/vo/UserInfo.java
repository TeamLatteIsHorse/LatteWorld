package com.kh.LatteWorld.UserInfo.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class UserInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3811422703713145395L;
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private String phone;
	private String userType;
	private String userStatus;
	private int point;
	private int itemPoint;	// 아이템 가격 차감시킬때 쓰이는 변수
	public UserInfo() {
	
	}
	public UserInfo(String userId, String userPwd, String userName, String email, String phone, String userType,
			String userStatus, int point, int itemPoint) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.userType = userType;
		this.userStatus = userStatus;
		this.point = point;
		this.itemPoint = itemPoint;
	}
	public UserInfo(String userId, String userPwd, String userName, String email, String phone, String userType,
			String userStatus, int point) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.userType = userType;
		this.userStatus = userStatus;
		this.point = point;
	}
	
	
	public int getItemPoint() {
		return itemPoint;
	}
	public void setItemPoint(int itemPoint) {
		this.itemPoint = itemPoint;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", email=" + email
				+ ", phone=" + phone + ", userType=" + userType + ", userStatus=" + userStatus + ", point=" + point
				+ ", itemPoint=" + itemPoint + "]";
	}
}
