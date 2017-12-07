package com.zhiyou100.entity;

import java.util.Date;

public class DepartmentDo {
private long id;
private String name;
private String description;
private Integer delete;
private Date gmtCreate;
private Date gmtModified;
@Override
public String toString() {
	return "DepartmentDo [id=" + id + ", name=" + name + ", description=" + description + ", delete=" + delete
			+ ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
}
public DepartmentDo() {
	super();
}
public DepartmentDo(long id, String name, String description, Date gmtModified) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.gmtModified = gmtModified;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
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
