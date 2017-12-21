package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.ClientStatusDao;
import com.zhiyou100.dao.impl.ClientStatusDaoImpl;
import com.zhiyou100.entity.ClientStatusDo;
import com.zhiyou100.service.ClientStatusService;

public class ClientStatusServiceImpl implements ClientStatusService {
	private ClientStatusDao dao = new ClientStatusDaoImpl();

	@Override
	public List<ClientStatusDo> listClientStatus() {
		
		return dao.listClientStatus();
	}

	@Override
	public void addClientStatus(String statusName, String statusDesc) {
		
		dao.addClientStatus(statusName, statusDesc);
	}

	@Override
	public void updateClientStatus(String statusName, String statusDesc, long id) {
		
		dao.updateClientStatus(statusName, statusDesc, id);
	}

	@Override
	public void deleteClientStatus(long id) {
		
		dao.deleteClientStatus(id);
	}

	@Override
	public ClientStatusDo getlistByid(long id) {
		
		return dao.getlistByid(id);
	}

}
