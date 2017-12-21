package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.dao.EmailDao;
import com.zhiyou100.entity.EmailDO;
import com.zhiyou100.util.DBUtil;

public class EmailDaoImpl implements EmailDao {

	@Override
	public void sendEmail(EmailDO email) {
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "insert into email (title,content,send_user_id,receive_user_id,send_time,send_location,receive_location)values(?,?,?,?,?,2,1);";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setString(1, email.getTitle());
				prepareStatement.setString(2, email.getContent());
				prepareStatement.setLong(3, email.getSendUserId());
				prepareStatement.setLong(4, email.getReceiveUserId());
				prepareStatement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));

				prepareStatement.executeUpdate();
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void saveEmail(EmailDO email) {
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "insert into email (title,content,send_user_id,receive_user_id,send_location)values(?,?,?,?,1);";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setString(1, email.getTitle());
				prepareStatement.setString(2, email.getContent());
				prepareStatement.setLong(3, email.getSendUserId());
				prepareStatement.setLong(4, email.getReceiveUserId());

				prepareStatement.executeUpdate();
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void sendSaveEmail(EmailDO email) {
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "UPDATE email SET title = ?, content = ?, send_time = ?, send_location = 2, receive_location = 1 WHERE id = ?;";

			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setString(1, email.getTitle());
				prepareStatement.setString(2, email.getContent());
				prepareStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
				prepareStatement.setLong(4, email.getId());

				prepareStatement.executeUpdate();
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public EmailDO getEmailById(long id) {
		EmailDO email = null;
		String sql = "SELECT title, content, receive_user_id, send_location, receive_location WHERE id = ?;";
		try (Connection conn = DBUtil.INSTANCE.getConnection();) {
			try (PreparedStatement ps = conn.prepareStatement(sql);) {

				ps.setLong(1, id);

				try (ResultSet rs = ps.executeQuery();) {

					while (rs.next()) {

						email = new EmailDO();

						email.setTitle(rs.getString(1));
						email.setContent(rs.getString(2));
						email.setReceiveUserId(rs.getLong(3));
						email.setSendLocation(rs.getInt(4));
						email.setReceiveLocation(rs.getInt(5));
					}
				}
			}
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

		return email;
	}

	@Override
	public List<EmailDO> listDarftBox(long userId) {
		List<EmailDO> emailDOs = new ArrayList<EmailDO>();
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "SELECT e.id, u.name, e.title, e.send_time FROM email as e, user as u WHERE e.send_user_id = ? AND e.send_location = 1 AND e.receive_user_id = u.id;";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setLong(1, userId);
				ResultSet executeQuery = prepareStatement.executeQuery();
				while (executeQuery.next()) {
					EmailDO emailDO = new EmailDO();
					emailDO.setId(executeQuery.getLong(1));
					emailDO.setReceiceUserName(executeQuery.getString(2));
					emailDO.setTitle(executeQuery.getString(3));
					emailDO.setSendTime(executeQuery.getTimestamp(4));
					emailDOs.add(emailDO);
				}
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return emailDOs;
	}

	@Override
	public List<EmailDO> listSendBox(long userId) {
		List<EmailDO> emailDOs = new ArrayList<EmailDO>();
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "SELECT e.id, u.name, e.title, e.send_time FROM email as e, user as u WHERE e.send_user_id = ? AND e.send_location = 2 AND e.receive_user_id = u.id;";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setLong(1, userId);
				ResultSet executeQuery = prepareStatement.executeQuery();
				while (executeQuery.next()) {
					EmailDO emailDO = new EmailDO();
					emailDO.setId(executeQuery.getLong(1));
					emailDO.setReceiceUserName(executeQuery.getString(2));
					emailDO.setTitle(executeQuery.getString(3));
					emailDO.setSendTime(executeQuery.getTimestamp(4));
					emailDOs.add(emailDO);
				}
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return emailDOs;
	}

	@Override
	public List<EmailDO> listReceiveBox(long userId) {
		List<EmailDO> emailDOs = new ArrayList<EmailDO>();
		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "SELECT e.id, u.name, e.title, e.send_time FROM email as e, user as u WHERE e.receive_user_id = ? AND e.send_location = 1 AND e.receive_user_id = u.id;";
			try (PreparedStatement prepareStatement = connection.prepareStatement(sql);) {
				prepareStatement.setLong(1, userId);
				ResultSet executeQuery = prepareStatement.executeQuery();
				while (executeQuery.next()) {
					EmailDO emailDO = new EmailDO();
					emailDO.setId(executeQuery.getLong(1));
					emailDO.setReceiceUserName(executeQuery.getString(2));
					emailDO.setTitle(executeQuery.getString(3));
					emailDO.setSendTime(executeQuery.getTimestamp(4));
					emailDOs.add(emailDO);
				}
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return emailDOs;
	}

	@Override
	public List<EmailDO> listRubbishBox(long userId) {
		ArrayList<EmailDO> list = new ArrayList<EmailDO>();

		try (Connection connection = DBUtil.INSTANCE.getConnection();) {
			String sql = "SELECT e.id, u1.name, u2.name, e.title, e.send_time FROM email as e, user as u1, user as u2 WHERE ((e.send_user_id = ? AND e.send_location = 3) OR (e.receive_user_id = ? AND e.receive_location = 2)) AND e.send_user_id = u1.id AND e.receive_user_id = u2.id;";

			try (PreparedStatement ps = connection.prepareStatement(sql);) {

				ps.setLong(1, userId);
				ps.setLong(2, userId);

				try (ResultSet rs = ps.executeQuery();) {

					while (rs.next()) {

						EmailDO email = new EmailDO();

						email.setId(rs.getLong(1));
						email.setSendUserName(rs.getString(2));
						email.setReceiceUserName(rs.getString(3));
						email.setTitle(rs.getString(4));
						email.setSendTime(rs.getTimestamp(5));

						list.add(email);
					}
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void removeSendToRubbishBox(long id) {
		// 删除发送邮件到垃圾箱
		try (Connection conn = DBUtil.INSTANCE.getConnection();) {

			String sql = "UPDATE email SET send_location = 3 WHERE id = ?;";

			try (PreparedStatement ps = conn.prepareStatement(sql);) {

				ps.setLong(1, id);

				ps.executeUpdate();
			}
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void removeReceiveToRubbishBox(long id) {
		try (Connection conn = DBUtil.INSTANCE.getConnection();) {

			String sql = "UPDATE email SET reveive_location = 2 WHERE id = ?;";

			try (PreparedStatement ps = conn.prepareStatement(sql);) {

				ps.setLong(1, id);

				ps.executeUpdate();
			}
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void cleanRubbishBox(EmailDO email) {
		try (Connection conn = DBUtil.INSTANCE.getConnection();) {

			String sql = "UPDATE email SET is_delete = 1 WHERE id = ?;";

			try (PreparedStatement ps = conn.prepareStatement(sql);) {

				ps.setLong(1, email.getId());

				ps.executeUpdate();
			}
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void undoRemove(EmailDO email) {
		try (Connection conn = DBUtil.INSTANCE.getConnection();) {

			String sql = "UPDATE email SET is_delete = 0 WHERE id = ?;";

			try (PreparedStatement ps = conn.prepareStatement(sql);) {

				ps.setLong(1, email.getId());

				ps.executeUpdate();
			}
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

}
