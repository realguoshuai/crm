package com.zhiyou100.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



/** 
 * @ClassName: DBUtil 
 * @Description: 数据库工具类
 * @author: guoshuai
 * @date: 2017年12月4日 下午4:47:14  
 */
public enum DBUtil {
	/**
	 * @fieldName: INSTANCE
	 * @fieldType: DBUtil
	 * @Description: TODO
	 */
	INSTANCE;
	private String url;
	private String user;
	private String password;
	private String driverClass;

	private DBUtil() {

		Properties properties = new Properties();
		try {
			properties.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			driverClass=properties.getProperty("jdbc.driverClass");
			url = properties.getProperty("jdbc.url");
			user = properties.getProperty("jdbc.user");
			password = properties.getProperty("jdbc.password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		//加载驱动
		Class.forName(driverClass);
		//建立连接
		Connection conn= DriverManager.getConnection(url, user, password);
		//返回连接对象
		return conn;
	}
}
