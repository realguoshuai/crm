package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.crypto.provider.RSACipher;
import com.zhiyou100.dao.NoticeDao;
import com.zhiyou100.entity.NoticeDo;
import com.zhiyou100.util.DBUtil;
import com.zhiyou100.util.NoticeSearchTypeName;

public class NoticeDaoImpl implements NoticeDao {

	@Override
	public List<NoticeDo> listNotice(long pageIndex) {
		List<NoticeDo> list = new ArrayList<NoticeDo>();
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "SELECT n.id,u.name,n.title,d.name,n.content,n.begin_time,n.end_time FROM notice as n,user as u,department as d "
					+ "WHERE n.is_delete =0 AND n.user_id =u.id AND n.department_id=d.id LIMIT ?,5";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setLong(1, pageIndex);
				try (ResultSet executeQuery = prepareStatement.executeQuery();) {
					while (executeQuery.next()) {
						NoticeDo noticeDo = new NoticeDo();
						noticeDo.setId(executeQuery.getLong(1));
						noticeDo.setUserName(executeQuery.getString(2));
						noticeDo.setContent(executeQuery.getString(3));
						noticeDo.setDepartmentName(executeQuery.getString(4));
						noticeDo.setContent(executeQuery.getString(5));
						noticeDo.setBeginTime(executeQuery.getDate(6));
						noticeDo.setEndTime(executeQuery.getDate(7));
						list.add(noticeDo);
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
	public long countNotice() {
		long count = 0;
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "SELECT COUNT(*) FROM notice as n, user as u, department as d WHERE n.is_delete = 0 AND n.user_id = u.id AND n.department_id = d.id;";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				try (ResultSet executeQuery = prepareStatement.executeQuery();) {
					while (executeQuery.next()) {
						count = executeQuery.getInt(1);
					}
				}

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<NoticeDo> listNotice(String keyword, NoticeSearchTypeName type, long pageIndex) {
		ArrayList<NoticeDo> list = new ArrayList<NoticeDo>();
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = null;
			switch (type) {
			case NOTICE_TITLE:
				sql = "SELECT n.id, u.name, n.title, d.name, n.content, n.begin_time, n.end_time FROM notice as n, user as u, department as d WHERE n.is_delete = 0 AND n.title like ? AND n.user_id = u.id AND n.department_id = d.id LIMIT ?, 5;";
				break;
			case NOTICE_CONTENT:
				sql = "SELECT n.id, u.name, n.title, d.name, n.content, n.begin_time, n.end_time FROM notice as n, user as u, department as d WHERE n.is_delete = 0 AND n.content like ? AND n.user_id = u.id AND n.department_id = d.id LIMIT ?, 5;";
				break;
			case USER_NAME:
				sql = "SELECT n.id, u.name, n.title, d.name, n.content, n.begin_time, n.end_time FROM notice as n, user as u, department as d WHERE n.is_delete = 0 AND u.name like ? AND n.user_id = u.id AND n.department_id = d.id  LIMIT ?, 5;";
				break;
			case DEPARTMENT_NAME:
				sql = "SELECT n.id, u.name, n.title, d.name, n.content, n.begin_time, n.end_time FROM notice as n, user as u, department as d WHERE n.is_delete = 0 AND d.name like ? AND n.user_id = u.id AND n.department_id = d.id LIMIT ?, 5;";
				break;

			default:
				break;
			}
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
				preparedStatement.setString(1, "%" + keyword + "%");
				preparedStatement.setLong(2, pageIndex);
				try (ResultSet executeQuery = preparedStatement.executeQuery();) {
					while (executeQuery.next()) {
						NoticeDo noticeDo = new NoticeDo();
						noticeDo.setId(executeQuery.getLong(1));
						noticeDo.setUserName(executeQuery.getString(2));
						noticeDo.setTitle(executeQuery.getString(3));
						noticeDo.setDepartmentName(executeQuery.getString(4));
						noticeDo.setContent(executeQuery.getString(5));
						noticeDo.setBeginTime(executeQuery.getDate(6));
						noticeDo.setEndTime(executeQuery.getDate(7));
						list.add(noticeDo);
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
	public long countNotice(String keyword, NoticeSearchTypeName type) {
		long count = 0;
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "";
			switch (type) {
			case NOTICE_CONTENT:
				sql = "SELECT COUNT(*) FROM notice as n, user as u, department as d WHERE n.is_delete = 0 AND n.title like ? AND n.user_id = u.id AND n.department_id = d.id;";
				break;
			case NOTICE_TITLE:
				sql = "SELECT COUNT(*) FROM notice as n, user as u, department as d WHERE n.is_delete = 0 AND n.title like ? AND n.user_id = u.id AND n.department_id = d.id;";
				break;
			case USER_NAME:
				sql = "SELECT COUNT(*) FROM notice as n, user as u, department as d WHERE n.is_delete = 0 AND n.title like ? AND n.user_id = u.id AND n.department_id = d.id;";
				break;
			case DEPARTMENT_NAME:
				sql = "SELECT COUNT(*) FROM notice as n, user as u, department as d WHERE n.is_delete = 0 AND n.title like ? AND n.user_id = u.id AND n.department_id = d.id;";
				break;
			default:
				break;
			}
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setString(1, "%" + keyword + "%");
				try (ResultSet executeQuery = prepareStatement.executeQuery();) {
					while (executeQuery.next()) {
						count = executeQuery.getLong(1);
					}
				}

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public NoticeDo getNoticeById(long id) {
		NoticeDo noticeDo = null;
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "SELECT n.id, u.name, n.title, d.name, n.content, n.begin_time, n.end_time, d.id FROM notice as n, user as u, department as d WHERE n.is_delete = 0 AND n.id = ? AND n.user_id = u.id AND n.department_id = d.id;";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setLong(1, id);
				try (ResultSet executeQuery = prepareStatement.executeQuery();) {
					while (executeQuery.next()) {
						noticeDo = new NoticeDo();
						noticeDo.setId(executeQuery.getLong(1));
						noticeDo.setUserName(executeQuery.getString(2));
						noticeDo.setTitle(executeQuery.getString(3));
						noticeDo.setDepartmentName(executeQuery.getString(4));
						noticeDo.setContent(executeQuery.getString(5));
						noticeDo.setBeginTime(executeQuery.getDate(6));
						noticeDo.setEndTime(executeQuery.getDate(7));
						noticeDo.setDepartmentId(executeQuery.getLong(8));
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noticeDo;
	}

	@Override
	public void addNotice(NoticeDo notice) {
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "INSERT INTO notice(user_id, title, department_id, content, begin_time, end_time) VALUES (?, ?, ?, ?, ?, ?);";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setLong(1, notice.getUserId());
				prepareStatement.setString(2, notice.getTitle());
				prepareStatement.setLong(3, notice.getDepartmentId());
				prepareStatement.setString(4, notice.getContent());
				prepareStatement.setDate(5, notice.getBeginTime());
				prepareStatement.setDate(6, notice.getEndTime());
				
				prepareStatement.executeUpdate();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateNotice(NoticeDo notice) {
try (Connection conn = DBUtil.INSTANCE.getConnection();){
			
			String sql = "UPDATE notice SET user_id = ?, title = ?, department_id = ?, contnent = ?, begin_time = ?, end_time = ?;";
			
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				
				preparedStatement.setLong(1, notice.getUserId());
				preparedStatement.setString(2, notice.getTitle());
				preparedStatement.setLong(3, notice.getDepartmentId());
				preparedStatement.setString(4, notice.getContent());
				preparedStatement.setDate(5, notice.getBeginTime());
				preparedStatement.setDate(6, notice.getEndTime());
				
				preparedStatement.executeUpdate();
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


	@Override
	public void deleteNotice(long id) {
try (Connection conn = DBUtil.INSTANCE.getConnection();){
			
			String sql = "UPDATE notice SET is_delete = 1 WHERE id = ?;";
			
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql);) {
				
				preparedStatement.setLong(1, id);
				
				preparedStatement.executeUpdate();
			}
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}
	}
}
