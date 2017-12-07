package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.RoleDao;
import com.zhiyou100.dao.impl.RoleDaoImpl;
import com.zhiyou100.entity.RoleDo;
import com.zhiyou100.service.RoleService;

public class RoleServiceImpl implements RoleService {
private RoleDao dao =new RoleDaoImpl();
	@Override
	public List<RoleDo> listRole() {
		return dao.listRole();
	}

	@Override
	public void addRole(String name, String description) {
		dao.addRole(name, description);
	}

	@Override
	public void updateRole(Long id, String name, String description) {
		dao.updateRole(id, name, description);
	}

	@Override
	public void deleteRole(long id) {
		dao.removeRole(id);
	}

	@Override
	public RoleDo getRoleById(long id) {
		return dao.getRoleById(id);
	}

}
