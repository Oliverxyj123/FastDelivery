package com.tboys.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.tboys.dao.DoRegisterDao;
import com.tboys.model.User;

public class DoRegisterDaoImpl implements DoRegisterDao{

	UserManageDaoImpl dumi;
	
	public DoRegisterDaoImpl(Connection conn) {
		super();
		dumi = new UserManageDaoImpl(conn);
	}

	@Override
	public boolean judgeRegisterUser(User user) {
	
		try {
			dumi.save(user);
		} catch (SQLException e) {
			System.out.println("���ֻ��ѱ�ע��,�����");
			e.printStackTrace();
		}
		
		return true;
	}

}
