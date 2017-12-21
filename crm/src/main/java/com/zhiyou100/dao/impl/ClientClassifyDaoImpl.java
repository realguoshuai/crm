package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.dao.ClientClassifyDao;
import com.zhiyou100.entity.ClientClassifyDo;
import com.zhiyou100.entity.RoleDo;
import com.zhiyou100.entity.UserDo;
import com.zhiyou100.util.DBUtil;

public class ClientClassifyDaoImpl implements ClientClassifyDao {

	@Override
	public List<ClientClassifyDo> listClientClassify() {
		List<ClientClassifyDo> list = new ArrayList<>();
		try(Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "SELECT id ,classify_name,classify_desc,gmt_modified from client_classify WHERE is_delete = 0";
			try(PreparedStatement prepareStatement = connection.prepareStatement(sql);){
				try(ResultSet resultSet = prepareStatement.executeQuery();){
					while (resultSet.next()) {
						long id = resultSet.getLong("id");
						String classifyName = resultSet.getString("classify_name");
						String classifyDesc = resultSet.getString("classify_desc");
						Date gmtModified = resultSet.getDate("gmt_modified");
						ClientClassifyDo classifyDo =new ClientClassifyDo(id, classifyName, classifyDesc, gmtModified);
						list.add(classifyDo);
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
	public void addClientClassify(String classifyName,String classifyDesc) {
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "INSERT INTO client_classify (classify_name,classify_desc) values(?,?);";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setString(1, classifyName);
				prepareStatement.setString(2, classifyDesc);
				prepareStatement.executeUpdate();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateClientClassfify(String classifyName,String classifyDesc,long id) {
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "UPDATE client_classify SET classify_name=?,classify_desc=? WHERE id =?;";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setString(1, classifyName);
				prepareStatement.setString(2, classifyDesc);
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
	public void deleteClientClassify(long id) {
		try(Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql ="UPDATE  client_classify SET is_delete=1 where id= ? ;";
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
	public ClientClassifyDo getlistByid(long id) {
		ClientClassifyDo classifyDo = null;
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "SELECT classify_name,classify_desc,gmt_modified FROM client_classify WHERE id = ?;";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setLong(1, id);
				try(ResultSet resultSet = prepareStatement.executeQuery();){
					while(resultSet.next()){
						//取出每列属性
						String name= resultSet.getString("classify_name");
						String description= resultSet.getString("classify_desc");
						Date gmtModified = resultSet.getDate("gmt_modified");
						classifyDo = new ClientClassifyDo(id, name, description, gmtModified);
					}
				}
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classifyDo;
	}

}
