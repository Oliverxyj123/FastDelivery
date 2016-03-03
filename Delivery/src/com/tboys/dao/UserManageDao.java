package com.tboys.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.tboys.model.User;

public interface UserManageDao {

	/**
	 * 注册
	 * @param user
	 * @return 成功true
	 * @throws SQLException
	 */
	boolean save(User user) throws SQLException;
	
	/**
	 * 更新数据
	 * @param User user
	 * @throws SQLException
	 */
	int update(User user) throws SQLException;
	
	/**
	 * 删除数据
	 * @param User user
	 * @throws SQLException
	 */
	void remove(User user) throws SQLException;
	
	int QueryId(User user)throws SQLException;
	
	/**
	 * 查询数据  一条
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	User find(String account) throws SQLException;
	
	boolean find(User user) throws SQLException;
}
