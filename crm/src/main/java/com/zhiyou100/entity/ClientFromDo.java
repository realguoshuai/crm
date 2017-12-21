package com.zhiyou100.entity;

import java.util.Date;

public class ClientFromDo {
	private long id;
	private String fromName;
	private String fromDesc;
	private Integer delete;
	private Date gmtCreate;
	private Date gmtModified;
	@Override
	public String toString() {
		return "ClientFromDo [id=" + id + ", fromName=" + fromName + ", fromDesc=" + fromDesc + ", delete=" + delete
				+ ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
	public ClientFromDo(long id, String fromName, String fromDesc, Date gmtModified) {
		super();
		this.id = id;
		this.fromName = fromName;
		this.fromDesc = fromDesc;
		this.gmtModified = gmtModified;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public String getFromDesc() {
		return fromDesc;
	}
	public void setFromDesc(String fromDesc) {
		this.fromDesc = fromDesc;
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
