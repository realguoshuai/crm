package com.zhiyou100.entity;

import java.util.Date;

public class ClientStatusDo {
	private long id;
	private String statusName;
	private String statusDesc;
	private Integer delete;
	private Date gmtCreate;
	private Date gmtModified;

	@Override
	public String toString() {
		return "ClientStatusDo [id=" + id + ", statusName=" + statusName + ", statusDesc=" + statusDesc + ", delete="
				+ delete + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}

	public ClientStatusDo(long id, String statusName, String statusDesc, Date gmtModified) {
		super();
		this.id = id;
		this.statusName = statusName;
		this.statusDesc = statusDesc;
		this.gmtModified = gmtModified;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public Integer getDelete() {
		return delete;
	}

	public void setDelete(Integer delete) {
		this.delete = delete;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

}
