package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zhiyou100.dao.DepartmentDao;
import com.zhiyou100.entity.DepartmentDo;
import com.zhiyou100.util.DBUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public List<DepartmentDo> listDepartment() {
		List<DepartmentDo> list =new ArrayList<DepartmentDo>();
		try(Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql ="SELECT id,name,description,gmt_modified from department where is_delete=0;";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			try(ResultSet executeQuery = prepareStatement.executeQuery();){
				while(executeQuery.next()){
					Long id =executeQuery.getLong("id");
					String name=executeQuery.getString("name");
					String description=executeQuery.getString("description");
					Date gmtModified=executeQuery.getDate("gmt_modified");
					DepartmentDo departmentDo = new DepartmentDo(id, name, description, gmtModified);
					list.add(departmentDo);
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
	public DepartmentDo getDepartmentById(long id) {
		DepartmentDo departmentDo =null;
		try(Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql ="SELECT name,description,gmt_modified from department where id=?;";
			try(PreparedStatement prepareStatement = connection.prepareStatement(sql);){
				prepareStatement.setLong(1, id);
				try(ResultSet executeQuery = prepareStatement.executeQuery();){
					while(executeQuery.next()){
						String name = executeQuery.getString("name");
						String description = executeQuery.getString("description");
						Date gmtModified = executeQuery.getDate("gmt_modified");
						departmentDo = new DepartmentDo(id, name, description, gmtModified);
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
		return departmentDo;
	}

	@Override
	public void addDepartment(String name, String description) {
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "INSERT INTO department (name,description) values(?,?);";
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
	public void updateDepartment(long id, String name, String description) {
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "UPDATE department SET name = ?,description = ? where id = ?;";
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

	
	@Override
	public void deleteDepartment(long id) {
		try(Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql ="UPDATE  department SET is_delete=1 where id= ? ;";
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

}
