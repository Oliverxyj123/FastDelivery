package com.tboys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tboys.dao.DeliveryDanManageDao;
import com.tboys.model.DeliveryDan;
import com.tboys.model.User;

public class DeliveryDanManageDaoImpl implements DeliveryDanManageDao{
	
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public DeliveryDanManageDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public boolean insertDelivery(DeliveryDan dan) {
		String sql = "insert into delivery(id, delivery_company_name,delivery_num"
				+ "delivery_time, delivery_company_image, users_id, delivery_message)"
				+ "values(seq_delivery_dan.nextval,?,?,?,?,seq_users_id.nextval,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, dan.getDelivery_company_name());
			pst.setString(2, dan.getDelivery_num());
			pst.setString(3, dan.getDelivery_time());
			pst.setString(4, dan.getDelivery_company_image());
			pst.setString(5, dan.getDelivery_message());
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean removeDelivery(DeliveryDan dan) {
		String sql = "delete delivery where delivery_num=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, dan.getDelivery_num());
			if(pst.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<DeliveryDan> findDelivery(User user) {
		// TODO Auto-generated method stub
		ArrayList<DeliveryDan> list = new ArrayList<>();
		String sql = "select delivery_company_name,delivery_num"
				+ "delivery_time, delivery_company_image, users_id, delivery_message from delivery_dan where users_id=?";
		try {
			pst = conn.prepareStatement(sql);
			UserManageDaoImpl umdi = new UserManageDaoImpl(conn);
			int user_id = umdi.QueryId(user);
			pst.setInt(1, user_id);
			rs = pst.executeQuery();
			while(rs.next()) {
				String delivery_company_name = rs.getString(0);
				String delivery_num = rs.getString(1);
				String delivery_time = rs.getString(2);
				String delivery_company_image = rs.getString(3);
				int users_id = rs.getInt(4);
				String delivery_message = rs.getString(5);
				list.add(new DeliveryDan(delivery_company_name, delivery_num, delivery_time, delivery_company_image, users_id, delivery_message));
			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return list;
	}

}
