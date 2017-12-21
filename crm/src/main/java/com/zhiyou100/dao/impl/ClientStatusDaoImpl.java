package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.dao.ClientStatusDao;
import com.zhiyou100.entity.ClientClassifyDo;
import com.zhiyou100.entity.ClientStatusDo;
import com.zhiyou100.util.DBUtil;

public class ClientStatusDaoImpl implements ClientStatusDao {

	@Override
	public List<ClientStatusDo> listClientStatus() {
		List<ClientStatusDo> list = new ArrayList<>();
		try(Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "SELECT id ,status_name,status_desc,gmt_modified from client_status WHERE is_delete = 0";
			try(PreparedStatement prepareStatement = connection.prepareStatement(sql);){
				try(ResultSet resultSet = prepareStatement.executeQuery();){
					while (resultSet.next()) {
						long id = resultSet.getLong("id");
						String statusName = resultSet.getString("status_name");
						String statusDesc = resultSet.getString("status_desc");
						Date gmtModified = resultSet.getDate("gmt_modified");
						ClientStatusDo statusDo =new ClientStatusDo(id, statusName, statusDesc, gmtModified);
						list.add(statusDo);
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
	public void addClientStatus(String statusName, String statusDesc) {
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "INSERT INTO client_status (status_name,status_desc) values(?,?);";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setString(1, statusName);
				prepareStatement.setString(2, statusDesc);
				prepareStatement.executeUpdate();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateClientStatus(String statusName, String statusDesc, long id) {
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "UPDATE client_status SET status_name=?,status_desc=? WHERE id =?;";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setString(1, statusName);
				prepareStatement.setString(2, statusDesc);
				prepareStatement.setLong(3, id);
				
				prepareStatement.executeUpdate();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteClientStatus(long id) {
		try(Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql ="UPDATE  client_status SET is_delete=1 where id= ? ;";
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
	public ClientStatusDo getlistByid(long id) {
		ClientStatusDo clientStatusDo = null;
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "SELECT status_name,status_desc,gmt_modified FROM client_status WHERE id = ?;";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setLong(1, id);
				try(ResultSet resultSet = prepareStatement.executeQuery();){
					while(resultSet.next()){
						//取出每列属性
						String name= resultSet.getString("status_name");
						String description= resultSet.getString("status_desc");
						Date gmtModified = resultSet.getDate("gmt_modified");
						clientStatusDo = new ClientStatusDo(id, name, description, gmtModified);
					}
				}
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientStatusDo;
	}

}
