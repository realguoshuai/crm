package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.entity.ClientStatusDo;

public interface ClientStatusDao {
	List<ClientStatusDo> listClientStatus();

	void addClientStatus(String statusName, String statusDesc);

	void updateClientStatus(String statusName, String statusDesc, long id);

	void deleteClientStatus(long id);
	
	ClientStatusDo getlistByid(long id);

}
