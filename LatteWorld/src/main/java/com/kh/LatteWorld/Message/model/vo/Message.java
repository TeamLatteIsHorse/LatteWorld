package com.kh.LatteWorld.Message.model.vo;

import java.sql.Date;

public class Message {
	private int messageNo;
	private String sendId;
	private String receiveId;
	private String messageContent;
	private String messageStatus;
	private String eraseStatus;
	private Date sendDate;
	public Message() {
		super();
	}
	public Message(int messageNo, String sendId, String receiveId, String messageContent, String messageStatus,
			String eraseStatus, Date sendDate) {
		super();
		this.messageNo = messageNo;
		this.sendId = sendId;
		this.receiveId = receiveId;
		this.messageContent = messageContent;
		this.messageStatus = messageStatus;
		this.eraseStatus = eraseStatus;
		this.sendDate = sendDate;
	}
	public int getMessageNo() {
		return messageNo;
	}
	public void setMessageNo(int messageNo) {
		this.messageNo = messageNo;
	}
	public String getSendId() {
		return sendId;
	}
	public void setSendId(String sendId) {
		this.sendId = sendId;
	}
	public String getReceiveId() {
		return receiveId;
	}
	public void setReceiveId(String receiveId) {
		this.receiveId = receiveId;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public String getMessageStatus() {
		return messageStatus;
	}
	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}
	public String getEraseStatus() {
		return eraseStatus;
	}
	public void setEraseStatus(String eraseStatus) {
		this.eraseStatus = eraseStatus;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	@Override
	public String toString() {
		return "Message [messageNo=" + messageNo + ", sendId=" + sendId + ", receiveId=" + receiveId
				+ ", messageContent=" + messageContent + ", messageStatus=" + messageStatus + ", eraseStatus="
				+ eraseStatus + ", sendDate=" + sendDate + "]";
	}
	
}