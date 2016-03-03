package com.tboys.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.tboys.dao.DoLoginDao;
import com.tboys.model.User;

public class DoLoginDaoImpl implements DoLoginDao{

	UserManageDaoImpl dumi;
	
	public DoLoginDaoImpl(Connection conn) {
		super();
		dumi = new UserManageDaoImpl(conn);
	}

	@Override
	public boolean judgeLoginUser(User user) {
		String account = user.getAccout();
		String password = user.getPassword();
		
		//从数据库查询,并判断
		try {
			User u = dumi.find(account);
			if(u.getPassword().equals(password)){
				System.out.println("登陆成功");
			}
		} catch (SQLException e) {
			System.out.println("用户名或密码错误");
			e.printStackTrace();
		}
		
		return false;
	}

}
