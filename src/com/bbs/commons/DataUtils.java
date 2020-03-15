package com.bbs.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库工具类
 * @author lindy
 *
 */
public class DataUtils {
	// 1.创建需要用到的字符串变量，并赋值
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bbs?"
			+ "characterEncoding=UTF-8&useUnicode=true";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	// 2.创建一个获得数据库连接的方法
	public static Connection createConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 3.创建一个释放资源的方法
	public static void closeAll(Connection conn,PreparedStatement pst
			,ResultSet rs) {
		try {
			if(rs != null)
				rs.close();
			if(pst != null)
				pst.close();
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 4.创建通用的增、删、改方法
	public static int executeUpdate(String sql,Object ... parms) {
		Connection conn = createConnection();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			// 如果参数数据不为空
			if (parms != null) {
				// 为占位符赋值
				for (int i = 0; i < parms.length; i++) {
					pst.setObject((i+1), parms[i]);
				}
			}
			// 调用方法并返回结果
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(conn, pst, null);
		}
		return 0;
	}
	
	// 5.创建通用的查询方法
	public static ResultSet queryAll(String sql,Object ... params) {
		ResultSet rs = null;
		Connection conn = createConnection();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			// 如果参数数据不为空
			if (params != null) {
				// 为占位符赋值
				for (int i = 0; i < params.length; i++) {
					pst.setObject((i+1), params[i]);
				}
			}
			rs = pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
