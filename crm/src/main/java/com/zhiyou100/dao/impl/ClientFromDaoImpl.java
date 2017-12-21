package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.dao.ClientFromDao;
import com.zhiyou100.entity.ClientClassifyDo;
import com.zhiyou100.entity.ClientFromDo;
import com.zhiyou100.util.DBUtil;

public class ClientFromDaoImpl implements ClientFromDao {

	@Override
	public List<ClientFromDo> listClientFrom() {
		List<ClientFromDo> list = new ArrayList<>();
		try(Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "SELECT id ,from_name,from_desc,gmt_modified from client_from WHERE is_delete = 0";
			try(PreparedStatement prepareStatement = connection.prepareStatement(sql);){
				try(ResultSet resultSet = prepareStatement.executeQuery();){
					while (resultSet.next()) {
						long id = resultSet.getLong("id");
						String classifyName = resultSet.getString("from_name");
						String classifyDesc = resultSet.getString("from_desc");
						Date gmtModified = resultSet.getDate("gmt_modified");
						ClientFromDo fromDo =new ClientFromDo(id, classifyName, classifyDesc, gmtModified);
						list.add(fromDo);
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
	public void addClientFrom(String fromName, String fromDesc) {
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "INSERT INTO client_from (from_name,from_desc) values(?,?);";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setString(1, fromName);
				prepareStatement.setString(2, fromDesc);
				prepareStatement.executeUpdate();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateClientFrom(String fromName, String fromDesc, long id) {
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "UPDATE client_from SET from_name=?,from_desc=? WHERE id =?;";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setString(1, fromName);
				prepareStatement.setString(2, fromDesc);
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
	public void deleteClientFrom(long id) {
		try(Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql ="UPDATE  client_from SET is_delete=1 where id= ? ;";
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
	public ClientFromDo getlistByid(long id) {
		ClientFromDo fromDo = null;
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "SELECT from_name,from_desc,gmt_modified FROM client_from WHERE id = ?;";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setLong(1, id);
				try(ResultSet resultSet = prepareStatement.executeQuery();){
					while(resultSet.next()){
						//取出每列属性
						String name= resultSet.getString("from_name");
						String description= resultSet.getString("from_desc");
						Date gmtModified = resultSet.getDate("gmt_modified");
						fromDo = new ClientFromDo(id, name, description, gmtModified);
					}
				}
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fromDo;
	}

}
