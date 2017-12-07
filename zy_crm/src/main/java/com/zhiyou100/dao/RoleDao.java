package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.entity.RoleDo;

/** 
 * @ClassName: RoleDao 
 * @Description: 对Role表的操作接口
 * @author: guoshuai
 * @date: 2017年12月4日 下午4:10:18  
 */
public interface RoleDao {
  /** 
 * @Title: listRole 
 * @Description: 展示角色
 * @return
 * @return: List<RoleDo>
 */
List<RoleDo>listRole();
/** 
 * @Title: getRoleById 
 * @Description: 根据id获取角色信息
 * @param id
 * @return
 * @return: RoleDo
 */
RoleDo getRoleById(long id);
  /** 
 * @Title: addRole 
 * @Description:增加角色
 * @param name
 * @param decsription
 * @return: void
 */
void addRole(String name,String description);
  /** 
 * @Title: updateRole 
 * @Description: 更新角色
 * @param name
 * @param id
 * @param description
 * @return: void
 */
void updateRole(Long id,String name,String description);

/** 
 * @Title: removeRole 
 * @Description: 删除角色
 * @param id
 * @return: void
 */
void removeRole(long id);
}
