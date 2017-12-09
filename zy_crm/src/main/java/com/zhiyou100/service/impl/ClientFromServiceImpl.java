package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.ClientFromDao;
import com.zhiyou100.dao.impl.ClientFromDaoImpl;
import com.zhiyou100.entity.ClientFromDo;
import com.zhiyou100.service.ClientFromService;

public class ClientFromServiceImpl implements ClientFromService {
	private ClientFromDao dao = new ClientFromDaoImpl();

	@Override
	public List<ClientFromDo> listClientFrom() {
		
		return dao.listClientFrom();
	}

	@Override
	public void addClientFrom(String fromName, String fromDesc) {
		
		dao.addClientFrom(fromName, fromDesc);
	}

	@Override
	public void updateClientFrom(String fromName, String fromDesc, long id) {
		
		dao.updateClientFrom(fromName, fromDesc, id);
	}

	@Override
	public void deleteClientFrom(long id) {
		
		dao.deleteClientFrom(id);
	}

	@Override
	public ClientFromDo getlistByid(long id) {
		
		return dao.getlistByid(id);
	}

}
