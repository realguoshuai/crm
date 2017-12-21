package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.entity.ClientFromDo;

public interface ClientFromService {
	List<ClientFromDo> listClientFrom();

	void addClientFrom(String fromName, String fromDesc);

	void updateClientFrom(String fromName, String fromDesc, long id);

	void deleteClientFrom(long id);
	
	ClientFromDo getlistByid(long id);
	
}
