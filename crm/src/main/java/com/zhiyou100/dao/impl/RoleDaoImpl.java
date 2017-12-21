package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.relation.Role;

import com.zhiyou100.dao.RoleDao;
import com.zhiyou100.entity.RoleDo;
import com.zhiyou100.util.DBUtil;

public class RoleDaoImpl implements RoleDao {
	@Override
	public List<RoleDo> listRole() {
		ArrayList<RoleDo> list = new ArrayList<RoleDo>();
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "SELECT id,name,description,gmt_modified FROM role WHERE is_delete = 0;";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				ResultSet resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					long id = resultSet.getLong("id");
					String name = resultSet.getString("name");
					String description = resultSet.getString("description");
					Date gmtModified = resultSet.getDate("gmt_modified");
					RoleDo object = new RoleDo(id, name, description, gmtModified);
					list.add(object);
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
	public void addRole(String name, String description) {
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "INSERT INTO role (name,description) values(?,?);";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setString(1, name);
				prepareStatement.setString(2, description);
				prepareStatement.executeUpdate();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateRole(Long id,String name, String description) {
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "UPDATE role SET name = ?,description = ? where id = ?;";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setString(1, name);
				prepareStatement.setString(2, description);
				prepareStatement.setLong(3, id);
				prepareStatement.executeUpdate();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zhiyou100.dao.RoleDao#removeRole(long) 实际上是一个更新语句 修改is_delete
	 * 状态为1
	 */
	@Override
	public void removeRole(long id) {
		
		try(Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql ="UPDATE  role SET is_delete=1 where id= ? ;";
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
	public RoleDo getRoleById(long id) {
		RoleDo roleDo = null;
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "SELECT name,description,gmt_modified FROM role WHERE id = ?;";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setLong(1, id);
				try(ResultSet resultSet = prepareStatement.executeQuery();){
					while(resultSet.next()){
						//取出每列属性
						String name= resultSet.getString("name");
						String description= resultSet.getString("description");
						Date gmtModified = resultSet.getDate("gmt_modified");
						roleDo = new RoleDo(id, name, description, gmtModified);
					}
				}
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roleDo;
	}

}
