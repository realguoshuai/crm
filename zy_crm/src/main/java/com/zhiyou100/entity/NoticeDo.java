package com.zhiyou100.entity;

import java.sql.Date;

public class NoticeDo {
	private Long id;
	private String title;
	private String content;
	private Date beginTime;
	private Date endTime;
	private Long userId;
	private String userName;
	private Long departmentId;
	private String departmentName;

	@Override
	public String toString() {
		return "NoticeDo [id=" + id + ", title=" + title + ", content=" + content + ", beginTime=" + beginTime
				+ ", endTime=" + endTime + ", userId=" + userId + ", userName=" + userName + ", departmentId="
				+ departmentId + ", departmentName=" + departmentName + "]";
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

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
