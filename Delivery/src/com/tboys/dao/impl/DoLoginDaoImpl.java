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
		
		//�����ݿ��ѯ,���ж�
		try {
			User u = dumi.find(account);
			if(u.getPassword().equals(password)){
				System.out.println("��½�ɹ�");
			}
		} catch (SQLException e) {
			System.out.println("�û������������");
			e.printStackTrace();
		}
		
		return false;
	}

}
