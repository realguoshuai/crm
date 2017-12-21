package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.entity.UserDo;

public interface UserDao {
	List<UserDo> listUser();

	UserDo getUserById(long id);

	void addUser(String name,String password,String gender,String phone,String email,int department_id, int role_id,String description);

	void updateUser(Long id,String name,String password,String gender,String phone,String email,int department_id, int role_id,String description);

	void deleteUser(long id);
	//搜索
	List<UserDo> listUser(String column,String keyword);
	
	//分页
	List<UserDo> listUser(int pageIndex);
	//总页数
	int countUser();
	
	UserDo getUser(String name);
}
