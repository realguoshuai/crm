package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.entity.ClientFromDo;

public interface ClientFromDao {
	List<ClientFromDo> listClientFrom();

	void addClientFrom(String fromName, String fromDesc);

	void updateClientFrom(String fromName, String fromDesc, long id);

	void deleteClientFrom(long id);
	
	ClientFromDo getlistByid(long id);
}
