package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.entity.ClientClassifyDo;

public interface ClientClassifyService {
	List<ClientClassifyDo> listClientClassify();

	void addClientClassify(String classifyName, String classifyDesc);

	void updateClientClassfify(String classifyName, String classifyDesc, long id);

	void deleteClientClassify(long id);
	
	ClientClassifyDo getlistByid(long id);
	
	
}
