package com.zhiyou100.service.impl;

import java.util.List;

import org.omg.DynamicAny.DynAnyOperations;

import com.zhiyou100.dao.UserDao;
import com.zhiyou100.dao.impl.UserDaoImpl;
import com.zhiyou100.entity.UserDo;
import com.zhiyou100.service.UserService;

public class UserServlceImpl implements UserService {
private UserDao dao =new UserDaoImpl();

@Override
public List<UserDo> ListUser() {
	List<UserDo> listUser = dao.listUser();
	return listUser;
}

@Override
public UserDo getUserById(long id) {
	UserDo userById = dao.getUserById(id);
	return userById;
}

@Override
public void addUser(String name, String password, String gender, String phone, String email, int department_id,
		int role_id,String description) {
	dao.addUser(name, password, gender, phone, email, department_id, role_id, description);
	
}

@Override
public void updateUser(long id,String name, String password, String gender, String phone, String email, int department_id,
		int role_id,String description) {
	dao.updateUser(id, name, password, gender, phone, email, department_id, role_id, description);
	
}

@Override
public void deleteUser(long id) {
	dao.deleteUser(id);
	
}

@Override
public List<UserDo> listUser(String column,String keyword) {
	return dao.listUser(column,keyword);
}

@Override
public List<UserDo> pageListUser(int pageIndex) {
	
	//return dao.listUser(pageIndex);
	return dao.listUser((pageIndex - 1)*5);
}

@Override
public int countPage() {
	int countUser = dao.countUser();
	return countUser;
}
	
}
