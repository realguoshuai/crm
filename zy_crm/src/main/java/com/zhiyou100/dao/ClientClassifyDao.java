package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.entity.ClientClassifyDo;
import com.zhiyou100.servlet.department.UpdateServlet;

public interface ClientClassifyDao {
	List<ClientClassifyDo> listClientClassify();
	
	ClientClassifyDo getlistByid(long id);

	void addClientClassify(String classifyName,String classifyDesc);

	void updateClientClassfify(String classifyName,String classifyDesc,long id);

	void deleteClientClassify(long id);
}
