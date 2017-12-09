package com.zhiyou100.entity;

import java.sql.Timestamp;

public class EmailDO {
	private Long id;

	private String title;

	private String content;

	private Long sendUserId;

	private String sendUserName;

	private Long receiveUserId;

	private String receiceUserName;

	private Timestamp sendTime;

	private int sendLocation;

	private int receiveLocation;

	@Override
	public String toString() {
		return "EmailDo [id=" + id + ", title=" + title + ", content=" + content + ", sendUserId=" + sendUserId
				+ ", sendUserName=" + sendUserName + ", receiveUserId=" + receiveUserId + ", receiceUserName="
				+ receiceUserName + ", sendTime=" + sendTime + ", sendLocation=" + sendLocation + ", receiveLocation="
				+ receiveLocation + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getSendUserId() {
		return sendUserId;
	}

	public void setSendUserId(Long sendUserId) {
		this.sendUserId = sendUserId;
	}

	public String getSendUserName() {
		return sendUserName;
	}

	public void setSendUserName(String sendUserName) {
		this.sendUserName = sendUserName;
	}

	public Long getReceiveUserId() {
		return receiveUserId;
	}

	public void setReceiveUserId(Long receiveUserId) {
		this.receiveUserId = receiveUserId;
	}

	public String getReceiceUserName() {
		return receiceUserName;
	}

	public void setReceiceUserName(String receiceUserName) {
		this.receiceUserName = receiceUserName;
	}

	public Timestamp getSendTime() {
		return sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public int getSendLocation() {
		return sendLocation;
	}

	public void setSendLocation(int sendLocation) {
		this.sendLocation = sendLocation;
	}

	public int getReceiveLocation() {
		return receiveLocation;
	}

	public void setReceiveLocation(int receiveLocation) {
		this.receiveLocation = receiveLocation;
	}

}
