package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.dao.UserDao;
import com.zhiyou100.entity.UserDo;
import com.zhiyou100.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public List<UserDo> listUser() {
		List<UserDo> list =new ArrayList<>();
		try(Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "SELECT id ,name,department_id,role_id,phone,email,gmt_modified from user WHERE is_delete = 0";
			try(PreparedStatement prepareStatement = connection.prepareStatement(sql);){
				try(ResultSet resultSet = prepareStatement.executeQuery();){
					while (resultSet.next()) {
						long id = resultSet.getLong("id");
						String name = resultSet.getString("name");
						int departmentId = resultSet.getInt("department_id");
						int roleId = resultSet.getInt("role_id");
						String phone = resultSet.getString("phone");
						String eMail = resultSet.getString("email");
						Date gmtModified = resultSet.getDate("gmt_modified");
						UserDo userDo = new UserDo(id, name, phone, eMail, departmentId, roleId, gmtModified);
						list.add(userDo);
				    }
					
				}
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public UserDo getUserById(long id) {
		UserDo userDo = null;
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "SELECT name,department_id,role_id,phone,email,gmt_modified FROM user WHERE id = ?;";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setLong(1, id);
				try(ResultSet resultSet = prepareStatement.executeQuery();){
					while(resultSet.next()){
						//取出每列属性
						String name =resultSet.getString("name");
						int departmentId =resultSet.getInt("department_id");
						int roleId =resultSet.getInt("role_id");
						String phone =resultSet.getString("phone");
						String eMail =resultSet.getString("email");
						Date gmtModified =resultSet.getDate("gmt_modified");
						userDo = new UserDo(id, name, phone, eMail, departmentId, roleId, gmtModified);
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userDo;
	}

	@Override
	public void addUser(String name,String password,String gender,String phone,String email,int department_id, int role_id,String description) {
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "INSERT INTO user (name,password,gender,phone,email,department_id,role_id,description) values(?,?,?,?,?,?,?,?);";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setString(1, name);
				prepareStatement.setString(2, password);
				prepareStatement.setString(3, gender);
				prepareStatement.setString(4, phone);
				prepareStatement.setString(5,email );
				prepareStatement.setInt(6, department_id);
				prepareStatement.setInt(7, role_id);
				prepareStatement.setString(8,description);
				prepareStatement.executeUpdate();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateUser(Long id,String name,String password,String gender,String phone,String email,int department_id, int role_id,String description) {
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "UPDATE user SET name=?,password=?,department_id=?,role_id=?,gender=?,phone=?,email=?,description=? WHERE id =?;";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setString(1, name);
				prepareStatement.setString(2, password);
				prepareStatement.setInt(3, department_id);
				prepareStatement.setInt(4, role_id);
				prepareStatement.setString(5, gender);
				prepareStatement.setString(6, phone);
				prepareStatement.setString(7, email);
				prepareStatement.setString(8, description);
				prepareStatement.setLong(9, id);
				prepareStatement.executeUpdate();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(long id) {

		try(Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql ="UPDATE  user SET is_delete=1 where id= ? ;";
			try(PreparedStatement prepareStatement = connection.prepareStatement(sql);){
				prepareStatement.setLong(1, id);
				prepareStatement.executeUpdate();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<UserDo> listUser(String column,String keyword) {
		ArrayList<UserDo> list = new ArrayList<UserDo>();

		try (Connection conn = DBUtil.INSTANCE.getConnection();){

			String sql = String.format(
			"SELECT id,name,department_id,role_id,phone,email,gmt_modified FROM user WHERE %s like ?"
			   + " and is_delete = 0 ;", column);

			try (PreparedStatement preparedStatement = conn.prepareStatement(sql);) {
				preparedStatement.setString(1,"%"+keyword+"%");

				try (ResultSet rs = preparedStatement.executeQuery();) {
					while (rs.next()) {
						long id =rs.getLong("id");
						String name = rs.getString("name");
						int departmentId = rs.getInt("department_id");
						int roleId = rs.getInt("role_id");
						String phone = rs.getString("phone");
						String email = rs.getString("email");
						Date introduction = rs.getDate("gmt_modified");
						UserDo object = new UserDo(id,name, phone, email, departmentId, roleId,introduction);
						list.add(object);
					}
				}
			}
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

		return list;
	}
	@Override
	public List<UserDo> listUser(int pageIndex) {
		List<UserDo> list = new ArrayList<>();
		
		try(Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "SELECT id,name,department_id,role_id,phone,email,gmt_modified FROM user LIMIT ?,5";
			try(PreparedStatement prepareStatement = connection.prepareStatement(sql);){
				prepareStatement.setInt(1, pageIndex);
				try(ResultSet rs = prepareStatement.executeQuery();){
					while(rs.next()){
						long id =rs.getLong("id");
						String name = rs.getString("name");
						int departmentId = rs.getInt("department_id");
						int roleId = rs.getInt("role_id");
						String phone = rs.getString("phone");
						String email = rs.getString("email");
						Date introduction = rs.getDate("gmt_modified");
						UserDo object = new UserDo(id,name, phone, email, departmentId, roleId,introduction);
						list.add(object);
					}
				}
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int countUser() {
		int count = 0;
		
		try (Connection conn = DBUtil.INSTANCE.getConnection();){

			String sql = "SELECT count(*) FROM user;";

			try (PreparedStatement preparedStatement = conn.prepareStatement(sql);

					ResultSet rs = preparedStatement.executeQuery();) {

				while (rs.next()) {

					count = rs.getInt(1);
				}
			}
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}
		
		return count;		
	}

}
