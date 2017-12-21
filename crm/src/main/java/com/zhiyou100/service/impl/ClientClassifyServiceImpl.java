package com.zhiyou100.service.impl;

import java.io.DataOutput;
import java.util.List;

import com.zhiyou100.dao.ClientClassifyDao;
import com.zhiyou100.dao.impl.ClientClassifyDaoImpl;
import com.zhiyou100.entity.ClientClassifyDo;
import com.zhiyou100.service.ClientClassifyService;

public class ClientClassifyServiceImpl implements ClientClassifyService {
private ClientClassifyDao dao =new ClientClassifyDaoImpl();
	@Override
	public List<ClientClassifyDo> listClientClassify() {
		
		return dao.listClientClassify();
	}

	@Override
	public void addClientClassify(String classifyName, String classifyDesc) {
		
		dao.addClientClassify(classifyName, classifyDesc);
		
	}

	@Override
	public void updateClientClassfify(String classifyName, String classifyDesc, long id) {
		
		dao.updateClientClassfify(classifyName, classifyDesc, id);
	}

	@Override
	public void deleteClientClassify(long id) {
		
		dao.deleteClientClassify(id);
	}

	@Override
	public ClientClassifyDo getlistByid(long id) {
		
		return dao.getlistByid(id);
	}

}
