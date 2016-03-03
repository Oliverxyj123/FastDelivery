package com.tboys.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbHelper {

	private static Connection conn;

	private static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";

	private static final String PASSWORD = "123456";

	//协议: ip:端口号:SID(数据库名)
	private static final String URL = "jdbc:oracle:thin:@192.168.43.86:1521:orcl";

	private static final String USER = "delivery";

	static {
		// 基于反射的
		try {
			// 加载指定的类(JDBC驱动)
			// 创建了该类的一个对象
			// Class cls = Class.forName(JDBC_DRIVER);
			Class.forName(JDBC_DRIVER);
			// cls.getAnnotations();
			// cls.getDeclaredMethods();
			// cls.getConstructors();
			// cls.getDeclaredFields();

			// Object obj = cls.newInstance();
			// Method m = cls.getMethod("setDate", Long.class, String.class);
			// m.invoke(obj, 10, "22");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 创建一个新的连接
	 * 
	 * @return 数据库连接
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {

		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
		return conn;
	}

	/**
	 * 释放资源 关闭连接,释放资源 关闭连接,语句, 结果集
	 * 
	 * @param connection
	 *            数据库连接
	 * @param statement
	 *            SQL 语句
	 * @param resultSet
	 *            结果集
	 * @throws SQLException
	 *             SQL 异常
	 */
	public static void close(
			ResultSet rs, 
			Statement stat, 
			Connection conn) throws SQLException {
		
		if (rs != null) {
			rs.close();
		}
		
		if (stat != null) {
			stat.close();
		}
		
		if (conn != null) {
			conn.close();
		}
	}
}
