package com.zhiyou100.entity;

import java.util.Date;

public class ClientClassifyDo {
	private long id;
	private String ClassifyName;
	private String ClassifyDesc;
	private Integer delete;
	private Date gmtCreate;
	private Date gmtModified;
	@Override
	public String toString() {
		return "ClientClassifyDo [id=" + id + ", ClassifyName=" + ClassifyName + ", ClassifyDesc=" + ClassifyDesc
				+ ", delete=" + delete + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
	public ClientClassifyDo() {
		super();
	}

	public ClientClassifyDo(long id, String classifyName, String classifyDesc, Date gmtModified) {
		super();
		this.id = id;
		ClassifyName = classifyName;
		ClassifyDesc = classifyDesc;
		this.gmtModified = gmtModified;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getClassifyName() {
		return ClassifyName;
	}
	public void setClassifyName(String classifyName) {
		ClassifyName = classifyName;
	}
	public String getClassifyDesc() {
		return ClassifyDesc;
	}
	public void setClassifyDesc(String classifyDesc) {
		ClassifyDesc = classifyDesc;
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
