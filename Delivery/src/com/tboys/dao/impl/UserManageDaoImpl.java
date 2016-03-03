package com.tboys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tboys.dao.UserManageDao;
import com.tboys.listner.AppListner;
import com.tboys.model.User;
import com.tboys.util.DbHelper;

public class UserManageDaoImpl implements UserManageDao{

	private PreparedStatement state;
	private ResultSet result;
	private String sql;
	
	private Connection conn;
	
	public UserManageDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	//注册账号
	@Override
	public boolean save(User user) throws SQLException {
		// TODO Auto-generated method stub
		sql = "insert into Users(id,account,password) values(seq_users_id.NEXTVAL,?,?)";
		state = conn.prepareStatement(sql);
		state.setString(1, user.getAccout());
		state.setString(2, user.getPassword());
		boolean rigister = state.execute();
		conn.close();;
		return rigister;
	}

	/**
	 * 更新单个用户
	 */
	@Override
	public int update(User user) throws SQLException {
		sql = "update Users set password = ? where account = ?";
		state = conn.prepareStatement(sql);
		state.setString(1, user.getPassword());
		state.setString(2, user.getAccout());
		int n = state.executeUpdate();
		conn.close();
		return n;
	}

	@Override
	public void remove(User user) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 查询单个
	 */
	@Override
	public User find(String account) throws SQLException {
		User user = new User();
		sql = "select * from users where account = ?";
		state = conn.prepareStatement(sql);
		state.setString(1, account);
		result = state.executeQuery();
		if(result.next()) {		
			user.setAccout(account);
			user.setPassword(result.getString(2));
		}
		conn.close();
		return user;
	}
	
	@Override
	public int QueryId(User user) throws SQLException {
		sql = "select userId from users where account = ?";
		state = conn.prepareStatement(sql);
		int n = 0;
		state = conn.prepareStatement(sql);
		state.setString(1,user.getAccout());
		result = state.executeQuery();
		if(result.next()) {
			n = result.getInt(0);
		}
		state.close();
		result.close();
		return n;
	}
}
