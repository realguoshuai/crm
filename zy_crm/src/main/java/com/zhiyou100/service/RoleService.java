package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.entity.RoleDo;

/** 
 * 角色模块接口
 * @author: guoshuai
 * @date: 2017年12月4日 下午3:49:47  
 */
public interface RoleService {
	/** 
	 * @Title: listRole 
	 * @Description: 获取角色列表
	 * @return 角色信息列表
	 * @return: List<RoleDo>
	 */
	List<RoleDo> listRole();

	/** 
	 * @Title: getRoleById 
	 * @Description:根据id查询RoleDo
	 * @param id
	 * @return
	 * @return: RoleDo
	 */
	RoleDo getRoleById(long id);
	/** 
	 * @Title: addRole 
	 * @Description:添加角色
	 * @param name 角色名称
	 * @param description 角色描述
	 * @return: void
	 */
	
	void addRole(String name,String description);
	/** 
	 * @Title: updateRole 
	 * @Description: 修改角色
	 * @param id 角色id
	 * @param name 修改名称
	 * @param description 修改描述
	 * @return: void
	 */
	void updateRole(Long id,String name,String description);

	/** 
	 * @Title: deleteRole 
	 * @Description: 删除角色
	 * @param id 角色id
	 * @return: void
	 */
	void deleteRole(long id);
}
