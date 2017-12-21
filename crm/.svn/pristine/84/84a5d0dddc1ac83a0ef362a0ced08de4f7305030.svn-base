package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.entity.UserDo;

public interface UserService {
	List<UserDo> ListUser();
	UserDo getUserById(long id);
	void addUser(String name,String password,String gender,String phone,String email,int department_id, int role_id,String description);
	void updateUser(long id,String name,String password,String gender,String phone,String email,int department_id, int role_id,String description);
	void deleteUser(long id);
	
	/** 
	 * @Title: listUser 
	 * @Description: 搜索
	 * @param name
	 * @return
	 * @return: List<UserDo>
	 */
	List<UserDo> listUser(String column,String keyword);
	
	/** 
	 * @Title: pageListUser 
	 * @Description: 每页的页数
	 * @param pageIndex
	 * @return
	 * @return: List<UserDo>
	 */
	List<UserDo> pageListUser(int pageIndex);
	
	/** 
	 * @Title: countUser 
	 * @Description: 计算总页数
	 * @return
	 * @return: int
	 */
	int countPage();
}
